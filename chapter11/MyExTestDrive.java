package com.javaHomework.chapter11;

public class MyExTestDrive {
  public static void main(String[] args) {
    String str = "yes";

    try {
      System.out.print("t");
      doRisky(str);
    } catch (MyEx ex) {
      System.out.print("a");
    } finally {
      System.out.print("ws");
    }
  }

  static void doRisky(String a) throws MyEx {
    System.out.print("h");
    if (a.equals("yes")) {
      throw new MyEx();
    }
    System.out.print("ro");
  }
}
