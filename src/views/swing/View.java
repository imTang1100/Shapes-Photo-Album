package views.swing;

import java.io.IOException;

import controller.IController;
import views.IView;

/**
 * The type View.
 */
public class View implements IView {

  private IController controller;

  /**
   * Instantiates a new View.
   *
   * @param controller the controller
   */
  public View(IController controller) {
    this.controller = controller;
  }

  /**
   * Gets controller.
   *
   * @return the controller
   */
  // interact with controller and other view components
  public IController getController() {
    return controller;
  }
  @Override
  public void paint() throws IOException {
  }
}
