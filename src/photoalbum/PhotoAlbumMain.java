package photoalbum;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.Scanner;
import javax.swing.*;

import controller.Controller;

/**
 * The type Photo album main.
 */
public class PhotoAlbumMain {
  private final static int INISIZE = 1000;
  private final static int GRA_WID_INDEX = 4;
  private final static int GRA_HEI_INDEX = 5;

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    String in = "";
    String out = "";
    String view = "";
    int width = INISIZE;
    int height = INISIZE;

    for (int i = 0; i < args.length; i++) {
      in = args[i].equalsIgnoreCase("-in") ? args[i + 1] : in;
      out = args[i].equalsIgnoreCase("-out") ? args[i + 1] : out;


      if (args[i].equalsIgnoreCase("-view")
          || args[i].equalsIgnoreCase("-v")) {
        view = args[i + 1];

        width = (view.equalsIgnoreCase("graphical")
            && args.length > GRA_WID_INDEX) ? Integer.parseInt(args[i + 2]) : width;

        height = (view.equalsIgnoreCase("graphical")
            && args.length > GRA_HEI_INDEX) ? Integer.parseInt(args[i + 3]) : height;
      }
    }

    try {
      Scanner scanner = new Scanner(new FileReader(in));
      StringBuilder stringBuilder = new StringBuilder();
      while (scanner.hasNextLine()) {
        String str = scanner.nextLine();
        if (str.length() != 0) {
          char c = str.charAt(0);
          if (!Character.toString(c).equals("#")) {
            stringBuilder.append(str.strip()).append("\n");
          }
        }
      }
      // If the view is set to "web" and no output file is specified,
      // set a default output file name
      if (out.equals("")
          && view.equalsIgnoreCase("web")) {
        out = "output.html";
      }

      if ((out.equalsIgnoreCase("-v")
          || out.equalsIgnoreCase("-view")
          || out.equalsIgnoreCase("-in") && view.equalsIgnoreCase("web"))) {
        throw new IllegalArgumentException();
      }

      new Controller(new StringReader(stringBuilder.toString()),
          width, height, view, out).run();
    } catch (FileNotFoundException e) {

      JOptionPane.showMessageDialog(null,
          "No input file found!",
          "Shapes Photo Album Viewer", JOptionPane.ERROR_MESSAGE);
      System.exit(0);

    }  catch (InterruptedException e) {

      throw new RuntimeException(e);

    } catch (IllegalArgumentException e) {

      JOptionPane.showMessageDialog(null,
          "Empty output file name!",
          "Shapes Photo Album Viewer", JOptionPane.ERROR_MESSAGE);
      System.exit(0);

    } catch (Exception e) {
      JOptionPane.showMessageDialog(null,
          "The output set is invalid!",
          "Shapes Photo Album Viewer", JOptionPane.ERROR_MESSAGE);
      System.exit(0);
    }
  }
}