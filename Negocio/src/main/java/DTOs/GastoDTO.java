/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalDate;
import org.bson.types.ObjectId;

/**
 *
 * @author Admin
 */
public class GastoDTO {
    Integer id;
    String folio;
    LocalDate fechaGasto;
    String categoria;
    ProveedorDTO proveedor;
    String concepto;
    Double montoGasto;
    byte[] comprobante;
    String metodoPago;

    public GastoDTO() {
    }

    public GastoDTO(Integer id, String folio, LocalDate fechaGasto, String categoria, ProveedorDTO proveedor, String concepto, Double montoGasto, byte[] comprobante, String metodoPago) {
        this.id = id;
        this.folio = folio;
        this.fechaGasto = fechaGasto;
        this.categoria = categoria;
        this.proveedor = proveedor;
        this.concepto = concepto;
        this.montoGasto = montoGasto;
        this.comprobante = comprobante;
        this.metodoPago = metodoPago;
    }

    public GastoDTO(String folio, LocalDate fechaGasto, String categoria, ProveedorDTO proveedor, String concepto, Double montoGasto, byte[] comprobante, String metodoPago) {
        this.folio = folio;
        this.fechaGasto = fechaGasto;
        this.categoria = categoria;
        this.proveedor = proveedor;
        this.concepto = concepto;
        this.montoGasto = montoGasto;
        this.comprobante = comprobante;
        this.metodoPago = metodoPago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public LocalDate getFechaGasto() {
        return fechaGasto;
    }

    public void setFechaGasto(LocalDate fechaGasto) {
        this.fechaGasto = fechaGasto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ProveedorDTO getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorDTO proveedor) {
        this.proveedor = proveedor;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Double getMontoGasto() {
        return montoGasto;
    }

    public void setMontoGasto(Double montoGasto) {
        this.montoGasto = montoGasto;
    }

    public byte[] getComprobante() {
        return comprobante;
    }

    public void setComprobante(byte[] comprobante) {
        this.comprobante = comprobante;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "GastoDTO{" + "id=" + id + ", folio=" + folio + ", fechaGasto=" + fechaGasto + ", categoria=" + categoria + ", proveedor=" + proveedor + ", concepto=" + concepto + ", montoGasto=" + montoGasto + ", comprobante=" + comprobante + ", metodoPago=" + metodoPago + '}';
    }
    
    
    
}
