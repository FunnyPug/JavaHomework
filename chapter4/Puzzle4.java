package com.javaHomework.chapter4;

public class Puzzle4 {
  public static void main(String[] args) {
    int y = 1;
    int x = 0;
    int result = 0;
    Puzzle4b[] obs = new Puzzle4b[6];
    while (x < 6) {
      obs[x] = new Puzzle4b();
      obs[x].ivar = y;
      y *= 10;
      x++;
    }
    x = 6;
    while (x > 0) {
      x--;
      result += obs[x].doStuff(x);
    }
    System.out.println("Результат " + result);
  }
}
