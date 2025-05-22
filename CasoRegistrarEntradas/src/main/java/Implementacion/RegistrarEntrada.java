/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Implementacion;

import DTOs.ProductoEntradaDTO;
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
    private EntradaDTO entradaTemporal = null;
    private double precioCompra, unidades, iva, subtotal, total;
    private ProductoCargadoDTO productoSeleccionado;
    private ProveedorDTO proveedorSeleccionado;
    
    /**
    * Carga la lista de proveedores disponibles desde la capa de negocio.
    * 
    * @return Lista de objetos ProveedorDTO.
    * @throws InventarioException Si ocurre un error al consultar los proveedores.
    */
    @Override
    public List<ProveedorDTO> cargarProveedores() throws InventarioException{ 
        try {
            return proveedorBO.consultarProveedores();
        } catch (NegocioException ex) {
            throw new InventarioException("No hay proveedores");
        }
    }
    /**
     * Carga la lista de productos disponibles desde la capa de negocio.
     *
     * @return Lista de objetos ProductoCargadoDTO.
     * @throws InventarioException Si ocurre un error al consultar los productos.
     */
    @Override
    public List<ProductoCargadoDTO> cargarProductos()throws InventarioException{
        try {
            return productoBO.cargarProductos();
        } catch (NegocioException ex) {
            throw new InventarioException("No hay productos"); 
        }
    }
    /**
     * Retorna un objeto EmpleadoCargadoDTO que representa al empleado actual.
     *
     * @return Objeto EmpleadoCargadoDTO con nombre fijo "Juan Soto".
     */
    @Override
    public EmpleadoCargadoDTO cargarEmpleado() {    
        return new EmpleadoCargadoDTO("Juan Soto");   
    }

    /**
    * Agrega un producto a la entrada temporal. Si no existe una entrada temporal, la crea.
    * También recalcula subtotal, IVA y total.
    */

    @Override
    public void agregarProductoEntrada() {
        ProductoEntradaDTO producto = new ProductoEntradaDTO(productoSeleccionado, unidades, precioCompra);
        if(entradaTemporal == null){
            entradaTemporal = new EntradaDTO();
            entradaTemporal.listaProductosEntrada.add(producto);
            entradaTemporal.setFechaHora(LocalDateTime.now());
            
        }else{
            entradaTemporal.getListaProductosEntrada().add(producto);    
            double nuevoSubtotal = calcularSubtotal(entradaTemporal.listaProductosEntrada);
            double nuevoIva = calcularIVA(nuevoSubtotal);
            double nuevoTotal = calcularTotal(nuevoIva, nuevoSubtotal);
            entradaTemporal.setSubtotal(nuevoSubtotal);
            entradaTemporal.setIva(nuevoIva);
            entradaTemporal.setTotal(nuevoTotal);
            entradaTemporal.setFechaHora(LocalDateTime.now());
            this.subtotal = nuevoSubtotal;
            this.iva = nuevoIva;
            this.total = nuevoTotal;
        }       
    }

    @Override
    public void agregarProveedor(ProveedorDTO proveedor) throws InventarioException {
        try {
            proveedorBO.agregarProveedorEntrada(proveedor);
            
        } catch (NegocioException ex) {
           throw new InventarioException("No se pudo agregar al proveedor" + ex.getMessage());
        }
    }
    
    /**
     * Registra la entrada de productos en el sistema, actualizando el stock de cada producto
     * y enviando la entrada a la capa de negocio.
     *
     * @param entrada Objeto EntradaDTO que contiene los productos y datos de entrada.
     * @throws InventarioException Si ocurre un error al registrar la entrada.
     */    
    @Override
    public void registrarEntrada(EntradaDTO entrada) throws InventarioException {
        try {
            for(ProductoEntradaDTO producto : entrada.getListaProductosEntrada()){
                setStockProducto(producto.getProductoEntrada(), producto.getStock());
            }           
            entradaBO.registrarEntrada(entrada);                   
        } catch (NegocioException ex) {
            throw new InventarioException("No se pudo registrar la entrada" + ex.getMessage());
        }
    }
    
    /**
     * Retorna la lista de productos de la entrada temporal.
     *
     * @return Lista de objetos ProductoEntradaDTO.
     */
    @Override
    public List<ProductoEntradaDTO> cargarProductosEntrada() {
        return entradaTemporal.listaProductosEntrada;
    }
    /**
    * Obtiene la entrada temporal actualmente en curso.
    *
    * @return Objeto EntradaDTO que representa la entrada temporal.
    */
    @Override
    public EntradaDTO obtenerEntrada() {
        return entradaTemporal;
    }
    /**
     * Establece una nueva entrada temporal.
     *
     * @param entradaNueva Objeto EntradaDTO a establecer.
     */
    @Override
    public void setEntradaDTO(EntradaDTO entradaNueva) {
        this.entradaTemporal = entradaNueva;
    }
    
    /**
    * Calcula el subtotal de una lista de productos en función del precio de compra y las unidades.
    *
    * @param productosEnTabla Lista de productos de entrada.
    * @return Valor total del subtotal.
    */
    
    public double calcularSubtotal(List<ProductoEntradaDTO> productosEnTabla) {
        double subtotal = 0.0;
        for (ProductoEntradaDTO productoEntrada : productosEnTabla) {
            double subtotalTemporal = productoEntrada.getPrecioCompra()* productoEntrada.getStock();
            subtotal += subtotalTemporal;
        }
        return subtotal;
    }
    /**
    * Establece el nuevo stock para un producto sumando las unidades indicadas.
    *
    * @param producto Objeto ProductoCargadoDTO al que se le sumará el stock.
    * @param stock Cantidad de unidades a agregar.
    * @throws InventarioException Si ocurre un error al actualizar el stock.
    */
    @Override
    public void setStockProducto(ProductoCargadoDTO producto, double stock) throws InventarioException {
        try {   
            productoBO.sumararStockAProducto(stock, (Integer)producto.getCodigo());
            
        } catch (NegocioException ex) {
            throw new InventarioException("No se pudo registrar la entrada" + ex.getMessage());
        }
    }
    
    /**
     * Calcula el IVA (16%) de un valor dado.
     *
     * @param subtotal Monto base sobre el cual se calculará el IVA.
     * @return Monto del IVA.
     */
    public double calcularIVA(double subtotal) {
        return subtotal * 0.16; // 16% de IVA
    }
    /**
     * Calcula el total a pagar sumando el IVA al subtotal.
     *
     * @param iva Monto del IVA.
     * @param subtotal Monto base.
     * @return Total a pagar.
     */
    public double calcularTotal(double iva, double subtotal) {
        return subtotal + iva;
    }
    
    /**
     * Obtiene la entrada temporal actual.
     *
     * @return Objeto EntradaDTO.
     */
    public EntradaDTO getEntradaTemporal() {
        return entradaTemporal;
    }
    /**
     * Establece una nueva entrada temporal.
     *
     * @param entradaTemporal Objeto EntradaDTO a establecer.
     */
    public void setEntradaTemporal(EntradaDTO entradaTemporal) {
        this.entradaTemporal = entradaTemporal;
    }
    /**
    * Agrega un nuevo producto a la base de datos a través de la capa de negocio.
    *
    * @param producto Objeto ProductoCargadoDTO a agregar.
    * @return Producto agregado, o null si ocurre un error.
    */  
    public ProductoCargadoDTO agregarProducto(ProductoCargadoDTO producto){
        ProductoCargadoDTO productoDTO;
        try {
            productoDTO = productoBO.agregarProducto(producto);
            return productoDTO;
        } catch (NegocioException ex) {
            Logger.getLogger(RegistrarEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
    * Obtiene el precio de compra actual registrado.
    *
    * @return Precio de compra.
    */
    public double obtenerPrecioCompra() {
        return precioCompra;
    }

    /**
     * Obtiene la cantidad de unidades establecida para el producto.
     *
     * @return Número de unidades.
     */
    public double obtenerUnidades() {
        return unidades;
    }
    
    /**
    * Establece el precio de compra para el producto seleccionado.
    *
    * @param PrecioCompra Nuevo precio de compra.
    */
    public void setPrecioCompra(double PrecioCompra) {
       this.precioCompra = PrecioCompra;
    }
    
    /**
    * Establece la cantidad de unidades para el producto seleccionado.
    *
    * @param Unidades Nueva cantidad de unidades.
    */
    public void setUnidades(double Unidades) {
        this.unidades = Unidades;
    }

    /**
    * Establece el producto actualmente seleccionado para agregarlo a la entrada.
    *
    * @param producto Objeto ProductoCargadoDTO a establecer.
    */
    public void setProductoEntrada(ProductoCargadoDTO producto) {
        this.productoSeleccionado = producto;
    }

    public void setIva(double iva){
        this.iva = iva;
    }
    public void setTotal(double total){
        this.total = iva;
    }
    public void setSubtotal(double subtotal){
        this.subtotal = iva;
    }
    public double getIva(){
        return iva;
    }
    public double getTotal(){
        return total;
    }
    public double getSubtotal(){
        return subtotal;
    }

    public void setProveedor(ProveedorDTO proveedor) {
        this.proveedorSeleccionado = proveedor;
        entradaTemporal = new EntradaDTO(); 
        entradaTemporal.setProveedor(proveedor);
    }
    
}
