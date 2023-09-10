package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The interface Snapshot.
 */
public interface ISnapshot {

  /**
   * Gets description.
   *
   * @return the description
   */
  String getDescription();

  /**
   * Sets description.
   *
   * @param description the description
   */
  void setDescription(String description);

  /**
   * Gets description by index.
   *
   * @param index the index
   * @return the description by index
   */
// in freezeFrame the description is saved at index 2
  String getDescriptionByIndex(int index);

  /**
   * Freeze frame.
   *
   * @param oneA         the one a
   * @param descripetion the descripetion
   */
  void freezeFrame(IAlbum oneA, String descripetion);

  /**
   * Reset.
   */
  void reset();

  /**
   * Print all string.
   *
   * @return the string
   */
  String printAll();

  /**
   * Gets hash map.
   *
   * @return the hash map
   */
  HashMap<List<String>, IAlbum> getHashMap();

  /**
   * Gets album.
   *
   * @param index the index
   * @return the album
   */
  IAlbum getAlbum(int index);

  /**
   * Gets key.
   *
   * @param index the index
   * @return the key
   */
  List<String> getKey(int index);

  /**
   * Gets key list.
   *
   * @return the key list
   */
  ArrayList<List<String>> getKeyList();

  /**
   * Gets value list.
   *
   * @return the value list
   */
  ArrayList<IAlbum> getValueList();

  /**
   * Gets id string list.
   *
   * @return the id string list
   */
  List<String> getIdStringList();

  /**
   * Gets id.
   *
   * @param index the index
   * @return the id
   */
  String getID(int index);

  /**
   * Gets time.
   *
   * @return the time
   */
  List<String> getTime();
}