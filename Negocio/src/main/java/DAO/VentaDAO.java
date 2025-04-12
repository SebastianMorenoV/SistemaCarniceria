/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTOs.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class VentaDAO {
    public List<VentaDTO> cargarVentas() {
    List<VentaDTO> listaVentas = new ArrayList<>();

    EmpleadoCargadoDTO empleado1 = new EmpleadoCargadoDTO("Juan Pérez");
    EmpleadoCargadoDTO empleado2 = new EmpleadoCargadoDTO("Ana Gómez");

    ProductoCargadoDTO cocaCola = new ProductoCargadoDTO(1234, "CocaCola", "2lt", 25.0);
    ProductoCargadoDTO cebolla = new ProductoCargadoDTO(1236, "Cebolla Cambray", "kilogramo de cebolla", 60.0);
    ProductoCargadoDTO carneRes = new ProductoCargadoDTO(1235, "Carne de Res Diezmillo", "Calidad Premium Cortes Finos", 110.0);
    ProductoCargadoDTO sprite = new ProductoCargadoDTO(1237, "Sprite", "600ml", 20.0);
    ProductoCargadoDTO carnePuerco = new ProductoCargadoDTO(1238, "Carne de puerco", "Calidad economica", 40.0);

    ArrayList<NuevoProductoVentaDTO> productos1 = new ArrayList<>();
    productos1.add(new NuevoProductoVentaDTO(cocaCola, 2, 25.0, 50.0));
    productos1.add(new NuevoProductoVentaDTO(cebolla, 1, 60.0, 60.0));

    ArrayList<NuevoProductoVentaDTO> productos2 = new ArrayList<>();
    productos2.add(new NuevoProductoVentaDTO(carneRes, 1, 110.0, 110.0));
    productos2.add(new NuevoProductoVentaDTO(sprite, 3, 20.0, 60.0));

    ArrayList<NuevoProductoVentaDTO> productos3 = new ArrayList<>();
    productos3.add(new NuevoProductoVentaDTO(carnePuerco, 2, 40.0, 80.0));

    listaVentas.add(new VentaDTO(empleado1, LocalDate.of(2025, 2, 10), productos1));
    listaVentas.add(new VentaDTO(empleado2, LocalDate.of(2025, 3, 11), productos2));
    listaVentas.add(new VentaDTO(empleado1, LocalDate.of(2025, 4, 9), productos3));
    listaVentas.add(new VentaDTO(empleado2, LocalDate.of(2025, 4, 8), productos1));
    listaVentas.add(new VentaDTO(empleado1, LocalDate.of(2025, 4, 7), productos2));

    return listaVentas;
}
}
