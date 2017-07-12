package io.rockscript.example.pdf;

import java.awt.*;

/**
 * Decorator for constructing colours from hex colour strings, e.g. ff0000 (red).
 */
class HexColor extends Color {

  HexColor(final String hexColorCode) {
    super(Integer.parseInt(hexColorCode, 16));
  }
}
