/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import entidades.Venta;
import entidades.Empleado;
import entidades.MetodoPago;
import entidades.Producto;
import entidades.ProductoVenta;
import entidades.Tarjeta;
import Exception.PersistenciaException;
import Interfaces.IVentaDAO;
import entidades.Efectivo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public class VentaDAO implements IVentaDAO {

    private static VentaDAO instanceVentaDAO;

    public VentaDAO() {
    }

    /**
     * Devuelve la unica instancia de esta clase (patron Singleton). Si la
     * instancia no existe, la crea.
     *
     * @return la instancia unica de IngredienteDAO.
     */
    public static VentaDAO getInstanceDAO() {
        if (instanceVentaDAO == null) {
            instanceVentaDAO = new VentaDAO();
        }

        return instanceVentaDAO;
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
        producto.setId(1);
        producto.setNombre("Manzana");
        producto.setDescripcion("Manzana roja fresca");
        producto.setPrecio(25.50);
        producto.setEsPesable(true);
        producto.setUnidad(1.0);
        producto.setStock(5);

        ProductoVenta productoVenta = new ProductoVenta();
        productoVenta.setProducto(producto);
        productoVenta.setCantidad(2.5); // por ejemplo, 2.5 kg
        productoVenta.setPrecioUnitario(producto.getPrecio());
        productoVenta.setImporte(producto.getPrecio() * productoVenta.getCantidad());

        List<ProductoVenta> listaProductosVenta = new ArrayList<ProductoVenta>();
        listaProductosVenta.add(productoVenta);
        return new Venta(1, LocalDateTime.now(), cajero, 200, 200, 250, metodo, listaProductosVenta);

    }

    // este metodo lo meti aqui porque asi lo habiamos diagramado.
    public List<ProductoVenta> consultarProductosVenta() throws PersistenciaException {
        List<ProductoVenta> listaProductosVenta = new ArrayList<>();

        Producto producto = new Producto();
        producto.setId(1);
        producto.setNombre("Manzana");
        producto.setDescripcion("Manzana roja fresca");
        producto.setPrecio(25.50);
        producto.setEsPesable(true);
        producto.setUnidad(1.0);
        producto.setStock(2);

        ProductoVenta productoVenta = new ProductoVenta();
        productoVenta.setProducto(producto);
        productoVenta.setCantidad(1);
        productoVenta.setPrecioUnitario(producto.getPrecio());
        productoVenta.setImporte(producto.getPrecio() * productoVenta.getCantidad());

        listaProductosVenta.add(productoVenta);
        return listaProductosVenta;
    }

    /// TALVEZ ESTE METODO NI LO OCUPAMOS.
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
        producto.setId(1);
        producto.setNombre("Manzana");
        producto.setDescripcion("Manzana roja fresca");
        producto.setPrecio(25.50);
        producto.setEsPesable(true);
        producto.setUnidad(1.0);
        producto.setStock(1);

        ProductoVenta productoVenta = new ProductoVenta();
        productoVenta.setProducto(producto);
        productoVenta.setCantidad(2.5); // por ejemplo, 2.5 kg
        productoVenta.setPrecioUnitario(producto.getPrecio());
        productoVenta.setImporte(producto.getPrecio() * productoVenta.getCantidad());

        List<ProductoVenta> listaProductosVenta = new ArrayList<ProductoVenta>();
        listaProductosVenta.add(productoVenta);
        return new Venta(1, LocalDateTime.now(), cajero, 200, 200, 250, metodo, listaProductosVenta);
    }
    // Empezar a codificar en MongoDB

    @Override
    public Venta consultarVentaPorTicket(Long id) throws PersistenciaException {
        Empleado cajero = new Empleado(2L, "Yeremy", "Cajero");

        // Crear método de pago
        Efectivo efectivo = new Efectivo();
        MetodoPago metodoPago = new MetodoPago(efectivo);

        // Producto 1
        Producto producto1 = new Producto();
        producto1.setId(1);
        producto1.setNombre("Pan");
        producto1.setDescripcion("Pan integral");
        producto1.setPrecio(15.0);
        producto1.setEsPesable(false);
        producto1.setUnidad(1.0);
        producto1.setStock(5);

        ProductoVenta productoVenta1 = new ProductoVenta();
        productoVenta1.setProducto(producto1);
        productoVenta1.setCantidad(2);
        productoVenta1.setPrecioUnitario(producto1.getPrecio());
        productoVenta1.setImporte(producto1.getPrecio() * productoVenta1.getCantidad());

        // Producto 2
        Producto producto2 = new Producto();
        producto2.setId(2);
        producto2.setNombre("Leche");
        producto2.setDescripcion("Leche entera 1L");
        producto2.setPrecio(22.5);
        producto2.setEsPesable(false);
        producto2.setUnidad(1.0);
        producto2.setStock(1);

        ProductoVenta productoVenta2 = new ProductoVenta();
        productoVenta2.setProducto(producto2);
        productoVenta2.setCantidad(1);
        productoVenta2.setPrecioUnitario(producto2.getPrecio());
        productoVenta2.setImporte(producto2.getPrecio());

        // Lista de productos
        List<ProductoVenta> listaProductosVenta = new ArrayList<>();
        listaProductosVenta.add(productoVenta1);
        listaProductosVenta.add(productoVenta2);

        // Totales
        double subtotal = productoVenta1.getImporte() + productoVenta2.getImporte();
        double iva = subtotal * 0.16;
        double total = subtotal + iva;

        return new Venta(50, LocalDateTime.now(), cajero, subtotal, iva, total, metodoPago, listaProductosVenta);
    }
}
