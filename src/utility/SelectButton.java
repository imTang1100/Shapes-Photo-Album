package utility;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Objects;
import javax.swing.*;

import utility.AbstractButton;
import views.swing.GraphicalView;
import views.swing.PanelDrawer;
import views.swing.View;

/**
 * The type Select button.
 */
public class SelectButton extends AbstractButton {
  private View view;
  private GraphicalView graphicalView;
  private List<String> idList;
  private static final int FE = 0;   // FE means "FirstElement"
  private static final int IdIndex = 0;
  private static final int DescriptionIndex = 2;

  /**
   * Instantiates a new Select button.
   *
   * @param view          the view
   * @param graphicalView the graphical view
   */
  public SelectButton(View view, GraphicalView graphicalView) {
    super();
    this.view = view;
    this.graphicalView = graphicalView;
    idList = view.getController().getModel().getSnapShots().getIdStringList();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Component source = (Component) e.getSource();
    Object response = JOptionPane.showInputDialog(source,
        "Choose", "Menu", JOptionPane.PLAIN_MESSAGE,
        null, idList.toArray(), graphicalView.getJLabelID().getText());

    // the info list that be selected
    List<List<String>> snapShotInfo = view.getController().getModel().getSnapShots().getKeyList()
        .stream().filter(each -> each.get(IdIndex) == response).toList();

    if (snapShotInfo.size() != 0) {
      graphicalView.getjLabelDes().setText(snapShotInfo.get(FE).get(IdIndex));
      if (!Objects.equals(snapShotInfo.get(FE).get(DescriptionIndex), "")) {
        graphicalView.getMainPanelTitle().setLayout(new GridLayout(2, 1));
      } else {
        graphicalView.getMainPanelTitle().setLayout(new GridLayout());
      }
      graphicalView.getjLabelDes().setText(snapShotInfo.get(FE).get(DescriptionIndex));

      // call the list of shapes from album
      PanelDrawer drawer = new PanelDrawer(view.getController().getModel().getSnapShots()
          .getHashMap().get(snapShotInfo.get(FE)).getList());

      drawer.setWidth(graphicalView.getWidth());
      drawer.setHeight(graphicalView.getHeight());

      graphicalView.getMainPanelPic().add(drawer);
      graphicalView.getMainPanelPic().remove(FE);
      graphicalView.revalidate();

      // find the original index of history snapshot and set it as current index
      graphicalView.setIndex(view.getController().getModel().getSnapShots().getKeyList()
          .indexOf(snapShotInfo.get(FE)));
    }
  }


}
