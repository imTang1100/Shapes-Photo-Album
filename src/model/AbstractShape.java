package model;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * The type Abstract shape.
 */
public abstract class AbstractShape implements IShape {
  private double[] color;
  private Type type;
  private String name;
  private int coordinateX;
  private int coordinateY;
  private int parameterA;
  private int parameterB;
  private static final String OVAL = "oval";
  private static final String RECTANGLE = "rectangle";

  /**
   * Gets center string.
   *
   * @return the center string
   */
  protected abstract String getCenterString();

  /**
   * Gets co x string.
   *
   * @return the co x string
   */
  protected abstract String getCoXString();

  /**
   * Gets co y string.
   *
   * @return the co y string
   */
  protected abstract String getCoYString();

  /**
   * The Df.
   */
  protected DecimalFormat df = new DecimalFormat("0.0");


  /**
   * Instantiates a new Abstract shape.
   *
   * @param color       the color
   * @param type        the type
   * @param name        the name
   * @param coordinateX the coordinate x
   * @param coordinateY the coordinate y
   * @param parameterA  the parameter a
   * @param parameterB  the parameter b
   * @throws IllegalArgumentException the illegal argument exception
   */
  public AbstractShape(double[] color, String type, String name, int coordinateX, int coordinateY,
      int parameterA, int parameterB) throws IllegalArgumentException {

    if (color.length != 3 || !(color instanceof double[])) {
      throw new IllegalArgumentException("Color array should have length 3.");
    }
    if (parameterA <= 0 || parameterB <= 0) {
      throw new IllegalArgumentException("Parameters should be positive.");
    }
    if (name == null || name.isEmpty())
      throw new IllegalArgumentException("Name cannot be null nor empty");

    // check if the type is valid
    if (!checkEnumValid(type))
      throw new IllegalArgumentException("Shape type not found!");

    if (type != null || !type.isEmpty()) {
      String typeString = type.toLowerCase();
      switch (type) {
        case "rectangle" -> this.type = Type.rectangle;
        case "oval" -> this.type = Type.oval;
        default -> throw new IllegalArgumentException("Invalid shape type: " + type);
      }

      this.color = color;
      this.name = name;
      this.coordinateX = coordinateX;
      this.coordinateY = coordinateY;
      this.parameterA = parameterA;
      this.parameterB = parameterB;

      createSuccess();
    }
  }

  @Override
  public String createSuccess() {

    String center = getCenterString();
    String coX = getCoXString();
    String coY = getCoYString();

    return "Create " + this.getColor() + " " + this.getType() + " " + this.getName()
        + " with " + center + ": " + "(" + df.format(this.coordinateX).toString()
        + "," + df.format(this.coordinateY).toString() + "), " + coX + ": " + this.parameterA
        + ", " + coY + ": " + this.parameterB;
  }

  /**
   * Check enum valid boolean.
   *
   * @param anyType the any type
   * @return the boolean
   */
  public static boolean checkEnumValid(String anyType) {
    return Arrays.stream(Type.values())
        .map(Enum::name)
        .anyMatch(anyType::equalsIgnoreCase);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Type getType() {
    return this.type;
  }

  @Override
  public String getColor() {
    return Arrays.stream(this.color).mapToObj(e -> df.format(e)).collect(
        Collectors.joining(", ", "(", ")"));
  }

  @Override
  public double[] getColorDouble() {
    return this.color;
  }

  @Override
  public void setColor(double[] newColor) {
    this.color = newColor;
  }

  @Override
  public void place(int x, int y) {
    this.coordinateX = x;
    this.coordinateY = y;
  }

  @Override
  public void reSize(int newParameterA, int newParameterB) {
    this.parameterA = newParameterA;
    this.parameterB = newParameterB;
  }

  @Override
  public int getParameterA() {
    return this.parameterA;
  }

  @Override
  public int getParameterB() {
    return this.parameterB;
  }

  @Override
  public int getCoordinateX() {
    return this.coordinateX;
  }

  @Override
  public int getCoordinateY() {
    return this.coordinateY;
  }

  @Override
  public String toString() {
    String center = getCenterString();
    String coX = getCoXString();
    String coY = getCoYString();

    return  "Name: " + this.getName() + "\n"
        + "Type: " + this.getType().toString() + "\n"
        + center + ": " + "(" + df.format(this.coordinateX).toString()
        + "," + df.format(this.coordinateY).toString() + "), " + coX + ": " + this.parameterA
        + ", " + coY + ": " + this.parameterB + "," + "\n"
        + "Color: " + Arrays.stream(this.color).mapToObj(e -> df.format(e)).collect(
        Collectors.joining(", ", "(", ")"));
  }
}
