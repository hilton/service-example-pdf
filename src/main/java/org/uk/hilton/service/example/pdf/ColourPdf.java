package org.uk.hilton.service.example.pdf;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.pdfbox.pdmodel.*;

/**
 * Creates a one-page PDF with a blank page in the given colour, e.g. ff0000 (red).
 */
public class ColourPdf {

  private final String hexColourCode;

  public ColourPdf(final String hexColourCode) {
    this.hexColourCode = hexColourCode;
  }

  /**
   * Renders the PDF to the given output stream.
   */
  public void render(final OutputStream output) throws IOException {
    try (final PDDocument document = new PDDocument()) {
      final PDPage page = new PDPage();
      document.addPage(page);
      final PDPageContentStream contents = new PDPageContentStream(document, page);
      contents.setNonStrokingColor(new HexColour(hexColourCode));
      contents.addRect(0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());
      contents.fill();
      contents.close();
      document.save(output);
    }
  }
}
