package model;

/**
 * The type Rectangle.
 */
public class Rectangle extends AbstractShape {

  /**
   * Instantiates a new Rectangle.
   *
   * @param color       the color
   * @param type        the type
   * @param name        the name
   * @param coordinateX the coordinate x
   * @param coordinateY the coordinate y
   * @param parameterA  the parameter a
   * @param parameterB  the parameter b
   */
  public Rectangle(double[] color, String type, String name, int coordinateX, int coordinateY,
      int parameterA, int parameterB) {
    super(color, type, name, coordinateX, coordinateY, parameterA, parameterB);
  }

  @Override
  protected String getCenterString() {
    return "Min corner";
  }

  @Override
  protected String getCoXString() {
    return "Width";
  }

  @Override
  protected String getCoYString() {
    return "Height";
  }

  @Override
  public IShape copy() {
    return new Rectangle(this.getColorDouble(), this.getType().toString(),
        this.getName(), this.getCoordinateX(), this.getCoordinateY(),
        this.getParameterA(), this.getParameterB());
  }
}
