/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementacion;

import DTOs.EmpleadoCargadoDTO;
import DTOs.NuevoProductoVentaDTO;
//import DTOs.PagoNuevoDTO;
import DTOs.ProductoCargadoDTO;
import DTOs.VentaDTO;
import EstrategiaPago.IProcesadorPago;
import EstrategiaPago.PagoEfectivo;
import EstrategiaPago.ProcesadorPago;
import excepciones.ProcesadorPagoException;
//import excepciones.ProcesadorPagoException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lap-064
 */
public class RealizarVenta implements IRealizarVenta {

  //  private ProcesadorPago proce;
    private Double total = 0.0;
    private VentaDTO ventaTemporal = null;
    private ProcesadorPago subsistemaPago;
      
    
    @Override
    public EmpleadoCargadoDTO cargarEmpleado() {
        return new EmpleadoCargadoDTO("Juan Soto");
    }

    @Override
    public List<ProductoCargadoDTO> cargarProductos() {

        List<ProductoCargadoDTO> listaProductos = new ArrayList<>();
        listaProductos.add(new ProductoCargadoDTO(1234, "CocaCola", "1.5lts Retornable", 25.0));
        listaProductos.add(new ProductoCargadoDTO(1235, "Carne de Res Diezmillo ", "Calidad Premium Cortes Finos", 110.0));
        listaProductos.add(new ProductoCargadoDTO(1236, "Cebolla Cambray", "kilogramo de cebolla", 60.0));
        listaProductos.add(new ProductoCargadoDTO(1237, "Sprite", "600ml no Retornable de plastico", 20.0));
        listaProductos.add(new ProductoCargadoDTO(1238, "Carne de puerco", "Calidad economica", 40.0));
        listaProductos.add(new ProductoCargadoDTO(1238, "Queso chihuahua", "Calidad economica", 150.0));
        return listaProductos;
    }

    @Override
    public NuevoProductoVentaDTO agregarProducto(ProductoCargadoDTO productoCargado, double cantidad) {

        double importe = productoCargado.getDecimal() * cantidad;
        return new NuevoProductoVentaDTO(productoCargado, cantidad, productoCargado.getDecimal(), importe);

    }

    @Override
    public double calcularSubtotal(List<NuevoProductoVentaDTO> productosEnTabla) {
        double subtotal = 0.0;
        for (NuevoProductoVentaDTO nuevoProductoVentaDTO : productosEnTabla) {
            double precioConIva = nuevoProductoVentaDTO.getImporte();
            subtotal += precioConIva / 1.16; // Quitar el IVA para obtener el subtotal
        }
        return subtotal;
    }

    @Override
    public double calcularIva(double subtotal) {
        return subtotal * 0.16; // 16% de IVA
    }

    @Override
    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }
    
       @Override
    public boolean procesarPago() {
        IProcesadorPago efectivo = new PagoEfectivo();
        subsistemaPago.SeleccionarMetodoPago(efectivo);
        try {
            return subsistemaPago.procesarPago();
        } catch (ProcesadorPagoException ex) {
            ex.printStackTrace();
        }
       return false; 
    }
/*
    @Override
    public boolean verificarPago(PagoNuevoDTO pagoNuevoDTO){

        try {
            return proce.verificarPago(pagoNuevoDTO);
        } catch (ProcesadorPagoException ex) {
            Logger.getLogger(RealizarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }*/

    @Override
    public double obtenerTotal() {
        return total;
    }

    @Override
    public void setearTotal(Double total) {
        this.total = total;
    }

    @Override
    public void setearVenta(VentaDTO ventaNueva) {
       this.ventaTemporal = ventaNueva;
    }

    @Override
    public VentaDTO obtenerVenta() {
       return ventaTemporal;
    }

    
    
    

}
