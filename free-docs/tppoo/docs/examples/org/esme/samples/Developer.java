package org.esme.samples;

public class Developer {
  /**
   * Call this when a developer is working...
   * @throws ProjectException, issues related to 
   *  management of the project is not the 
   *  responsability of the developer. */
  public void doingAProject() throws ProjectException {
   try {
     this.code();
   }
   catch ( TechnicalException e ) { //
     // Taking care of technical isssues is
     // of the developer responsability.
     this.doingSomethingAppropriate(e);
   }
  }



  private void doingSomethingAppropriate(TechnicalException e) {}
  private void code() throws TechnicalException, ProjectException {}
}
