package DAOS;

import Interfaces.IDevolucionDAO;
import entidades.Devolucion;
import entidades.Efectivo;
import entidades.Empleado;
import entidades.MetodoPago;
import entidades.Producto;
import entidades.ProductoVenta;
import entidades.Tarjeta;
import entidades.Venta;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Sebastian Moreno
 */
public class DevolucionDAO implements IDevolucionDAO {

    private static DevolucionDAO instanceDevolucionDAO;

    public DevolucionDAO() {
    }

    /**
     * Devuelve la unica instancia de esta clase (patron Singleton). Si la
     * instancia no existe, la crea.
     *
     * @return la instancia unica de IngredienteDAO.
     */
    public static DevolucionDAO getInstanceDAO() {
        if (instanceDevolucionDAO == null) {
            instanceDevolucionDAO = new DevolucionDAO();
        }

        return instanceDevolucionDAO;
    }

    /*
    Metodos de la interfaz.
     */
    private List<Devolucion> lista = new ArrayList<>();

    public Devolucion registrarDevolucion(Devolucion devolucion) {
        devolucion.setId(1);
        lista.add(devolucion);
        return devolucion;
    }

    /**
     * Metodo para buscar las devoluciones por un filtro en especifico.
     *
     * @param filtro Es la devolucion con sus campos telefono y nombre.
     * @param inicio es la fecha inicio dada por el usuario como parametro
     * @param fin es la fecha inicio dada por el usuario como parametro.
     * @return la devolucion encontrada o null si no existe.
     */
    public List<Devolucion> buscarDevolucionPorFiltro(Devolucion filtro, LocalDateTime inicio, LocalDateTime fin) {
        List<Devolucion> resultados = new ArrayList<>();

        // Simulación común de producto
        Producto producto = new Producto();
        producto.setNombre("Pulsera de Plata");

        ProductoVenta pv = new ProductoVenta();
        pv.setProducto(producto);
        pv.setCantidad(1);
        pv.setPrecioUnitario(150.00);
        pv.setImporte(150.00);

        List<ProductoVenta> productos = new ArrayList<>();
        productos.add(pv);

        // Simulación de empleados (cajeros)
        Empleado cajero1 = new Empleado();
        cajero1.setNombre("Luis Martínez");

        Empleado cajero2 = new Empleado();
        cajero2.setNombre("María López");

        Empleado cajero3 = new Empleado();
        cajero3.setNombre("Carlos Jiménez");

        // Simulación de ventas
        Venta venta1 = new Venta();
        venta1.setId(101);
        venta1.setFechaHora(inicio.plusHours(1));
        venta1.setCajero(cajero1);
        venta1.setSubtotal(150.00);
        venta1.setIva(24.00);
        venta1.setTotal(174.00);
        venta1.setMetodoPago(new MetodoPago(new Efectivo()));
        venta1.setListaProductosVenta(productos);

        Venta venta2 = new Venta();
        venta2.setId(102);
        venta2.setFechaHora(inicio.plusHours(3));
        venta2.setCajero(cajero2);
        venta2.setSubtotal(200.00);
        venta2.setIva(32.00);
        venta2.setTotal(232.00);
        venta2.setMetodoPago(new MetodoPago(new Tarjeta("Sebas","Visa", "1234567890123456",12)));
        venta2.setListaProductosVenta(productos);

        Venta venta3 = new Venta();
        venta3.setId(103);
        venta3.setFechaHora(fin.minusHours(1));
        venta3.setCajero(cajero3);
        venta3.setSubtotal(80.00);
        venta3.setIva(12.80);
        venta3.setTotal(92.80);
        venta3.setMetodoPago(new MetodoPago(new Efectivo()));
        venta3.setListaProductosVenta(productos);

        // Devolución 1
        Devolucion d1 = new Devolucion();
        d1.setId(1);
        d1.setVenta(venta1);
        d1.setNombreCompleto("Juan Pérez");
        d1.setTelefono("555-123-4567");
        d1.setRazon("Producto defectuoso");
        d1.setFechaHora(venta1.getFechaHora());
        d1.setNumeroDeTicket("TICKET-001");
        d1.setMontoDevuelto(150.0);
        d1.setListadoProductosDevueltos(productos);

        // Devolución 2
        Devolucion d2 = new Devolucion();
        d2.setId(2);
        d2.setVenta(venta2);
        d2.setNombreCompleto("Ana Gómez");
        d2.setTelefono("555-987-6543");
        d2.setRazon("Cambio de opinión");
        d2.setFechaHora(venta2.getFechaHora());
        d2.setNumeroDeTicket("TICKET-002");
        d2.setMontoDevuelto(230.5);
        d2.setListadoProductosDevueltos(productos);

        // Devolución 3
        Devolucion d3 = new Devolucion();
        d3.setId(3);
        d3.setVenta(venta3);
        d3.setNombreCompleto("Carlos Ruiz");
        d3.setTelefono("555-222-3344");
        d3.setRazon("Talla incorrecta");
        d3.setFechaHora(venta3.getFechaHora());
        d3.setNumeroDeTicket("TICKET-003");
        d3.setMontoDevuelto(99.9);
        d3.setListadoProductosDevueltos(productos);

        // Agregamos las devoluciones si sus fechas están dentro del rango
        for (Devolucion dev : List.of(d1, d2, d3)) {
            if ((dev.getFechaHora().isEqual(inicio) || dev.getFechaHora().isAfter(inicio))
                    && (dev.getFechaHora().isEqual(fin) || dev.getFechaHora().isBefore(fin))) {
                resultados.add(dev);
            }
        }

        return resultados;
    }

