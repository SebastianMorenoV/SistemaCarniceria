/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Implementacion;

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
        
        public void setStockProducto(ProductoCargadoDTO producto, double Unidades);
        
        public List<ProductoEntradaDTO> cargarProductosEntrada();
        
        public void RegistrarEntrada(EntradaDTO entada);

}
