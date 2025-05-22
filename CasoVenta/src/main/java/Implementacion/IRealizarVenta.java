/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Implementacion;

import DTOs.*;
import Exception.VentaException;
import excepciones.ProcesadorPagoException;
import java.util.List;

/**
 *
 * @author Lap-064
 */
public interface IRealizarVenta {

    public EmpleadoCargadoDTO cargarEmpleado() throws VentaException;

    public VentaDTO registrarVenta(VentaDTO ventaNueva) throws VentaException;

    public List<ProductoCargadoDTO> cargarProductos() throws VentaException;

    public ProductoVentaDTO agregarProductoVenta(ProductoCargadoDTO productoCargado, double cantidad) throws VentaException;

    public double calcularTotal(double subtotal, double iva) throws VentaException;

    public double calcularSubtotal(List<NuevoProductoVentaDTO> productosEnTabla) throws VentaException;

    public double calcularIva(double subtotal) throws VentaException;

    // public boolean verificarPago(PagoNuevoDTO pago);
    public double obtenerTotal();

    public void setearTotal(Double total);

    public void setearVenta(VentaDTO ventaNueva);

    public VentaDTO obtenerVenta();

    // para la estrategia
    public double procesarPago(PagoNuevoDTO pago) throws ProcesadorPagoException;

    public boolean validarPago(PagoViejoDTO pago) throws ProcesadorPagoException;

    public NuevaTarjetaDTO buscarTarjeta(String titular, String numeroTarjeta, String fechaVencimiento, int cvv) throws VentaException;

    public List<ProductoCargadoDTO> buscaProductosPorTexto(String textoBusqueda) throws VentaException;

    public void generarYMostrarPDFVenta(VentaDTO venta);
}
