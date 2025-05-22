/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gasto;

import Adapters.AdaptadorGasto;
import DTOs.CrearGastoDTO;
import DTOs.GastoDTO;
import EstrategiaReporte.ReporteService;
import Exception.GastoException;
import Exception.NegocioException;
import IAdapters.IAdapterGasto;
import Interfaces.IGastoBO;
import java.awt.Desktop;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que se encarga de registrar, consultar, modificar, eliminar y generar reportes de gastos. 
 *
 * Usa una capa de negocio para trabajar con los datos y tambien puede generar un PDF con los gastos.
 * 
 * @author Admin
 */
public class RegistrarGasto implements IRegistrarGasto {

    private final IGastoBO gastoBO = manejadoresBO.ManejadorObjetosNegocio.crearGastoBO();
    private final IAdapterGasto adaptadorGasto = new AdaptadorGasto();
    CrearGastoDTO gastoPasable;

    private static ReporteService realizarReporte = new ReporteService();

    /**
     * Este metodo agrega un nuevo gasto al sistema despues de validar sus datos.
     * Valida que el gasto no sea null, que el folio sea de menos de 16 digitos y sea obligatorio,
     * valida tambien que el monto sea positivo y que el folio no exista para poder insertarlo
     *
     * @param gastoDTO Objeto con la informacion del gasto a registrar
     * @return GastoDTO que representa el gasto agregado
     * @throws GastoException Si ocurre un error durante la validacion o el proceso de registro.
     * 
     */
    @Override
    public GastoDTO agregarGasto(CrearGastoDTO gastoDTO) throws GastoException {
        try {
            if (gastoDTO == null) {
                throw new NegocioException("Los datos del gasto no pueden ser nulos.");
            }
            // Ejemplo de validación de campos requeridos
            if (gastoDTO.getFolio() == null || gastoDTO.getFolio().isEmpty()) {
                throw new NegocioException("El folio del gasto es obligatorio.");
            }
            if (gastoDTO.getMontoGasto() == null || gastoDTO.getMontoGasto() <= 0) {
                throw new NegocioException("El monto del gasto debe ser mayor que cero.");
            }
            if (gastoDTO.getFolio().length()>16) {
                throw new NegocioException("El folio debe de tener menos de 16 digitos");
            }
            
            GastoDTO existente = gastoBO.buscarPorFolio(gastoDTO.getFolio());
            if (existente != null) {
                throw new NegocioException("Ya existe un gasto con ese folio.");
            }

            return gastoBO.agregarGasto(gastoDTO);
        } catch (NegocioException ex) {
            throw new GastoException("Error al agregar gasto: " + ex.getLocalizedMessage());
        }
    }
    
    /**
     * Elimina un gasto por su folio.
     *
     * @param folio Identificador único del gasto a eliminar.
     * @throws GastoException Si ocurre un error durante la eliminación.
     */
    @Override
    public void eliminarGasto(String folio) throws GastoException {
        try {
            gastoBO.eliminarGasto(folio);
        } catch (NegocioException ex) {
            throw new GastoException("Error al consultar gastos" + ex.getLocalizedMessage());
        }
    }

    /**
     * Este metodo modifica la informacion de un gasto existente.
     *
     * @param gastoDTO Objeto con los nuevos datos del gasto.
     * @return Gasto modificado como {@code GastoDTO}.
     * @throws GastoException Si ocurre un error durante la modificación.
     */
    @Override
    public GastoDTO modificarGasto(GastoDTO gastoDTO) throws GastoException {
        try {
            return gastoBO.modificarGasto(gastoDTO);
        } catch (NegocioException ex) {
            throw new GastoException("Error al consultar gastos" + ex.getLocalizedMessage());
        }
    }

    /**
     * Consulta todos los gastos registrados en el sistema.
     *
     * @return Lista de objetos de tipo GastoDTO
     * @throws GastoException Si ocurre un error durante la consulta.
     */
    @Override
    public List<GastoDTO> consultarGastos() throws GastoException {
        try {
            return gastoBO.consultarGastos();
        } catch (NegocioException ex) {
            throw new GastoException("Error al consultar gastos" + ex.getLocalizedMessage());
        }
    }

    /**
     * Este metodo consulta los gastos que coincidan con los filtros establecidos.
     * los filtros que se pueden establecere son categoria, metodo de pago y/o un rango de fechas. 
     * Si se ingresa un gasto vacio y fechas nulas regresa todos los gastos registrados en la BD
     *
     * @param gastoFiltro Objeto con los criterios de búsqueda.
     * @param fechaInicio Fecha de inicio del filtro.
     * @param fechaFin Fecha de fin del filtro.
     * @return Lista de gastos filtrados.
     * @throws GastoException Si ocurre un error al aplicar los filtros o
     * realizar la consulta.
     */
    @Override
    public List<GastoDTO> consultarGastosFiltrados(CrearGastoDTO gastoFiltro, LocalDate fechaInicio, LocalDate fechaFin) throws GastoException {
        try {
            return gastoBO.consultarGastosFiltrados(gastoFiltro, fechaInicio, fechaFin);
        } catch (NegocioException e) {
            throw new GastoException("Error al consultar gastos filtrados" + e.getLocalizedMessage());
        }
    }

    /**
     * Este metodo obtiene el gasto que actualmente esta listo para pasarse entre pantallas o procesos.
     *
     * @return Objeto CrearGastoDTO almacenado temporalmente.
     */
    public CrearGastoDTO getGastoPasable() {
        return gastoPasable;
    }

    /**
     * Este metodo define el gasto que estara disponible para ser pasado entre pantallas o procesos.
     *
     * @param gastoPasable Gasto a almacenar temporalmente.
     */
    public void setGastoPasable(CrearGastoDTO gastoPasable) {
        this.gastoPasable = gastoPasable;
    }

    /**
     * Este metodo busca un gasto registrado por su folio.
     *
     * @param folio Folio del gasto a buscar.
     * @return Objeto GastoDTO si se encuentra.
     * @throws GastoException Si ocurre un error durante la busqueda.
     */
    @Override
    public GastoDTO buscarPorFolio(String folio) throws GastoException {
        try {
            return gastoBO.buscarPorFolio(folio);
        } catch (NegocioException ex) {
            throw new GastoException("Error al consultar gastos" + ex.getLocalizedMessage());
        }
    }

    /**
     * Genera un archivo PDF con los datos de los gastos proporcionados y lo abre
     * automaticamente si es posible.
     *
     * @param gastosDTO Lista de gastos que se incluiran en el PDF.
     * @throws RuntimeException Si ocurre un error al generar o abrir el archivo .pdf
     * 
     */
    @Override
    public void generarYMostrarPDFGasto(List<GastoDTO> gastosDTO) {
        byte[] pdfBytes = realizarReporte.generarPDFGasto(gastosDTO);
        try {
            Path tempFile = Files.createTempFile("ticket_venta_", ".pdf");
            Files.write(tempFile, pdfBytes);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(tempFile.toFile());
            } else {
                System.out.println("No se puede abrir el PDF automáticamente");
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error al guardar o abrir el PDF de la venta", ex);
        }
    }

}
