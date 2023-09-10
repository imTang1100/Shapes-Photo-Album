package model;

/**
 * The interface Shape.
 */
public interface IShape {

  /**
   * Create success string.
   *
   * @return the string
   */
  String createSuccess();

  /**
   * Gets name.
   *
   * @return the name
   */
  String getName();

  /**
   * Gets type.
   *
   * @return the type
   */
  Type getType();

  /**
   * Gets color.
   *
   * @return the color
   */
  String getColor();

  /**
   * Get color double double [ ].
   *
   * @return the double [ ]
   */
  double[] getColorDouble();

  /**
   * Sets color.
   *
   * @param newColor the new color
   */
  void setColor(double[] newColor);

  /**
   * Place.
   *
   * @param toX the to x
   * @param toY the to y
   */
  void place(int toX, int toY);

  /**
   * Re size.
   *
   * @param newParameterA the new parameter a
   * @param newParameterB the new parameter b
   */
  void reSize(int newParameterA, int newParameterB);

  /**
   * Gets parameter a.
   *
   * @return the parameter a
   */
  int getParameterA();

  /**
   * Gets parameter b.
   *
   * @return the parameter b
   */
  int getParameterB();

  /**
   * Gets coordinate x.
   *
   * @return the coordinate x
   */
  int getCoordinateX();

  /**
   * Gets coordinate y.
   *
   * @return the coordinate y
   */
  int getCoordinateY();

  String toString();

  /**
   * Check enum valid boolean.
   *
   * @param type the type
   * @return the boolean
   */
  static boolean checkEnumValid(String type) {
    return false;
  }

  /**
   * Copy shape.
   *
   * @return the shape
   */
  IShape copy();
}
