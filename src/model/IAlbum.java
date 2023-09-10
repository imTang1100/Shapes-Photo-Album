package model;

import java.util.List;

/**
 * The interface Album.
 */
public interface IAlbum {

  /**
   * Gets list.
   *
   * @return the list
   */
  List<IShape> getList();

  /**
   * Add photo.
   *
   * @param photo the photo
   * @throws IllegalArgumentException the illegal argument exception
   */
  void addPhoto(IShape photo) throws IllegalArgumentException;

  /**
   * Move photo string.
   *
   * @param photoName the photo name
   * @param toA       the to a
   * @param toB       the to b
   * @return the string
   * @throws IllegalArgumentException the illegal argument exception
   */
  String movePhoto(String photoName, int toA, int toB) throws IllegalArgumentException;

  /**
   * Remove photo string.
   *
   * @param photoName the photo name
   * @return the string
   * @throws IllegalArgumentException the illegal argument exception
   */
  String removePhoto(String photoName) throws IllegalArgumentException;

  /**
   * Resize photo string.
   *
   * @param photoName     the photo name
   * @param newParameterA the new parameter a
   * @param newParameterB the new parameter b
   * @return the string
   * @throws IllegalArgumentException the illegal argument exception
   */
  String resizePhoto(String photoName, int newParameterA, int newParameterB)
      throws IllegalArgumentException;

  /**
   * Change color string.
   *
   * @param photoName the photo name
   * @param newColor  the new color
   * @return the string
   * @throws IllegalArgumentException the illegal argument exception
   */
  String changeColor(String photoName, double[] newColor) throws IllegalArgumentException;

  /**
   * Take snapshot string.
   *
   * @param description the description
   * @return the string
   */
  String takeSnapshot(String description);

  /**
   * Find photo shape.
   *
   * @param name the name
   * @return the shape
   */
  IShape findPhoto(String name);

  /**
   * Copy album.
   *
   * @return the album
   */
  IAlbum copy();
}
