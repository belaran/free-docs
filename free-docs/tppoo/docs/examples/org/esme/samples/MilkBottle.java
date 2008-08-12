package org.esme.samples;

public class MilkBottle {
   float quantity;   // represents the amount
         // of milk in the bottle.

   public void add(MilkBottle otherBottle) {
      this.quantity += otherBottle.quantity;
   }
}
