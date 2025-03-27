/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Implementacion;

import DTOs.*;
import java.util.List;

/**
 *
 * @author Lap-064
 */
public interface IRealizarVenta {

    public EmpleadoCargadoDTO cargarEmpleado();

    public List<ProductoCargadoDTO> cargarProductos();

    public NuevoProductoVentaDTO agregarProducto(ProductoCargadoDTO productoCargado, double cantidad);

    public double calcularTotal(double subtotal , double iva);
    
    public double calcularSubtotal(List<NuevoProductoVentaDTO> productosEnTabla);
    
    public double calcularIva(double subtotal);
    
    public boolean verificarPago(PagoNuevoDTO pago);
    
    public double obtenerTotal();
    
    public void setearTotal(Double total);
    
    public void setearVenta(VentaDTO ventaNueva);
    
    public VentaDTO obtenerVenta();
    
}
