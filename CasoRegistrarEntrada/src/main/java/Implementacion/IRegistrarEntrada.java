/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Implementacion;

import DTOs.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IRegistrarEntrada {
        public void crearListas();
        public List<ProveedorDTO> cargarProveedores();
        public List<ProductoCargadoDTO> cargarProductos();
        public EmpleadoCargadoDTO cargarEmpleado();
        public void agregarProductoEntrada();
        public void agregarProveedor();
        public void setStock(double Unidades);
        public List<ProductoEntradaDTO> cargarProductosEntrada();
        public LocalDateTime cargarFecha();
        public double obtenerPrecioCompra();
        public double obtenerUnidades();
        public void setPrecioCompra(double PrecioCompra);
        public void setUnidades(double Unidades);
        public void setProductoEntrada(ProductoCargadoDTO producto);
        public void setProveedor(ProveedorDTO proveedor);
        public void CrearEntrada(EntradaDTO entada);
        public double calcularSubtotal(List<ProductoEntradaDTO> productosEnTabla);
        public double calcularIVA(double subtotal);
        public double calcularTotal(double iva, double subtotal);
       
}
