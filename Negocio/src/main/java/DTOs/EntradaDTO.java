/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DTOs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class EntradaDTO {
    public int id;
    public LocalDateTime fechaHora;
    public EmpleadoCargadoDTO Empleado;
    public List<ProductoEntradaDTO> listaProductosEntrada;
    public ProveedorDTO Proveedor;
    public double iva, total, subtotal;

    public EntradaDTO(int id, LocalDateTime fechaHora, EmpleadoCargadoDTO Empleado, List<ProductoEntradaDTO> listaProductosEntrada, ProveedorDTO Proveedor) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.Empleado = Empleado;
        this.listaProductosEntrada = listaProductosEntrada;
        this.Proveedor = Proveedor;
    }

    public EntradaDTO(LocalDateTime fechaHora, EmpleadoCargadoDTO Empleado, List<ProductoEntradaDTO> listaProductosEntrada, ProveedorDTO Proveedor) {
        this.fechaHora = fechaHora;
        this.Empleado = Empleado;
        this.listaProductosEntrada = listaProductosEntrada;
        this.Proveedor = Proveedor;
    }

    public EntradaDTO() {
        this.listaProductosEntrada = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public EmpleadoCargadoDTO getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(EmpleadoCargadoDTO Empleado) {
        this.Empleado = Empleado;
    }

    public List<ProductoEntradaDTO> getListaProductosEntrada() {
        return listaProductosEntrada;
    }

    public void setListaProductosEntrada(List<ProductoEntradaDTO> listaProductosEntrada) {
        this.listaProductosEntrada = listaProductosEntrada;
    }

    public ProveedorDTO getProveedor() {
        return Proveedor;
    }

    public void setProveedor(ProveedorDTO Proveedor) {
        this.Proveedor = Proveedor;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
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

    @Override
    public String toString() {
        return "EntradaDTO{" + "id=" + id + ", fechaHora=" + fechaHora + ", Empleado=" + Empleado + ", listaProductosEntrada=" + listaProductosEntrada + ", Proveedor=" + Proveedor + ", iva=" + iva + ", total=" + total + ", subtotal=" + subtotal + '}';
    }
    
    
}
