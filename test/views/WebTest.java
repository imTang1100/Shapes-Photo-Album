package views;

import controller.Controller;

/**
 * The type Web test.
 */
public class WebTest extends Controller {

  /**
   * Instantiates a new Web test.
   *
   * @param in     the in
   * @param width  the width
   * @param height the height
   * @param view   the view
   * @param out    the out
   */
  public WebTest(Readable in, int width, int height, String view, String out) {
    super(in, width, height, view, out);
  }

  /**
   * Gets web viewer.
   *
   * @return the web viewer
   */
  public WebView getWebViewer() {
    return (WebView) super.viewer;
  }
}
