package views.swing;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

import javax.swing.*;

import controller.IController;
import utility.NextButton;
import utility.PreviousButton;
import utility.QuitButton;
import utility.SelectButton;
import views.IView;


/**
 * The type Graphical view.
 */
public class GraphicalView extends JFrame implements IView {
  private JPanel mainPanelTitle;
  private JPanel mainPanelPic;
  private JPanel mainPanelOpt;
  private JLabel jLabelID;
  private JLabel jLabelDes;
  private IController controller;
  private int width;
  private int height;
  private int index = 0;

  /**
   * Instantiates a new Graphical view.
   *
   * @param controller the controller
   * @param width      the width
   * @param height     the height
   */
  public GraphicalView(IController controller, int width, int height) {

    this.controller = controller;
    this.width = width;
    this.height = height;
  }

  /**
   * Gets main panel pic.
   *
   * @return the main panel pic
   */
  public JPanel getMainPanelPic() {
    return mainPanelPic;
  }

  /**
   * Gets main panel title.
   *
   * @return the main panel title
   */
  public JPanel getMainPanelTitle() {
    return mainPanelTitle;
  }

  /**
   * Gets main panel opt.
   *
   * @return the main panel opt
   */
  public JPanel getMainPanelOpt() {
    return mainPanelOpt;
  }

  /**
   * Gets index.
   *
   * @return the index
   */
  public int getIndex() {
    return index;
  }

  /**
   * Sets index.
   *
   * @param index the index
   */
  public void setIndex(int index) {
    this.index = index;
  }

  /**
   * Gets j label id.
   *
   * @return the j label id
   */
  public  JLabel getJLabelID() {
    return jLabelID;
  }

  /**
   * Gets label des.
   *
   * @return the label des
   */
  public JLabel getjLabelDes() {
    return jLabelDes;
  }

  @Override
  public void paint() throws IOException {
    // initiate frame
    setSize(width, height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Shapes Photo Album Viewer");

    // set frame's information
    mainPanelTitle = new JPanel(new GridLayout());
    jLabelID = new JLabel(controller.getModel().getSnapShots().getID(index));
    if (!Objects.equals(controller.getModel().getSnapShots()
        .getDescriptionByIndex(index), "")) {
      mainPanelTitle.setLayout(new GridLayout(2, 1));
      jLabelDes = new JLabel(controller.getModel().getSnapShots()
          .getDescriptionByIndex(index));
    } else {
      jLabelDes = new JLabel();
    }

    mainPanelTitle.add(jLabelID);
    mainPanelTitle.add(jLabelDes);
    mainPanelTitle.setBackground(Color.CYAN);

    // draw photos
    mainPanelPic = new JPanel(new GridLayout());
    PanelDrawer panelDrawer = new PanelDrawer(controller.getModel().getSnapShots()
        .getAlbum(index).getList());
    panelDrawer.setHeight(height);
    panelDrawer.setWidth(width);
    mainPanelPic.add(panelDrawer, BorderLayout.CENTER);

    mainPanelOpt = new JPanel(new FlowLayout());
    mainPanelOpt.setBackground(Color.PINK );

    // set bottom buttons
    View viewButton = new View(controller);

    JButton button1 = new JButton(" << Pre << ");
    button1.addActionListener(new PreviousButton(viewButton, this));

    JButton button2 = new JButton(" ^^ Select ^^ ");
    button2.addActionListener(new SelectButton(viewButton, this));

    JButton button3 = new JButton(" >> Next >> ");
    button3.addActionListener(new NextButton(viewButton, this));

    JButton button4 = new JButton(" xx Quit xx ");
    button4.addActionListener(new QuitButton());

    mainPanelOpt.add(button1);
    mainPanelOpt.add(button2);
    mainPanelOpt.add(button3);
    mainPanelOpt.add(button4);

    add(mainPanelTitle, BorderLayout.NORTH);
    add(mainPanelPic, BorderLayout.CENTER);
    add(mainPanelOpt, BorderLayout.SOUTH);
    this.setVisible(true);
  }
}
