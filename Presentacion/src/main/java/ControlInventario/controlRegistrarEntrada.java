/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlInventario;

import GUI.ModuloRegistrarEntrada.FormularioDatosEntrada;
import GUI.ModuloRegistrarEntrada.ventanaSeleccionarProveedor;
import GUI.ModuloRegistrarEntrada.VentanaInformacionEntrada;
import GUI.ModuloRegistrarEntrada.ventanaSeleccionarProductoEntrada;
import GUI.ModuloRegistrarEntrada.seleccionarProductoCargadoDTO;
import GUI.ModuloRegistrarEntrada.VentanaDatosEntrada;
import GUI.ModuloRegistrarEntrada.PanelRegistrarProductosEntrada;
import GUI.ModuloRegistrarEntrada.menuInventario;
import GUI.ModuloRegistrarEntrada.seleccionarProveedor;
import DTOs.*;
import Implementacion.RegistrarEntrada;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author HP
 */
public class controlRegistrarEntrada {
//   private menuOpciones menuPrincipal;
   private menuInventario menuOpcionesInventario;
   private RegistrarEntrada RegistarEntrada;
//   private JFrame framePrincipal;
//   private JFrame frameTemporal;
   private seleccionarProveedor seleccionarProveedor;
   private seleccionarProductoCargadoDTO seleccionarProductoEntrada;
   private PanelRegistrarProductosEntrada panelResumenProducosEntrada;
   private VentanaDatosEntrada formularioDatosEntrada;
   
   public controlRegistrarEntrada(){
        this.RegistarEntrada = new RegistrarEntrada();
        this.menuOpcionesInventario = new menuInventario(this);
        this.panelResumenProducosEntrada = new PanelRegistrarProductosEntrada(this);
        this.seleccionarProductoEntrada = new seleccionarProductoCargadoDTO(this);
        this.seleccionarProveedor = new seleccionarProveedor(this);
        
        //inicializar ventanas
//        formularioDatosEntrada = new VentanaDatosEntrada(this);
//        
   }  
      
   public void iniciar(){
       RegistarEntrada.crearListas();
   }
   
   //Ventanas/Paneles
   public void mostrarVentanaSeleccionarProveedor(){
       ventanaSeleccionarProveedor seleccionarProveedor = new ventanaSeleccionarProveedor(this); 
       seleccionarProveedor.setVisible(true);
   }
   public void mostrarVentanaSeleccionarProductosEntrada(){    
       ventanaSeleccionarProductoEntrada seleccionarProductoEntrada = new ventanaSeleccionarProductoEntrada(this);
       seleccionarProductoEntrada.setVisible(true);
   }
   
   public void mostrarVentanaInformacionEntrada(){
       VentanaInformacionEntrada panelInformacion = new VentanaInformacionEntrada(this);
       panelInformacion.setVisible(true);
   }
   public void mostrarVentanaDatosEntrada() {
        FormularioDatosEntrada ventanaDatos = new FormularioDatosEntrada(this);
        ventanaDatos.setVisible(true);
    }
   
   public ProductoCargadoDTO ProductoSeleccionado(int index){
       return cargarProductos().get(index);
   }
   public int ProveedorSeleccionado(int index){
       mostrarVentanaSeleccionarProductosEntrada();
       return index;
    }
   
     //Validaciones
   public void MostrarErrorNumeroInvalido(){ 
         JOptionPane.showMessageDialog(menuOpcionesInventario, "Error: Ingresa un valor numérico válido.");
    }
   public void MostrarErrorUsarioCancelo(){
       JOptionPane.showMessageDialog(menuOpcionesInventario, "El Usuario cancelo la operacion");
   }

    //Metodos del caso de uso Falta Metodo RegistrarEntrada y registrarProveedor y agregar Nuevo producto al inventario---
    
   
   public void agregarProductoEntrada(){
        RegistarEntrada.agregarProductoEntrada();
        mostrarVentanaInformacionEntrada();
   }
   
//Carga de datos
   
   public List<ProveedorDTO> cargarProveedores(){
       return RegistarEntrada.cargarProveedores();
   }
   public List<ProductoCargadoDTO> cargarProductos(){
        return RegistarEntrada.cargarProductos();   
   }
   public List<ProductoEntradaDTO> cargarProductoEntrada(){
        return RegistarEntrada.cargarProductosEntrada();   
   }
   public EmpleadoCargadoDTO cargarEmpleado(){
       return RegistarEntrada.cargarEmpleado();     
   }
   public LocalDateTime cargarFecha(){ 
       return RegistarEntrada.cargarFecha();
   }
   //es mas como actualizar el panel???
   public void cambiarPantalla(JPanel panel) {
        menuOpcionesInventario.setContentPane(panel);
        menuOpcionesInventario.revalidate();
        menuOpcionesInventario.repaint();
        menuOpcionesInventario.setVisible(true);
    }

   public void setProductoCargado(ProductoCargadoDTO producto){
       RegistarEntrada.setProductoEntrada(producto);
   }
   public void setPrecioCompra(double precioCompra){
       RegistarEntrada.setPrecioCompra(precioCompra);
   }
   public void setUnidades(double Unidades){
       RegistarEntrada.setUnidades(Unidades);    
   }
   public void setProveedor(ProveedorDTO proveedor){
       RegistarEntrada.setProveedor(proveedor);
   }
  

   
}
