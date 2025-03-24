/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class ventaDTO {
    protected double total,subtotal,iva;
    protected LocalDate fechaHora;
    protected EmpledoCargadoDTO empleado;
    protected ArrayList<NuevoProductoVentaDTO> listadoProductosVenta;
    
    public ventaDTO(EmpledoCargadoDTO empleado,LocalDate fecha, ArrayList<NuevoProductoVentaDTO> listadoProductos){
        this.empleado = empleado;
        this.subtotal = calcularSubtotal(listadoProductos);
        this.iva = calcularIva(subtotal);
        this.total = calcularTotal(subtotal, iva);
        this.fechaHora = fecha;
        this.listadoProductosVenta = listadoProductos;
    }
    
    public double calcularSubtotal(ArrayList<NuevoProductoVentaDTO> productosEnTabla) {
        double subtotal = 0.0;
        for (NuevoProductoVentaDTO nuevoProductoVentaDTO : productosEnTabla) {
            double precioConIva = nuevoProductoVentaDTO.getImporte();
            subtotal += precioConIva / 1.16; // Quitar el IVA para obtener el subtotal
        }
        return subtotal;
    }

   
    public double calcularIva(double subtotal) {
        return subtotal * 0.16; // 16% de IVA
    }

    
    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public ArrayList<NuevoProductoVentaDTO> getListadoProductosVenta() {
        return listadoProductosVenta;
    }

    public void setListadoProductosVenta(ArrayList<NuevoProductoVentaDTO> listadoProductosVenta) {
        this.listadoProductosVenta = listadoProductosVenta;
    }

    public EmpledoCargadoDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpledoCargadoDTO empleado) {
        this.empleado = empleado;
    }
}
