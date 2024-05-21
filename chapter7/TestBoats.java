package com.javaHomework.chapter7;

public class TestBoats {
  public static void main(String[] args) {
    Boat b1 = new Boat();
    Sailboat b2 = new Sailboat();
    Rowboat b3 = new Rowboat();
    b2.setLength(22);
    b1.movie();
    b3.movie();
    b2.movie();
  }
}
