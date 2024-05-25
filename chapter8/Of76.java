package com.javaHomework.chapter8;

public class Of76 extends Clowns {
  public static void main(String[] args) {
    Nose[] i = new Nose[3];
    i[0] = new Acts();
    i[1] = new Clowns();
    i[2] = new Of76();

    for (Nose n : i) {
      System.out.println(n.iMethod() + " " + n.getClass());
    }
  }
}
