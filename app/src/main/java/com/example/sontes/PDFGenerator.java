import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;

import java.io.File;
import java.io.IOException;

public class PDFGenerator {

    public static void createPDF(String dest) throws IOException {
        // Initialize PDF writer and document
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Adding TCDD logo example
        String logoPath = "path_to_your_logo/tcdd_logo.png"; // Change to your logo path
        Image logo = new Image(logoPath);
        document.add(logo);

        // Add a paragraph
        document.add(new Paragraph("Welcome to the PDF generation example with TCDD logo!"));

        // Create a table
        Table table = new Table(3);
        table.addCell(new Cell().add("Cell 1"));
        table.addCell(new Cell().add("Cell 2"));
        table.addCell(new Cell().add("Cell 3"));
        document.add(table);

        // Close document
document.close();
    }
}
