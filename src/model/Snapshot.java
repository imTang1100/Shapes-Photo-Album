package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Snapshot.
 */
public class Snapshot implements ISnapshot {

  private static Snapshot instance = null;
  //private IAlbum OneAlbum;
  private HashMap<List<String>, IAlbum> history = new HashMap<>();
  private ArrayList<List<String>> keyList = new ArrayList<>();
  private ArrayList<IAlbum> valueList = new ArrayList<>();
  private String description;

  /**
   * Instantiates a new Snapshot.

  public Snapshot() {
    // Initialize the hashMap
    history = new HashMap<>();
    keyList = new ArrayList<>();
    valueList = new ArrayList<>();
  }
   */

  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static Snapshot getInstance() {
    if (instance == null) {
      instance = new Snapshot();
    }
    return instance;
  }

  @Override
  public HashMap<List<String>, IAlbum> getHashMap() {
    return this.history;
  }

  @Override
  public IAlbum getAlbum(int index) {
    return valueList.get(index);
  }

  @Override
  public List<String> getKey(int index) {
    return keyList.get(index);
  }

  @Override
  public ArrayList<List<String>> getKeyList() {
    return keyList;
  }

  @Override
  public ArrayList<IAlbum> getValueList() {
    return valueList;
  }

  @Override
  public List<String> getIdStringList() {
    return keyList.stream()
        .map(e -> e.get(0)).collect(Collectors.toList());
  }

  @Override
  public String getID(int index) {
    // in getTime method the ID is saved at the index 0
    return keyList.get(index).get(0);
  }

  @Override
  public List<String> getTime() {
    // to store Snapshot ID and Timestamp
    List<String> keyString = new ArrayList<>();

    // save current time when call snapshot
    Date current = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
    String snapshotID = "Snapshot ID: " + formatter.format(current);

    SimpleDateFormat stamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String timeStamp = "Timestamp: " + stamp.format(current);

    keyString.add(snapshotID);
    keyString.add(timeStamp);

    return keyString;
    //return "Snapshot ID: " + snapshotID + "\n" + "Timestamp: " + timeStamp + "\n";
  }

  @Override
  public void setDescription(String description) {
    this.description = null;
    this.description = description;
  }

  @Override
  public String getDescription() {
    return "Description: " + this.description;
  }

  @Override
  // in freezeFrame the description is saved at index 2
  public String getDescriptionByIndex(int index) { return keyList.get(index).get(2); }

  @Override
  public void freezeFrame(IAlbum oneA, String descripetion) {
    List<String> albumInfo = getTime();
    this.setDescription(descripetion);

    // a String list includes [0] ID [1] stamp [2] description
    albumInfo.add(getDescription());

    // String albumInfo = getTime() + getDescription();
    history.put(albumInfo, oneA);

    // save the hashmap's key and value in two arraylist at the same time
    keyList.add(albumInfo);
    valueList.add(oneA);
  }

  @Override
  public void reset() {
    this.description = null;

    // clear all the data structure
    this.getHashMap().clear();
    this.keyList.clear();
    this.valueList.clear();
  }

  @Override
  public String printAll() {
    StringBuilder all = new StringBuilder();
    all.append("---------------------------------------------------------------" + "\n");
    all.append("Printing Snapshots\n");
    for (Map.Entry<List<String>, IAlbum> entry : history.entrySet()) {
      List<String> front = entry.getKey();
      IAlbum album = entry.getValue();
      all.append(front.stream().map(e -> e.toString()).collect(Collectors.joining("\n")));
      all.append("Shape Information:\n");
      all.append(album.toString());
      all.append("\n");
    }
    return all.toString();
  }
}
