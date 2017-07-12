package io.rockscript.example.pdf;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.pdfbox.pdmodel.*;

/**
 * Creates a one-page PDF with a blank page in the given colour, e.g. ff0000 (red).
 */
public class ColorPdf {

  private String hexColorCode;

  public ColorPdf(final String hexColorCode) {
    this.hexColorCode = hexColorCode;
  }

  /**
   * Renders the PDF to the given output stream.
   */
  public void render(final OutputStream output) throws IOException {
    try (final PDDocument document = new PDDocument()) {
      final PDPage page = new PDPage();
      document.addPage(page);
      final PDPageContentStream contents = new PDPageContentStream(document, page);
      contents.setNonStrokingColor(new HexColor(hexColorCode));
      contents.addRect(0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());
      contents.fill();
      contents.close();
      document.save(output);
    }
  }
}
