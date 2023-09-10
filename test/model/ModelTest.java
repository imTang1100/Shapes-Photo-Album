package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * The type Model test.
 */
public class ModelTest {

    private IModel model = new Model();;
    private IAlbum album = new Album();

  /**
   * Test new photo.
   */
  @Test
    public void testNewPhoto() {
      model.getSnapShots().reset();
      double[] color = new double[]{0.0, 0.0, 0.0};
      String type = "rectangle";
      String name = "photo1";
      int coordinateX = 100;
      int coordinateY = 200;
      int parameterA = 50;
      int parameterB = 80;

      Rectangle newPhoto = new Rectangle(color, type, name, coordinateX, coordinateY, parameterA,
          parameterB);
      album.addPhoto(newPhoto);
      album.takeSnapshot("");
      assertEquals(1, model.getSnapShots().getAlbum(0).getList().size());
      assertEquals(name, model.getSnapShots().getAlbum(0).getList().get(0).getName());
    }

  /**
   * Test move photo.
   */
  @Test
    public void testMovePhoto() {
      model.getSnapShots().reset();
      double[] color = new double[]{0.0, 0.0, 0.0};
      String type = "rectangle";
      String name = "photo1";
      int coordinateX = 100;
      int coordinateY = 200;
      int parameterA = 50;
      int parameterB = 80;
      Rectangle newPhoto =
          new Rectangle(color, type, name, coordinateX, coordinateY, parameterA, parameterB);
      album.addPhoto(newPhoto);
      newPhoto.place(150, 250);
      album.takeSnapshot("");
      assertEquals(150, model.getSnapShots().getAlbum(0)
          .findPhoto(name).getCoordinateX());
      assertEquals(250, model.getSnapShots().getAlbum(0).findPhoto(name)
          .getCoordinateY());
    }

  /**
   * Test change color.
   */
  @Test
    public void testChangeColor() {
      model.getSnapShots().reset();
      double[] color = new double[]{0.0, 0.0, 0.0};
      String type = "rectangle";
      String name = "photo1";
      int coordinateX = 100;
      int coordinateY = 200;
      int parameterA = 50;
      int parameterB = 80;
      Rectangle newPhoto =
          new Rectangle(color, type, name, coordinateX, coordinateY, parameterA, parameterB);
      album.addPhoto(newPhoto);
      double[] newColor = {1.0, 1.0, 1.0};
      newPhoto.setColor(newColor);
      album.takeSnapshot("");
      assertEquals(newColor.toString(), model.getSnapShots().getAlbum(0).findPhoto(name)
          .getColorDouble().toString());
    }

  /**
   * Test resize photo.
   */
  @Test
    public void testResizePhoto() {
      model.getSnapShots().reset();
      double[] color = new double[]{0.0, 0.0, 0.0};
      String type = "rectangle";
      String name = "photo1";
      int coordinateX = 100;
      int coordinateY = 200;
      int parameterA = 50;
      int parameterB = 80;
      Rectangle newPhoto =
          new Rectangle(color, type, name, coordinateX, coordinateY, parameterA, parameterB);
      album.addPhoto(newPhoto);

      int newParameterA = 60;
      int newParameterB = 90;
      newPhoto.reSize(newParameterA, newParameterB);

      album.takeSnapshot("");

      assertEquals(newParameterA, model.getSnapShots().getAlbum(0)
          .findPhoto(name).getParameterA());
      assertEquals(newParameterB, model.getSnapShots().getAlbum(0)
          .findPhoto(name).getParameterB());
    }

  /**
   * Gets album.
   */
  @Test
  public void getAlbum() {
    model.getSnapShots().reset();
    album.takeSnapshot("");
    assertEquals(album.toString(), model.getSnapShots().getAlbum(0).toString());
  }

  /**
   * Remove photo.
   */
  @Test
  public void removePhoto() {
    model.getSnapShots().reset();
    double[] color = new double[]{0.0, 0.0, 0.0};
    String type = "rectangle";
    String name = "photo1";
    int coordinateX = 100;
    int coordinateY = 200;
    int parameterA = 50;
    int parameterB = 80;
    Rectangle newPhoto =
        new Rectangle(color, type, name, coordinateX, coordinateY, parameterA, parameterB);
    album.addPhoto(newPhoto);
    album.removePhoto(name);
    album.takeSnapshot("");
    assertNull(model.getSnapShots().getAlbum(0).findPhoto(name));
  }

  /**
   * Take snap shot.
   */
  @Test
  public void takeSnapShot() {
    model.getSnapShots().reset();
    model = new Model();
    album = new Album();
    double[] color = new double[]{0.0, 0.0, 0.0};
    String type = "rectangle";
    String name = "photo1";
    int coordinateX = 100;
    int coordinateY = 200;
    int parameterA = 50;
    int parameterB = 80;

    Rectangle newPhoto = new Rectangle(color, type, name, coordinateX, coordinateY, parameterA,
        parameterB);
    album.addPhoto(newPhoto);
    album.takeSnapshot("first snapshot");

    assertEquals("Description: first snapshot",
        model.getSnapShots().getDescriptionByIndex(0));
    assertEquals(1, model.getSnapShots().getAlbum(0).getList().size());
    assertEquals(name, model.getSnapShots().getAlbum(0).getList().get(0).getName());
  }

  /**
   * Gets snap shots.
   */
  @Test
  public void getSnapShots() {
    model.getSnapShots().reset();
    model = new Model();
    album = new Album();
    double[] color = new double[]{0.0, 0.0, 0.0};
    String type = "rectangle";
    String name = "photo1";
    int coordinateX = 100;
    int coordinateY = 200;
    int parameterA = 50;
    int parameterB = 80;

    Rectangle newPhoto = new Rectangle(color, type, name, coordinateX, coordinateY, parameterA,
        parameterB);
    album.addPhoto(newPhoto);
    album.takeSnapshot("");
    model.takeSnapShot("first snapshot");

    assertNotNull(model.getSnapShots());
    assertEquals(2, model.getSnapShots().getKeyList().size());
  }
}