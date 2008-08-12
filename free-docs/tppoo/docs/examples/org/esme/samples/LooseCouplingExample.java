package org.esme.samples;

public class LooseCouplingExample {
   public void usingMyFileOrUser(){
      LooseCoupling obj;
      obj = new LooseCoupling(new MyFile());
      LooseCoupling other;
      other = new LooseCoupling(new User());
   }
}
