package io.rockscript.example.pdf;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.*;

/**
 * Creates a one-page PDF with a blank page in the given colour, e.g. ff0000 (red).
 */
public class PdfService {

  public static void main(final String[] args) throws IOException {
    final String hexColorCode = args[0];
    try (final PDDocument doc = new PDDocument()) {
      final PDPage page = new PDPage();
      doc.addPage(page);
      final PDPageContentStream contents = new PDPageContentStream(doc, page);
      contents.setNonStrokingColor(new HexColor(hexColorCode));
      contents.addRect(0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());
      contents.fill();
      contents.close();
      doc.save(hexColorCode + ".pdf");
    }
  }
}
