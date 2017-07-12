package io.rockscript.example.pdf;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.pdfbox.pdmodel.*;

import static spark.Spark.get;

/**
 * Serves a PDF in a given colour.
 */
public class PdfService {

  public static void main(final String[] args) throws IOException {
    get("/color/:code", (request, response) -> {
      final String hexColorCode = request.params(":code");
      response.type("application/pdf");
      new ColorPdf(hexColorCode).render(response.raw().getOutputStream());
      response.raw().getOutputStream().flush();
      response.raw().getOutputStream().close();
      return response.raw();
    });
  }
}
