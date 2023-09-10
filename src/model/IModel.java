package model;

/**
 * The interface Model.
 */
public interface IModel {

  /**
   * Move photo.
   *
   * @param name the name
   * @param newX the new x
   * @param newY the new y
   */
  void movePhoto(String name, int newX, int newY);

  /**
   * Change color.
   *
   * @param name  the name
   * @param color the color
   */
  void changeColor(String name, double[] color);

  /**
   * Resize photo.
   *
   * @param name the name
   * @param a    the a
   * @param b    the b
   */
  void resizePhoto(String name, int a, int b);

  /**
   * Gets album.
   *
   * @return the album
   */
  IAlbum getAlbum();

  /**
   * Remove photo.
   *
   * @param photoName the photo name
   */
  void removePhoto(String photoName);

  /**
   * Take snap shot.
   *
   * @param description the description
   */
  void takeSnapShot(String description);

  /**
   * Gets snap shots.
   *
   * @return the snap shots
   */
  ISnapshot getSnapShots();

  /**
   * New photo.
   *
   * @param color       the color
   * @param type        the type
   * @param name        the name
   * @param coordinateX the coordinate x
   * @param coordinateY the coordinate y
   * @param parameterA  the parameter a
   * @param parameterB  the parameter b
   */
  void newPhoto(double[] color, String type, String name, int coordinateX, int coordinateY,
      int parameterA, int parameterB);
}
