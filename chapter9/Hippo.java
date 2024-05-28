package com.javaHomework.chapter9;

public class Hippo extends Animals {
  public static void main(String[] args) {
    Hippo hippoOne = new Hippo();
    hippoOne.setName("Конь");
    System.out.println(hippoOne.getName());

    Hippo hippoTwo = new Hippo("Пес");
    System.out.println(hippoTwo.getName());

  }

  public Hippo() {
    System.out.println("wow wow");
  }

  public Hippo(String name) {
    setName(name);
  }
}
