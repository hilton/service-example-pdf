package org.uk.hilton.service.example.pdf;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import spark.Request;
import spark.Response;

import static spark.Spark.get;

/**
 * An example microservice that generates PDF documents.
 */
public class PdfService {

  public static void main(final String[] args) throws IOException {
    get("/colour/:code", PdfService::createColourPdf);
  }

  /**
   * Serves a PDF in a given colour.
   */
  private static HttpServletResponse createColourPdf(final Request request, final Response response)
      throws IOException {
    final String hexColourCode = request.params(":code");
    response.type("application/pdf");
    new ColourPdf(hexColourCode).render(response.raw().getOutputStream());
    response.raw().getOutputStream().flush();
    response.raw().getOutputStream().close();
    return response.raw();
  }
}
