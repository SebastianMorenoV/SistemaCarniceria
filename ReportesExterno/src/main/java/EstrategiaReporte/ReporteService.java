/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstrategiaReporte;

import DTOs.MetodoPagoDTO;
import DTOs.ProductoVentaDTO;
import DTOs.VentaDTO;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Sebastian Moreno
 */
public class ReporteService {
    public byte[] generarPDFVenta(VentaDTO venta) {
        try {
            Document doc = new Document();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(doc, baos);

            doc.open();

            // Título
            Font tituloFont = new Font(Font.HELVETICA, 18, Font.BOLD);
            Paragraph titulo = new Paragraph("Ticket de Venta", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            doc.add(titulo);
            doc.add(Chunk.NEWLINE);

            // Información general
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            doc.add(new Paragraph("Fecha y Hora: " + venta.getFechaHora().format(formatter)));
            doc.add(new Paragraph("Empleado: " + venta.getEmpleado().getNombre()));
            doc.add(Chunk.NEWLINE);

            // Tabla de productos
            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{4, 2, 2, 2});

            tabla.addCell("Producto");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio Unitario");
            tabla.addCell("Importe");

            for (ProductoVentaDTO p : venta.getListadoProductosVenta()) {
                tabla.addCell(p.getProducto().getNombre());
                tabla.addCell(String.format("%.2f", p.getCantidad()));
                tabla.addCell(String.format("$ %.2f", p.getPrecioUnitario()));
                tabla.addCell(String.format("$ %.2f", p.getImporte()));
            }

            doc.add(tabla);
            doc.add(Chunk.NEWLINE);

            // Totales
            doc.add(new Paragraph("Subtotal: $" + String.format("%.2f", venta.getSubtotal())));
            doc.add(new Paragraph("IVA: $" + String.format("%.2f", venta.getIva())));
            doc.add(new Paragraph("Total: $" + String.format("%.2f", venta.getTotal())));
            doc.add(Chunk.NEWLINE);

            // Información del pago
            if (venta.getPago() != null && venta.getPago().getMetodoPago() != null) {
                MetodoPagoDTO metodo = venta.getPago().getMetodoPago();
                doc.add(new Paragraph("Método de pago:"));

                if (metodo.getNuevoEfectivo() != null) {
                    doc.add(new Paragraph("- Efectivo"));
                    doc.add(new Paragraph("  Monto recibido: $" + String.format("%.2f", venta.getPago().getMonto())));
                    double cambio = venta.getPago().getMonto() - venta.getTotal();
                    doc.add(new Paragraph("  Cambio: $" + String.format("%.2f", cambio)));
                } else if (metodo.getNuevaTarjeta() != null) {
                    doc.add(new Paragraph("- Tarjeta"));
                    doc.add(new Paragraph("  Monto cargado: $" + String.format("%.2f", venta.getPago().getMonto())));
                }
            }

            doc.close();
            return baos.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Error al generar el PDF de la venta", e);
        }
    }
}
