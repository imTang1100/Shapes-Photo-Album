package views.swing;

import java.awt.*;
import java.util.List;
import javax.swing.*;

import model.IShape;
import model.Type;

/**
 * The type Panel drawer.
 */
public class PanelDrawer extends JPanel {
  private List<IShape> photos;
  private int width;
  private int height;

  /**
   * Instantiates a new Panel drawer.
   *
   * @param photos the photos
   */
  public PanelDrawer(List<IShape> photos) {
    this.photos = photos;
  }

  /**
   * Sets width.
   *
   * @param width the width
   */
  public void setWidth(int width) {
    this.width = width;
  }

  /**
   * Sets height.
   *
   * @param height the height
   */
  public void setHeight(int height) {
    this.height = height;
  }

  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    setSize(width, height);
    setLocation(10, -20);
    setBackground(new Color(100,200,200));
    int count = 0;

    while (count < photos.size()) {
      int curr = count++;
      IShape shape = photos.get(curr);
      double[] color = shape.getColorDouble();
      int c1 = (int) color[0];
      int c2 = (int) color[1];
      int c3 = (int) color[2];
      graphics.setColor(new Color(c1, c2, c3));

      if (shape.getType() == Type.oval) {
        graphics.fillOval(shape.getCoordinateX(), shape.getCoordinateY(),
            shape.getParameterA(), shape.getParameterB());
      } else if (shape.getType() == Type.rectangle) {
        graphics.fillRect(shape.getCoordinateX(), shape.getCoordinateY(),
            shape.getParameterA(), shape.getParameterB());
      }
    }
  }
}
