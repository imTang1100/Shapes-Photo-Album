package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Album.
 */
public class Album implements IAlbum {

  private List<IShape> album = new ArrayList<>();

  @Override
  public List<IShape> getList() {
    return album;
  }

  @Override
  public void addPhoto(IShape photo) throws IllegalArgumentException {

    if (findPhoto(photo.getName()) == null) {
      album.add(photo);
    } else throw new IllegalArgumentException("Photo already exists!");
  }

  @Override
  public String movePhoto(String photoName, int toX, int toY) throws IllegalArgumentException {

    // fine the Shape by name
    IShape target = findPhoto(photoName);
    if (findPhoto(target.getName()) == null)
      throw new IllegalArgumentException("No such a photo");

    // execute command
    target.place(toX, toY);

    // report successful message
    return target.getName() + " moves to " + "(" + toX + "," + toY + ")" + "\n";
  }

  @Override
  public String resizePhoto(String photoName, int newParameterA, int newParameterB)
      throws IllegalArgumentException  {
    if (newParameterA <= 0 || newParameterB <= 0)
      throw new IllegalArgumentException("Parameter should be natural numbers");

    // find the Shape by name
    IShape target = findPhoto(photoName);

    // report successful message
    int oldX = target.getCoordinateX();
    int oldY = target.getCoordinateY();

    List<String> message = new ArrayList<>();
    if (newParameterA != target.getParameterA()) {
      message.add(target.getName() + " changes " + target.getCoordinateX()
          + " from " + oldX + " to " + newParameterA);
    }
    if (newParameterB != target.getParameterB()) {
      message.add(target.getName() + " changes " + target.getCoordinateY()
          + " from " + oldY + " to " + newParameterB);
    }

    // execute command
    target.reSize(newParameterA, newParameterB);

    return String.join("\n", message);
  }

  @Override
  public String removePhoto(String photoName) throws IllegalArgumentException  {
    // fine the Shape by name
    IShape target = findPhoto(photoName);

    if (findPhoto(target.getName()) == null)
      throw new IllegalArgumentException("No such a photo");

    // execute command
    album.remove(target);

    return target.getName() + " is removed" + "\n";
  }

  @Override
  public String changeColor(String photoName, double[] newColor)
      throws IllegalArgumentException  {
    // fine the Shape by name
    IShape target = findPhoto(photoName);

    if (findPhoto(target.getName()) == null)
      throw new IllegalArgumentException("No such a photo");

    // save the original color temporarily
    String oriColor = new String(target.getColor());

    // execute command
    target.setColor(newColor);

    // report message
    return target.getName() + " changes from " + oriColor + " to " + target.getColor() + "\n";
  }

  @Override
  public String takeSnapshot(String description) {
    IAlbum history = this.copy();
    Snapshot.getInstance().freezeFrame(history, description);

    return "Take a Snapshot" + "\n";
  }

  @Override
  public IShape findPhoto(String name) {
    IShape target = album.stream()
        .filter(x -> x.getName().equals(name)).findFirst().orElse(null);

    return target;
  }

  @Override
  public IAlbum copy() {
    IAlbum newCopy = new Album();
    for (IShape each: album) {
      IShape temp =  each.copy();
      newCopy.getList().add(temp);
    }
    return newCopy;
  }

  @Override
  public String toString() {
    return album.stream()
        .map(Object::toString)
        .collect(Collectors.joining("\n\n"));
  }
}
