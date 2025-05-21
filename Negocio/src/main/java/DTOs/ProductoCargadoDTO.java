package DTOs;

/**
 *
 * @author Sebastian Moreno
 */
public class ProductoCargadoDTO {
    int codigo;
    String nombre;
    String descripcion, categoria;
    double unidad;
    double precio; 
    boolean esPesable;
    Double stock;

    public ProductoCargadoDTO(int codigo, String nombre, String descripcion, String categoria, double unidad, double precio, boolean esPesable) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.unidad = unidad;
        this.precio = precio;
        this.esPesable = esPesable;
    }

    public ProductoCargadoDTO(int codigo, String nombre, String descripcion, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    

    public ProductoCargadoDTO() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getUnidad() {
        return unidad;
    }

    public void setUnidad(double unidad) {
        this.unidad = unidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEsPesable() {
        return esPesable;
    }

    public void setEsPesable(boolean esPesable) {
        this.esPesable = esPesable;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return nombre + stock;
    }

  



  
}

