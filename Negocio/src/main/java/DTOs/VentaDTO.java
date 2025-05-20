
package DTOs;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author HP
 */
public class VentaDTO {
    private Integer id;
    private double total,subtotal,iva;
    private LocalDateTime fechaHora;
    private EmpleadoCargadoDTO empleado;
    private List<ProductoVentaDTO> listadoProductosVenta = new ArrayList<>();
    private PagoViejoDTO pago;

    public VentaDTO() {
    }

    public VentaDTO(double total, double subtotal, double iva, LocalDateTime fechaHora, EmpleadoCargadoDTO empleado, List<ProductoVentaDTO> listadoProductosVenta, PagoViejoDTO PAGO) {
        this.total = total;
        this.subtotal = subtotal;
        this.iva = iva;
        this.fechaHora = fechaHora;
        this.empleado = empleado;
        this.listadoProductosVenta = listadoProductosVenta;
        this.pago = pago;
    }
    
    //(empleado, LocalDate.now(), listadoProductosVenta);

    public VentaDTO(LocalDateTime fechaHora, EmpleadoCargadoDTO empleado, List<ProductoVentaDTO> listadoProductosVenta) {
        this.fechaHora = fechaHora;
        this.empleado = empleado;
        this.listadoProductosVenta = listadoProductosVenta;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public EmpleadoCargadoDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoCargadoDTO empleado) {
        this.empleado = empleado;
    }

    public List<ProductoVentaDTO> getListadoProductosVenta() {
        return listadoProductosVenta;
    }

    public void setListadoProductosVenta(List<ProductoVentaDTO> listadoProductosVenta) {
        this.listadoProductosVenta = listadoProductosVenta;
    }

    public PagoViejoDTO getPago() {
        return pago;
    }

    public void setPago(PagoViejoDTO pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "VentaDTO{" + "id=" + id + ", total=" + total + ", subtotal=" + subtotal + ", iva=" + iva + ", fechaHora=" + fechaHora + ", empleado=" + empleado + ", listadoProductosVenta=" + listadoProductosVenta + ", pago=" + pago + '}';
    }

  
    
    
    
}
