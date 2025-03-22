package DTOs;

/**
 *
 * @author janot
 */
public class NuevaTarjetaDTO {
    String titular;
    String numeroTarjeta; //En el diagrama viene int pero se me hace mejor utilizando String
    String fechaVencimiento;
    int cvv;

    public NuevaTarjetaDTO(String titular, String numeroTarjeta, String fechaVencimiento, int cvv) {
        this.titular = titular;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    
}
