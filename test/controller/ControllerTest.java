package controller;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * The type Controller test.
 */
public class ControllerTest {

  private Controller controller;
  private Readable in;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    String input = "shape photo1 rectangle 0 0 100 200 1.0 0.0 0.0\n"
        + "move photo1 50 50\n"
        + "color photo1 0.0 0.0 1.0\n"
        + "resize photo1 50 100\n"
        + "remove photo1\n"
        + "snapshot My Snapshot\n";
    InputStream is = new ByteArrayInputStream(input.getBytes());
    in = new InputStreamReader(is);
    controller = new Controller(in, 800, 600, "graphical", "output.png");
  }

  /**
   * Test run.
   *
   * @throws IOException          the io exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRun() throws IOException, InterruptedException {
    controller.run();
    assertNotNull(controller.getModel());
    assertNotNull(controller.viewer);
  }
}

