/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Implementacion;

import DTOs.*;
import EstrategiaPago.IProcesadorPago;
import Exception.NegocioException;
import Exception.VentaException;
import excepciones.ProcesadorPagoException;
import java.util.List;

/**
 *
 * @author Lap-064
 */
public interface IRealizarVenta {

    public EmpleadoCargadoDTO cargarEmpleado() throws NegocioException;

    public List<ProductoCargadoDTO> cargarProductos() throws NegocioException;

    public ProductoVentaDTO agregarProductoVenta(ProductoCargadoDTO productoCargado, double cantidad);

    public double calcularTotal(double subtotal, double iva);

    public double calcularSubtotal(List<NuevoProductoVentaDTO> productosEnTabla);

    public double calcularIva(double subtotal);

    // public boolean verificarPago(PagoNuevoDTO pago);
    public double obtenerTotal();

    public void setearTotal(Double total);

    public void setearVenta(VentaDTO ventaNueva);

    public VentaDTO registrarVenta(VentaDTO ventaNueva) throws VentaException;

    public VentaDTO obtenerVenta();

    // para la estrategia
    public double procesarPago(PagoNuevoDTO pago) throws ProcesadorPagoException;

    public boolean validarPago(PagoViejoDTO pago) throws ProcesadorPagoException;
    
    public NuevaTarjetaDTO buscarTarjeta(String titular, String numeroTarjeta, String fechaVencimiento, int cvv) throws VentaException;
}
