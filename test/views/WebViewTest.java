package views;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import controller.Controller;

/**
 * The type Web view test.
 */
public class WebViewTest {

  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * Paint.
   *
   * @throws IOException          the io exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void paint() throws IOException, InterruptedException {
    Scanner scanner = new Scanner(new FileReader("buildings.txt"));
    StringBuilder stringBuilder = new StringBuilder();
    while (scanner.hasNextLine()) {
      String str = scanner.nextLine();
      if (str.length() != 0) {
        char newC = str.charAt(0);
        if (!Character.toString(newC).equals("#")) {
          stringBuilder.append(str.strip()).append("\n");
        }
      }
    }
    WebTest controller = new WebTest(new StringReader(stringBuilder.toString()), 1000
        , 1000, "web", "testWeb.html");
    controller.run();
    FileReader reader = new FileReader("testWeb.html");
    BufferedReader bReader = new BufferedReader(reader);
    StringBuilder content = new StringBuilder(1024);
    String testS;
    while((testS = bReader.readLine())!=null) {
      content.append(testS).append("\n");
    }

    assertEquals(controller.getWebViewer().getHtml().toString()
        , content.delete(content.length() - 1, content.length()).toString());

    scanner = new Scanner(new FileReader("demo_input.txt"));
    stringBuilder = new StringBuilder();
    while (scanner.hasNextLine()) {
      String s = scanner.nextLine();
      if (s.length() != 0) {
        char c = s.charAt(0);
        if (!Character.toString(c).equals("#")) {
          stringBuilder.append(s.strip()).append("\n");
        }
      }
    }

    controller = new WebTest(new StringReader(stringBuilder.toString()), 1000, 1000
        , "web", "testWeb.html");

    controller.run();
    reader = new FileReader("testWeb.html");
    bReader = new BufferedReader(reader);

    content = new StringBuilder();
    while ((testS = bReader.readLine()) != null) {
      content.append(testS).append("\n");
    }

    assertEquals(controller.getWebViewer().getHtml().toString()
        , content.delete(content.length() - 1, content.length()).toString());
    }
  }