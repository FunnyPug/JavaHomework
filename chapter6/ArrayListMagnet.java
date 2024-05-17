package com.javaHomework.chapter6;

import java.util.*;

public class ArrayListMagnet {
  public static void main(String[] args) {
    ArrayList<String> a = new ArrayList<>();
    a.add(0, "Ноль");
    a.add(1, "Один");
    a.add(2, "Два");
    a.add(3, "Три");
    printAl(a);
    a.remove(2);
    if (a.contains("Два")) {
      a.add("2.2");
    }
    if (a.contains("Три")) {
      a.add("Четыре");
    }
    printAl(a);
    if (a.indexOf("четыре") != 4) {
      a.add(4, "4.2");
    }
    printAl(a);
    printAl(a);
  }

  public static void printAl(ArrayList<String> al) {
    for (String str : al) {
      System.out.print(str + " ");
    }
    System.out.println();
  }
}
