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
import Exception.InventarioException;
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
    private EntradaDTO entradaTemporal;
    private double precioCompra, unidades;
    private ProductoCargadoDTO productoSeleccionado;
    private ProveedorDTO proveedorSeleccionado;
    
    @Override
    public List<ProveedorDTO> cargarProveedores() throws InventarioException{ 
        try {
            System.out.println(proveedorBO.consultarProveedores()+ "Desde Caso uso");
            return proveedorBO.consultarProveedores();
        } catch (NegocioException ex) {
            throw new InventarioException("No hay proveedores");
        }
    }

    @Override
    public List<ProductoCargadoDTO> cargarProductos()throws InventarioException{
        try {
            return productoBO.cargarProductos();
        } catch (NegocioException ex) {
            throw new InventarioException("No hay productos"); 
        }
    }

    @Override
    public EmpleadoCargadoDTO cargarEmpleado() {
        return new EmpleadoCargadoDTO("Juan Soto");   
    }

    @Override
    public void agregarProductoEntrada() {
        ProductoEntradaDTO producto = new ProductoEntradaDTO(this.productoSeleccionado, this.unidades, this.precioCompra);
        if(entradaTemporal == null){
            entradaTemporal = new EntradaDTO();
            entradaTemporal.listaProductosEntrada.add(producto);
        }else{
            entradaTemporal.listaProductosEntrada.add(producto);
        }
        
    }

    @Override
    public void agregarProveedor(ProveedorDTO proveedor) throws InventarioException {
        try {
            proveedorBO.agregarProveedor(proveedor);
        } catch (NegocioException ex) {
           throw new InventarioException("No se pudo agregar al proveedor" + ex.getMessage());
        }
    }


    public double obtenerPrecioCompra() {
        return precioCompra;
    }

    public double obtenerUnidades() {
        return unidades;
    }

    public void setPrecioCompra(double PrecioCompra) {
       this.precioCompra = PrecioCompra;
    }

    public void setUnidades(double Unidades) {
        this.unidades = Unidades;
    }

    public void setProductoEntrada(ProductoCargadoDTO producto) {
        this.productoSeleccionado = producto;
    }


    public void setProveedor(ProveedorDTO proveedor) {
        this.proveedorSeleccionado = proveedor;
    }

    public void RegistrarEntrada(EntradaDTO entada) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<ProductoEntradaDTO> cargarProductosEntrada() {
        return entradaTemporal.listaProductosEntrada;
    }

    public double calcularSubtotal(List<ProductoEntradaDTO> productosEnTabla) {
        double subtotal = 0.0;
        for (ProductoEntradaDTO productoEntrada : productosEnTabla) {
            double subtotalTemporal = productoEntrada.getPrecioCompra()* productoEntrada.getUnidad();
            subtotal += subtotalTemporal;
        }
        return subtotal;
    }
//¿¿Este metodo ira en control?? o puede ir en clase productoBO
    
    public void setStockProducto(ProductoCargadoDTO producto,double unidades) {
        this.productoSeleccionado.setStock(unidades);
        
 //       productoBO.buscarProductoPorId(produco.getId());
    }

    public double calcularIVA(double subtotal) {
        return subtotal * 0.16; // 16% de IVA
    }

    public double calcularTotal(double iva, double subtotal) {
        return subtotal + iva;
    }
    
    //guardar entrada temporal

    public EntradaDTO getEntradaTemporal() {
        return entradaTemporal;
    }

    public void setEntradaTemporal(EntradaDTO entradaTemporal) {
        this.entradaTemporal = entradaTemporal;
    }
    
}
