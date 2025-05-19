/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Luis Carlos
 */
public class Entrada {
    public int id;
    public LocalDateTime FechaHora;
    public Empleado Empleado;
    public Proveedor Proveedor;
    public double subtotal=0.0, total = 0.0;
    public List<ProductoEntrada> listaProductosEntrada;

    public Entrada(int id, LocalDateTime FechaHora, Empleado Empleado, Proveedor Proveedor, List listaProductosEntrada) {
        this.id = id;
        this.FechaHora = FechaHora;
        this.Empleado = Empleado;
        this.Proveedor = Proveedor;
        this.listaProductosEntrada = listaProductosEntrada;
    }

    public Entrada(LocalDateTime FechaHora, Empleado Empleado, Proveedor Proveedor, List listaProductosEntrada) {
        this.FechaHora = FechaHora;
        this.Empleado = Empleado;
        this.Proveedor = Proveedor;
        this.listaProductosEntrada = listaProductosEntrada;
    }

    public Entrada() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(LocalDateTime FechaHora) {
        this.FechaHora = FechaHora;
    }

    public Empleado getEmpleado() {
        return Empleado;
    }
    public void setEmpleado(Empleado Empleado) {
        this.Empleado = Empleado;
    }
    public Proveedor getProveedor() {
        return Proveedor;
    }
    public void setProveedor(Proveedor Proveedor) {
        this.Proveedor = Proveedor;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
   }
    public List getListaProductosEntrada() {
        return listaProductosEntrada;
    }
    public void setListaProductosEntrada(List listaProductosEntrada) {
        this.listaProductosEntrada = listaProductosEntrada;
    }

}