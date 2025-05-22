/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MONGO.DAOS;

import Exception.PersistenciaException;
import Interfaces.IGastoDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import conexion.ConexionMongo;
import entidades.Gasto;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Esta clase permite realizar operaciones CRUD y consultas filtradas sobre gastos.
 *
 * Usa la coleccion "Gastos" en la base de datos Mongo.
 *
 * metodos disponibles son: agregar, eliminar, modificar, buscar por
 * folio y consultar gastos con filtros.
 *
 * @author Admin
 */
public class GastoMongoDAO implements IGastoDAO{
    private final MongoCollection<Gasto> coleccion;

    /**
     * Crea una nueva instancia de GastoMongoDAO y obtiene la coleccion de
     * gastos desde la base de datos Mongo.
     */
    public GastoMongoDAO() {
        this.coleccion = ConexionMongo.getDatabase().getCollection("Gastos", Gasto.class);
    }

    /**
     * Metodo que agrega un nuevo gasto a la BD. 
     * Si el gasto no tiene un id asignado se le asigna uno automaticamente
     *
     * @param gasto el gasto que se desea agregar
     * @return el gasto agregado
     * @throws PersistenciaException si ocurre un error al insertar el gasto
     */
    @Override
    public Gasto agregarGasto(Gasto gasto) throws PersistenciaException {
        try {
            // Asignar un nuevo _id si esta en null
            if (gasto.getId() == null) {
                gasto.setId(new ObjectId().getTimestamp());
            }

            coleccion.insertOne(gasto);
            return gasto;
        } catch (Exception e) {
            throw new PersistenciaException("Error al agregar el gasto: " + e.getLocalizedMessage());
        }
    }

    /**
     * Metodo que elimina un gasto de la BD usando su folio.
     *
     * @param folio el folio del gasto a eliminar
     * @throws PersistenciaException si ocurre un error o si no se encuentra el gasto
     */
    @Override
    public void eliminarGasto(String folio) throws PersistenciaException {
        try {
            Bson gastoEncontrado = eq("folio", folio); 
            DeleteResult resultado = coleccion.deleteOne(gastoEncontrado);

            if (resultado.getDeletedCount() == 0) {
                throw new PersistenciaException("No se encontro un gasto con el folio: " + folio);
            }

        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar gasto: " + e.getMessage());
        }
    }

    /**
     * Metodo que modifica un gasto existente en la BD. 
     * Se busca por el id del gasto
     *
     * @param gasto el gasto con los nuevos datos
     * @return el gasto modificado
     * @throws PersistenciaException si el gasto no tiene ID o no se encuentra
     */
    @Override
    public Gasto modificarGasto(Gasto gasto) throws PersistenciaException {
        try {
            if (gasto.getId() == null) {
                throw new PersistenciaException("No existe un gasto con ese id");
            }

            Bson gastoEncontrado = eq("codigo", gasto.getId());

            Bson gastoActualizado = combine(
                    set("folio", gasto.getFolio()),
                    set("fechaGasto", gasto.getFechaGasto()),
                    set("categoria", gasto.getCategoria()),
                    set("proveedor", gasto.getProveedor()),
                    set("concepto", gasto.getConcepto()),
                    set("montoGasto", gasto.getMontoGasto()),
                    set("comprobante", gasto.getComprobante()),
                    set("metodoPago", gasto.getMetodoPago())
            );

            UpdateResult resultado = coleccion.updateOne(gastoEncontrado, gastoActualizado);

            if (resultado.getMatchedCount() == 0) {
                throw new PersistenciaException("No se encontro el gasto con id: " + gasto.getId());
            }

            return gasto;

        } catch (Exception e) {
            throw new PersistenciaException("Error al modificar gasto: " + e.getMessage());
        }
    }
    
    /**
     * Metodo que consulta una lista de gastos usando filtros de categoria, metodo de pago y/o un rango de fechas.
     * Si se ingresan un gasto vacio y fechas nulas regresa todos los gastos registrados en la BD
     * 
     * @param gastoFiltro objeto con los campos a filtrar (categoria, metodoPago)
     * @param fechaInicio fecha de inicio del rango (puede ser null)
     * @param fechaFin fecha de fin del rango (puede ser null)
     * @return una lista con los gastos que cumplen los filtros
     * @throws PersistenciaException si ocurre un error en la consulta
     */
    @Override
    public List<Gasto> consultarGastosFiltrados(Gasto gastoFiltro, LocalDate fechaInicio, LocalDate fechaFin) throws PersistenciaException {
        
        try {
            List<Bson> filtros = new ArrayList<>();

            if (gastoFiltro.getMetodoPago() != null && !gastoFiltro.getMetodoPago().isEmpty()) {//filtro para metodo de pago
                filtros.add(eq("metodoPago", gastoFiltro.getMetodoPago()));
            }

            if (gastoFiltro.getCategoria() != null && !gastoFiltro.getCategoria().isEmpty()) {//filtro para categoria
                filtros.add(eq("categoria", gastoFiltro.getCategoria()));
            }

            if (fechaInicio != null && fechaFin != null) {
                filtros.add(Filters.and(
                        Filters.gte("fechaGasto", Date.from(fechaInicio.atStartOfDay(ZoneOffset.UTC).toInstant())),
                        Filters.lte("fechaGasto", Date.from(fechaFin.atStartOfDay(ZoneOffset.UTC).toInstant()))
                ));
            } else if (fechaInicio != null) {
                // Solo fecha inicio
                filtros.add(Filters.gte("fechaGasto", Date.from(fechaInicio.atStartOfDay(ZoneOffset.UTC).toInstant())));
            } else if (fechaFin != null) {
                // Solo fecha fin
                filtros.add(Filters.lte("fechaGasto", Date.from(fechaFin.atStartOfDay(ZoneOffset.UTC).toInstant())));
            }

            //filtros.isEmpty() ? new org.bson.Document() es que si la lista de filtros esta vacia devolvera todos los documentos, osea q no filtrara nada
            //Filters.and(filtros) combina todos los filtros guardados en "filtros" y por lo tanto se aplican todos al mismo tiempo lo cual regresaria los documentos filtrados
            Bson gastosFiltrados = filtros.isEmpty() ? new org.bson.Document() : Filters.and(filtros);

            //aqui se ejecuta la consulta en la coleccion MongoDB usando el filtro construido "filtros"
            return coleccion.find(gastosFiltrados).into(new ArrayList<>());

            //.into(new ArrayList<>()) copia todos los resultados en una nueva lista (ArrayList), que es lo que devuelve el metodo            
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar gastos filtrados: " + e.getLocalizedMessage());
        }


    }
    
    /**
     * Metodo que busca un gasto por su folio.
     *
     * @param folio el folio del gasto a buscar
     * @return el gasto encontrado, o null si no se encuentra
     * @throws PersistenciaException si ocurre un error en la busqueda
     */
    @Override
    public Gasto buscarPorFolio(String folio) throws PersistenciaException {
        try {
            return coleccion.find(eq("folio", folio)).first();
            
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar gasto por folio: " + e.getLocalizedMessage());
        }
    }
    
}
