package model;

/**
 * The type Oval.
 */
public class Oval extends AbstractShape {

  /**
   * Instantiates a new Oval.
   *
   * @param color       the color
   * @param type        the type
   * @param name        the name
   * @param coordinateX the coordinate x
   * @param coordinateY the coordinate y
   * @param parameterA  the parameter a
   * @param parameterB  the parameter b
   */
  public Oval(double[] color, String type, String name, int coordinateX, int coordinateY,
      int parameterA, int parameterB) {
    super(color, type, name, coordinateX, coordinateY, parameterA, parameterB);
  }

  @Override
  protected String getCenterString() {
    return "Center";
  }

  @Override
  protected String getCoXString() {
    return "X radius";
  }

  @Override
  protected String getCoYString() {
    return "Y radius";
  }

  @Override
  public IShape copy() {
    return new Oval(this.getColorDouble(), this.getType().toString(),
        this.getName(), this.getCoordinateX(), this.getCoordinateY(),
        this.getParameterA(), this.getParameterB());
  }
}