    /**
     * Metodo para consultar todas las devoluciones.
     *
     * @return
     * @throws PersistenceException
     */
    @Override
    public List<Devolucion> buscarDevoluciones() throws PersistenceException {
        List<Devolucion> resultados = new ArrayList<>();
        // Mock de 3 devoluciones encontradas dentro del rango
        Devolucion d1 = new Devolucion();
        d1.setId(1);
        d1.setNombreCompleto("Juan Pérez");
        d1.setTelefono("555-123-4567");
        d1.setRazon("Producto defectuoso");
        d1.setFechaHora(LocalDateTime.now()); // dentro del rango
        d1.setNumeroDeTicket("TICKET-001");
        d1.setMontoDevuelto(150.0);
        d1.setListadoProductosDevueltos(new ArrayList<>()); // Simulación

        Devolucion d2 = new Devolucion();
        d2.setId(2);
        d2.setNombreCompleto("Ana Gómez");
        d2.setTelefono("555-987-6543");
        d2.setRazon("Cambio de opinión");
        d2.setFechaHora(LocalDateTime.now()); // dentro del rango
        d2.setNumeroDeTicket("TICKET-002");
        d2.setMontoDevuelto(230.5);
        d2.setListadoProductosDevueltos(new ArrayList<>());

        Devolucion d3 = new Devolucion();
        d3.setId(3);
        d3.setNombreCompleto("Carlos Ruiz");
        d3.setTelefono("555-222-3344");
        d3.setRazon("Talla incorrecta");
        d3.setFechaHora(LocalDateTime.now()); // dentro del rango
        d3.setNumeroDeTicket("TICKET-003");
        d3.setMontoDevuelto(99.9);
        d3.setListadoProductosDevueltos(new ArrayList<>());

        for (Devolucion dev : List.of(d1, d2, d3)) {
            resultados.add(dev);
        }
        return resultados;
    }

    public Devolucion buscarPorID(String id) throws PersistenceException {
        // Simular datos del producto
        Producto producto = new Producto();
        producto.setNombre("Collar de Acero Inoxidable");

        ProductoVenta pv = new ProductoVenta();
        pv.setProducto(producto);
        pv.setCantidad(2);
        pv.setPrecioUnitario(150.00);
        pv.setImporte(pv.getCantidad() * pv.getPrecioUnitario());

        List<ProductoVenta> productos = new ArrayList<>();
        productos.add(pv);

        // Simular datos del empleado (cajero)
        Empleado cajero = new Empleado();
        cajero.setNombre("Luis Martínez");

        // Simular venta
        Venta venta = new Venta();
        venta.setId(1001);
        venta.setFechaHora(LocalDateTime.now().minusDays(1));
        venta.setCajero(cajero);
        venta.setSubtotal(300.00);
        venta.setIva(48.00);
        venta.setTotal(348.00);
        venta.setMetodoPago(new MetodoPago(new Efectivo())); // Enum simulado
        venta.setListaProductosVenta(productos);

        // Simular devolución
        Devolucion d = new Devolucion();
        d.setId(1);
        d.setVenta(venta);
        d.setNombreCompleto("Andrea Gómez");
        d.setTelefono("5551234567");
        d.setRazon("Producto defectuoso");
        d.setListadoProductosDevueltos(productos);
        d.setFechaHora(LocalDateTime.now());
        d.setNumeroDeTicket("TKT12345");
        d.setMontoDevuelto(300.00);

        return d;
    }

}
