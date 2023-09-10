package model;

/**
 * The enum Type.
 */
public enum Type {
  /**
   * Rectangle type.
   */
  rectangle,
  /**
   * Oval type.
   */
  oval;

  @Override
  public String toString() {
    if (this == Type.rectangle) {
      return "rectangle";
    }

    if (this == Type.oval) {
      return "oval";
    }

    return "Shape's type not found";
  }
}
