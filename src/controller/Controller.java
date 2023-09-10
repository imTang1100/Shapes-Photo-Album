package controller;

import java.io.IOException;
import java.util.Scanner;

import model.IModel;
import model.Model;
import views.IView;
import views.WebView;
import views.swing.GraphicalView;

/**
 * The type Controller.
 */
public class Controller implements IController {
  private static IModel model = null;
  private Readable in;
  private int width;
  private int height;
  private String view;
  private String out;
  /**
   * The Viewer.
   */
  protected IView viewer;

  /**
   * Instantiates a new Controller.
   *
   * @param in     the in
   * @param width  the width
   * @param height the height
   * @param view   the view
   * @param out    the out
   */
  public Controller(Readable in, int width, int height,
      String view, String out) {
    this.in = in;
    this.width = width;
    this.height = height;
    this.view = view;
    this.out = out;
    this.model = getInstance();
  }

  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static IModel getInstance() {
    if (model == null) {
      model = new Model();
    }
    return model;
  }

  @Override
  public IModel getModel() {
    return this.model;
  }

  @Override
  public void run() throws IOException, InterruptedException {
    Scanner scan = new Scanner(this.in);
    String type, name;
    double r, g, b;
    int paraA, paraB, coorX, coorY;

    while (true) {
      if (scan.hasNext()) {
        switch (scan.next().toLowerCase()) {
          case "shape":
            name = scan.next();
            type = scan.next();
            coorX = scan.nextInt();
            coorY = scan.nextInt();
            paraA = scan.nextInt();
            paraB = scan.nextInt();
            r = scan.nextDouble();
            ;
            g = scan.nextDouble();
            b = scan.nextDouble();
            double[] color = new double[]{r, g, b};
            model.newPhoto(color, type, name, coorX, coorY, paraA, paraB);
            break;

          case "move":
            String nameM = scan.next();
            int newX = scan.nextInt();
            int newY = scan.nextInt();
            model.movePhoto(nameM, newX, newY);
            break;

          case "color":
            String nameC = scan.next();
            double newR = scan.nextDouble();
            double newG = scan.nextDouble();
            double newB = scan.nextDouble();
            double[] newColor = new double[]{newR, newG, newB};
            model.changeColor(nameC, newColor);
            break;

          case "resize":
            String nameR = scan.next();
            int newParaA = scan.nextInt();
            int newParaB = scan.nextInt();
            model.resizePhoto(nameR, newParaA, newParaB);
            break;

          case "remove":
            String nameRM = scan.next();
            model.removePhoto(nameRM);
            break;

          case "snapshot":
            String description = scan.hasNext() ? scan.nextLine() : "";
            model.takeSnapShot(description);
            break;

          default:
            return;
        }
      }
      else {
        break;
      }
    }

    if (view.equalsIgnoreCase("graphical")) {
      viewer = new GraphicalView(this, width, height);
    } else if (view.equalsIgnoreCase("web")) {
      viewer = new WebView(this, width, height, out);
    }
    viewer.paint();
  }
}

