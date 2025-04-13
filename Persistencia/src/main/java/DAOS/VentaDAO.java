/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Entidades.Empleado;
import Entidades.MetodoPago;
import Entidades.Producto;
import Entidades.ProductoVenta;
import Entidades.Tarjeta;
import Entidades.Venta;
import Exception.PersistenciaException;
import Interfaces.IVentaDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public class VentaDAO implements IVentaDAO {

    /*
    Aqui debe ir el singleton.
    Constructor privado y atributo instancia
     */
    
    // Singleton: instancia privada y constructor privado
    private static VentaDAO instancia;

    private VentaDAO() {
    }

    public static VentaDAO obtenerInstancia() {
        if (instancia == null) {
            instancia = new VentaDAO();
        }
        return instancia;
    }
 /*
    Metodos de la interfaz.
     */
    @Override
    public Venta registrarVenta(Venta venta) throws PersistenciaException {
        Empleado cajero = new Empleado(1L, "Juan Soto", "Cajero");
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setNombreTitular("Miguelito miguelon");
        tarjeta.setCvv(344);
        tarjeta.setFechaVencimiento("20/02");
        tarjeta.setNumeroTarjeta("415231384223323");

        MetodoPago metodo = new MetodoPago(tarjeta);

        Producto producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Manzana");
        producto.setDescripcion("Manzana roja fresca");
        producto.setPrecio(25.50);
        producto.setEsPesable(true);
        producto.setUnidad(1.0);
        producto.setTexto("Fruta");

        ProductoVenta productoVenta = new ProductoVenta();
        productoVenta.setProducto(producto);
        productoVenta.setCantidad(2.5); // por ejemplo, 2.5 kg
        productoVenta.setPrecioUnitaro(producto.getPrecio());
        productoVenta.setImporte(producto.getPrecio() * productoVenta.getCantidad());

        List<ProductoVenta> listaProductosVenta = new ArrayList<ProductoVenta>();
        listaProductosVenta.add(productoVenta);
        return new Venta(1L, LocalDateTime.now(), cajero, 200, 200, 250, metodo, listaProductosVenta);

    }

    @Override
    public Venta consultarVenta(Long id) throws PersistenciaException {
        Empleado cajero = new Empleado(1L, "Juan Soto", "Cajero");
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setNombreTitular("Miguelito miguelon");
        tarjeta.setCvv(344);
        tarjeta.setFechaVencimiento("20/02");
        tarjeta.setNumeroTarjeta("415231384223323");

        MetodoPago metodo = new MetodoPago(tarjeta);

        Producto producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Manzana");
        producto.setDescripcion("Manzana roja fresca");
        producto.setPrecio(25.50);
        producto.setEsPesable(true);
        producto.setUnidad(1.0);
        producto.setTexto("Fruta");

        ProductoVenta productoVenta = new ProductoVenta();
        productoVenta.setProducto(producto);
        productoVenta.setCantidad(2.5); // por ejemplo, 2.5 kg
        productoVenta.setPrecioUnitaro(producto.getPrecio());
        productoVenta.setImporte(producto.getPrecio() * productoVenta.getCantidad());

        List<ProductoVenta> listaProductosVenta = new ArrayList<ProductoVenta>();
        listaProductosVenta.add(productoVenta);
        return new Venta(1L, LocalDateTime.now(), cajero, 200, 200, 250, metodo, listaProductosVenta);
    }
}
