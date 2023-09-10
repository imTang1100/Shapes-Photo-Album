package views;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import controller.IController;
import model.IAlbum;
import model.IShape;
import model.Type;

/**
 * The type Web view.
 */
public class WebView implements IView {

  private IController controller;
  private int width;
  private int height;
  private FileWriter htmlTempFile;
  private final StringBuilder html;
  //private final StringBuilder html = new StringBuilder();


  /**
   * Instantiates a new Web view.
   *
   * @param controller the controller
   * @param width      the width
   * @param height     the height
   * @param name       the name
   * @throws IOException the io exception
   */
  public WebView(IController controller, int width, int height, String name) throws IOException {
    this.controller = controller;
    this.width = width;
    this.height = height;
    this.htmlTempFile = new FileWriter(name);
    this.html = new StringBuilder();
  }

  @Override
  public void paint() throws IOException {
    html.append( "<!doctype html>\n" );
    html.append( "<html lang='en'>\n" );

    html.append( "<head>\n" );
    html.append( "<meta charset='utf-8'>\n" );
    html.append( "<title>Webview</title>\n" );
    html.append( "</head>\n\n" );

    html.append("<style>\n").append(
        "    .snapshot {\n").append(
        "        border: 3px outset yellow;\n").append(
        "        background-color: green;\n").append(
        "    }\n").append(
        "</style>\n");

    // get the information of each album's snapshot
    html.append( "<body>\n" );

    int index = 0;
    for (IAlbum album: controller.getModel().getSnapShots().getValueList()) {
      List<String> info = controller.getModel().getSnapShots().getKeyList().get(index++);
      html.append("\t<div class='information'>\n");
      html.append("\t\t<h1>").append(info.get(0)).append("</h1>\n");
      html.append("\t\t<p>").append("Description: ").append(info.get(2)).append("</p>\n");

      // set width and height
      html.append("\t\t<svg width='").append(width)
          .append("' height='").append(height).append("'>\n");
      for (IShape shape: album.getList()) {
        if (shape.getType() == Type.oval) {
          html.append("\t\t\t<ellipse " + "cx='").append(shape.getCoordinateX())
              .append("' cy='").append(shape.getCoordinateY()).append("' rx='")
              .append(shape.getParameterA()).append("' ry='")
              .append(shape.getParameterB())
              .append("' fill='rgb(").append((int) shape.getColorDouble()[0])
              .append(",").append((int) shape.getColorDouble()[1])
              .append(",").append((int) shape.getColorDouble()[2])
              .append(")").append("'/>\n");
        } else {
          html.append("\t\t\t<rect " + "x='").append((int) shape.getCoordinateX())
              .append("' y='").append((int) shape.getCoordinateY()).append("' width='")
              .append((int) shape.getParameterA()).append("' height='")
              .append((int) shape.getParameterB())
              .append("' fill='rgb(").append((int) shape.getColorDouble()[0])
              .append(",").append((int) shape.getColorDouble()[1])
              .append(",").append((int) shape.getColorDouble()[2])
              .append(")").append("'/>\n");
        }
      }
      html.append("\t\t</svg>\n");
      html.append("\t</div>\n");

      html.append("\t<hr />\n");
    }

    html.append( "</body>\n\n" );

    html.append( "</html>" );
    htmlTempFile.write(html.toString());
    htmlTempFile.close();
  }

  /**
   * Gets html.
   *
   * @return the html
   */
  public StringBuilder getHtml() {
    return html;
  }
}
