
package DTOs;

/**
 *
 * @author Lap-064
 */
public class EmpleadoCargadoDTO {
    String nombre;
    String cargo;

    public EmpleadoCargadoDTO() {
    }

    public EmpleadoCargadoDTO(String nombre) {
        this.nombre = nombre;
    }

    public EmpleadoCargadoDTO(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "EmpleadoCargadoDTO{" + "nombre=" + nombre + ", cargo=" + cargo + '}';
    }

 
    
    
}
