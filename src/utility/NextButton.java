package utility;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

import views.swing.GraphicalView;
import views.swing.PanelDrawer;
import views.swing.View;

/**
 * The type Next button.
 */
public class NextButton extends AbstractButton {

  private final static int BASE_PIC_INDEX = 0;

  /**
   * Instantiates a new Next button.
   *
   * @param view          the view
   * @param graphicalView the graphical view
   */
  public NextButton(View view, GraphicalView graphicalView) {
    super(view, graphicalView);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    int index = super.getGraphicalView().getIndex();
    if (index < super.getHashMap().size() - 1) {
      int curr = index + 1;
      super.getGraphicalView().setIndex(curr);
      super.getGraphicalView().getJLabelID().setText(super.getView().getController().getModel()
          .getSnapShots().getID(curr));

      if (!Objects.equals(super.getView().getController().getModel().getSnapShots()
          .getDescriptionByIndex(curr), "")) {
        super.getGraphicalView().getMainPanelTitle().setLayout(new GridLayout(2, 1));
      } else {
        super.getGraphicalView().getMainPanelTitle().setLayout(new GridLayout());
      }

      super.getGraphicalView().getjLabelDes().setText(super.getView().getController().getModel()
          .getSnapShots().getDescriptionByIndex(curr));
      PanelDrawer drawer = new PanelDrawer(super.getView().getController().getModel()
          .getSnapShots().getAlbum(curr).getList());
      drawer.setWidth((super.getGraphicalView().getWidth()));
      drawer.setHeight(super.getGraphicalView().getHeight());
      super.getGraphicalView().getMainPanelPic().add(drawer);

      // take out the first snapshot of album
      super.getGraphicalView().getMainPanelPic().remove(BASE_PIC_INDEX);
      super.getGraphicalView().revalidate();
    } else {
      JOptionPane.showMessageDialog(super.getGraphicalView(),
          "\nThis is the last album's snapshot! \n\n");
    }
  }
}
