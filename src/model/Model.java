package model;

/**
 * The type Model.
 */
public class Model implements IModel {
  private ISnapshot snapshot;
  private IAlbum album;
  private IShape removedPhoto;
  private IShape newPhoto;

  /**
   * Instantiates a new Model.
   */
  public Model() {
    this.album = new Album();
    snapshot = Snapshot.getInstance();
  }

  @Override
  public void newPhoto(double[] color, String type, String name, int coordinateX, int coordinateY,
      int parameterA, int parameterB) {
    switch (type.toLowerCase()) {
      case "rectangle":
        newPhoto = new Rectangle(color, type, name, coordinateX, coordinateY,
            parameterA, parameterB);
        break;

      case "oval":
        newPhoto = new Oval(color, type, name, coordinateX, coordinateY,
            parameterA, parameterB);
        break;
    }
    album.addPhoto(newPhoto);
  }

  @Override
  public void movePhoto(String name, int newX, int newY) {
    album.movePhoto(name, newX, newY);
  }

  @Override
  public void changeColor(String name, double[] color) {
    album.changeColor(name, color);
  }

  @Override
  public void resizePhoto(String name, int a, int b) {
    album.resizePhoto(name, a, b);
  }

  @Override
  public IAlbum getAlbum() {
    return this.album;
  }

  @Override
  public void removePhoto(String photoName) {
    album.removePhoto(photoName);
  }

  @Override
  public void takeSnapShot(String description) {
    this.album.takeSnapshot(description);
  }

  @Override
  public ISnapshot getSnapShots() {
    return this.snapshot;
  }
}
