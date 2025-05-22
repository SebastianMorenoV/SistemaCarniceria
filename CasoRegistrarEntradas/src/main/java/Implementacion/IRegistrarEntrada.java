/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Implementacion;

import DTOs.ProductoEntradaDTO;
import DTOs.*;
import Exception.InventarioException;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IRegistrarEntrada {
    
        public List<ProveedorDTO> cargarProveedores()throws InventarioException;
        
        public List<ProductoCargadoDTO> cargarProductos() throws InventarioException;
        
        public EmpleadoCargadoDTO cargarEmpleado();
        
        public void agregarProductoEntrada();
        
        public void agregarProveedor(ProveedorDTO proveedor)throws InventarioException;
        
        public void setStockProducto(ProductoCargadoDTO producto, double stock) throws InventarioException;
        
        public List<ProductoEntradaDTO> cargarProductosEntrada();
        
        public EntradaDTO obtenerEntrada();
        
        public void setEntradaDTO(EntradaDTO entrada);
        
        public void registrarEntrada(EntradaDTO entada)throws InventarioException;
    


}
