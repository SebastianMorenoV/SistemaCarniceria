/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Implementacion;

import DTOs.EmpleadoCargadoDTO;
import DTOs.EntradaDTO;
import DTOs.ProductoCargadoDTO;
import DTOs.ProductoEntradaDTO;
import DTOs.ProveedorDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class RegistrarEntrada implements IRegistrarEntrada{
   
    private List<ProveedorDTO> listaProveedores = new ArrayList<>();
    private List<ProductoCargadoDTO> listaProductos = new ArrayList<>();
    private List<ProductoEntradaDTO> listaProductosEntrada = new ArrayList<>();
    private double precioCompra, unidades;
    private ProductoCargadoDTO productoSeleccionado;
    private ProveedorDTO proveedorSeleccionado;
    
    //Volver a comentar 
    @Override
    public void crearListas() {
        listaProveedores.add(new ProveedorDTO(1, "Kowi Central", "555-1234"));
        listaProveedores.add(new ProveedorDTO(3, "Verduras Frescas", "555-9012"));
        listaProveedores.add(new ProveedorDTO(7, "Bachoco norte", "412-212"));
        listaProveedores.add(new ProveedorDTO(4, "Carnes del Norte", "555-3456"));
        listaProveedores.add(new ProveedorDTO(5, "Lácteos El Campo", "555-7890"));
        listaProveedores.add(new ProveedorDTO(6, "Panadería San Juan", "555-2345")); 
        listaProductos.add(new ProductoCargadoDTO((long)1,"Pierna de cerdo", "Pierna sin hueso, fresca", "Cerdo", 1.0, 40.00, true));
        listaProductos.add(new ProductoCargadoDTO((long)2, "Carne molida", "80% carne, 20% grasa", "Res", 1.0, 45.00, true));
        listaProductos.add(new ProductoCargadoDTO((long)3, "Costilla res", "Costilla para asar con hueso", "Res", 1.0, 62.25, true));
        listaProductos.add(new ProductoCargadoDTO((long)4, "Chuleta ahumada", "Chuleta lista para freír", "Cerdo", 1.0, 40.00, true));
        listaProductos.add(new ProductoCargadoDTO((long)5, "Filete de pollo", "Pechuga sin piel ni hueso", "Pollo", 1.0, 50.00, true));
    }

    @Override
    public List<ProveedorDTO> cargarProveedores() {
      return listaProveedores;
    }

    @Override
    public List<ProductoCargadoDTO> cargarProductos() {
      return listaProductos;
    }

    @Override
    public EmpleadoCargadoDTO cargarEmpleado() {
        return new EmpleadoCargadoDTO("Juan Soto");   
    }

    @Override
    public void agregarProductoEntrada() {
        ProductoEntradaDTO producto = new ProductoEntradaDTO(this.productoSeleccionado, this.unidades, this.precioCompra);             
        listaProductosEntrada.add(producto);
    }

    @Override
    public void agregarProveedor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LocalDateTime cargarFecha() {
        LocalDateTime fecha = LocalDateTime.now(); 
        return fecha;
    }

    @Override
    public double obtenerPrecioCompra() {
        return precioCompra;
    }

    @Override
    public double obtenerUnidades() {
        return unidades;
    }

    @Override
    public void setPrecioCompra(double PrecioCompra) {
       this.precioCompra = PrecioCompra;
    }

    @Override
    public void setUnidades(double Unidades) {
        this.unidades = Unidades;
    }

    @Override
    public void setProductoEntrada(ProductoCargadoDTO producto) {
        this.productoSeleccionado = producto;
    }

    @Override
    public void setProveedor(ProveedorDTO proveedor) {
        this.proveedorSeleccionado = proveedor;
    }

    @Override
    public void CrearEntrada(EntradaDTO entada) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProductoEntradaDTO> cargarProductosEntrada() {
        return listaProductosEntrada;
    }

    @Override
    public double calcularSubtotal(List<ProductoEntradaDTO> productosEnTabla) {
        double subtotal = 0.0;
        for (ProductoEntradaDTO productoEntrada : productosEnTabla) {
            double subtotalTemporal = productoEntrada.getPrecioCompra()* productoEntrada.getUnidad();
            subtotal += subtotalTemporal;
        }
        return subtotal;
    }

    @Override
    public void setStock(double unidades) {
        this.productoSeleccionado.setStock(unidades);
    }

    @Override
    public double calcularIVA(double subtotal) {
        return subtotal * 0.16; // 16% de IVA
    }

    @Override
    public double calcularTotal(double iva, double subtotal) {
        return subtotal + iva;
    }

}
