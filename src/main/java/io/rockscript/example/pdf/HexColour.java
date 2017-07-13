package io.rockscript.example.pdf;

import java.awt.*;

/**
 * Decorator for constructing colours from hex colour strings, e.g. ff0000 (red).
 */
class HexColour extends Color {

  HexColour(final String hexColourCode) {
    super(Integer.parseInt(hexColourCode, 16));
  }
}
