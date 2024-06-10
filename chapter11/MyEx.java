package com.javaHomework.chapter11;

public class MyEx extends Exception {
  @Override
  public void printStackTrace() {
    System.out.println("Случилость что-то плохое!");
  }
}
