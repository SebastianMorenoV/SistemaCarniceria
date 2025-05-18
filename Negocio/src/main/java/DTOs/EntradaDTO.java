/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DTOs;

import java.time.LocalDateTime;
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
    
}
