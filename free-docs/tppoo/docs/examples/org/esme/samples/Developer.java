package org.esme.samples;

public class Developer {
  /**
   * When the developer is working on a project, this method is called.
   * @throws ProjectException is thrown if the all project is encountering
   *       some great difficulties.
   */
  public void doingAProject() throws ProjectException {
    try {
      // During a projet, a developer is supposed to code !
      this.code();
    }
    catch ( TechnicalException e ) { //
      // Taking care of technical difficulties is
      // the developer's job:
      this.doingSomethingAppropriate(e);
    }
  }



  private void doingSomethingAppropriate(TechnicalException e) {}
  private void code() throws TechnicalException, ProjectException {}
}
