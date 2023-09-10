package utility;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

import utility.AbstractButton;
import views.swing.GraphicalView;
import views.swing.PanelDrawer;
import views.swing.View;

/**
 * The type Previous button.
 */
public class PreviousButton extends AbstractButton {

  private View view;
  private GraphicalView graphicalView;
  private final static int BASE_PIC_INDEX = 0;

  /**
   * Instantiates a new Previous button.
   *
   * @param view          the view
   * @param graphicalView the graphical view
   */
  public PreviousButton(View view, GraphicalView graphicalView) {
    super();
    this.view = view;
    this.graphicalView = graphicalView;
  }

  /**
   * Perform the action.
   *
   * @param e the ActionEvent
   */
  public void actionPerformed(ActionEvent e) {
    int index = graphicalView.getIndex();
    if (index <= 0) {
      JOptionPane.showMessageDialog(graphicalView, "No previous album.");
    } else {
      int currIndex = index - 1;
      graphicalView.setIndex(currIndex);
      graphicalView.getJLabelID().setText(view.getController().getModel().getSnapShots()
          .getID(currIndex));

      graphicalView.getjLabelDes().setText(view.getController().getModel().getSnapShots()
          .getDescriptionByIndex(currIndex));
      if (!Objects.equals(view.getController().getModel().getSnapShots()
          .getDescriptionByIndex(currIndex), "")) {
        graphicalView.getMainPanelTitle().setLayout(new GridLayout(2, 1));
      } else {
        graphicalView.getMainPanelTitle().setLayout(new GridLayout());
      }

      PanelDrawer drawer = new PanelDrawer(view.getController().getModel().getSnapShots()
          .getAlbum(currIndex).getList());
      drawer.setHeight(graphicalView.getHeight());
      drawer.setWidth(graphicalView.getWidth());

      graphicalView.getMainPanelPic().add(drawer);
      graphicalView.getMainPanelPic().remove(BASE_PIC_INDEX);
      graphicalView.revalidate();
    }
  }
}
