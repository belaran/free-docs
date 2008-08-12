package org.esme.samples;

public class LooseCoupling {
// This class can use ANY object implementing
// the Checksumable interface...
   private Checksumable field;

   public LooseCoupling(Checksumable field) {
      this.field = field;
   }
}
