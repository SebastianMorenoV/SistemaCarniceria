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
import Exception.NegocioException;
import Interfaces.IEntradaBO;
import Interfaces.IProductoBO;
import Interfaces.IProveedorBO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class RegistrarEntrada implements IRegistrarEntrada{
   //manejadores de BO
    private IProductoBO productoBO = manejadoresBO.ManejadorObjetosNegocio.crearProductoBO();
    private IProveedorBO proveedorBO = manejadoresBO.ManejadorObjetosNegocio.crearProveedorBO();
    private IEntradaBO entradaBO = manejadoresBO.ManejadorObjetosNegocio.crearEntradaBO();
    private EntradaDTO entradaTemporal = new EntradaDTO();
    private double precioCompra, unidades;
    private ProductoCargadoDTO productoSeleccionado;
    private ProveedorDTO proveedorSeleccionado;
    
    //Quitar y utilizar cargar______ para utilizar el metodo necesario 
    @Override
    public void crearListas() {
//        listaProveedores.add(new ProveedorDTO(1, "Kowi Central", "555-1234"));
//        listaProveedores.add(new ProveedorDTO(3, "Verduras Frescas", "555-9012"));
//        listaProveedores.add(new ProveedorDTO(7, "Bachoco norte", "412-212"));
//        listaProveedores.add(new ProveedorDTO(4, "Carnes del Norte", "555-3456"));
//        listaProveedores.add(new ProveedorDTO(5, "Lácteos El Campo", "555-7890"));
//        listaProveedores.add(new ProveedorDTO(6, "Panadería San Juan", "555-2345")); 

    }

    @Override
    public List<ProveedorDTO> cargarProveedores() throws NegocioException{ 
        try {
            return proveedorBO.cargarProveedores();
        } catch (NegocioException ex) {
            throw new NegocioException("No hay proveedores");
        }
    }

    @Override
    public List<ProductoCargadoDTO> cargarProductos()throws NegocioException{
        try {
            return productoBO.cargarProductos();
        } catch (NegocioException ex) {
            throw new NegocioException("No hay productos"); 
        }
    }

    @Override
    public EmpleadoCargadoDTO cargarEmpleado() {
        return new EmpleadoCargadoDTO("Juan Soto");   
    }

    @Override
    public void agregarProductoEntrada() {
        ProductoEntradaDTO producto = new ProductoEntradaDTO(this.productoSeleccionado, this.unidades, this.precioCompra);             
        entradaTemporal.listaProductosEntrada.add(producto);
    }

    @Override
    public void agregarProveedor(ProveedorDTO proveedor) throws NegocioException {
        try {
            proveedorBO.registrarProveedor(proveedor);
        } catch (NegocioException ex) {
           throw new NegocioException("No se pudo agregar al proveedor" + ex.getMessage());
        }
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody     
//        return listaProductosEntrada;
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
//¿¿Este metodo ira en control?? o puede ir en clase productoBO
    @Override
    public void setStockProducto(ProductoCargadoDTO producto,double unidades) {
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
