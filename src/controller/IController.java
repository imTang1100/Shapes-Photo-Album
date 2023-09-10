package controller;

import java.io.IOException;

import model.IModel;


/**
 * The interface Controller.
 */
public interface IController {

  /**
   * Gets model.
   *
   * @return the model
   */
  IModel getModel();

  /**
   * Run.
   *
   * @throws IOException          the io exception
   * @throws InterruptedException the interrupted exception
   */
  void run() throws IOException, InterruptedException;
}
