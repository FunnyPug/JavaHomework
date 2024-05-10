package com.javaHomework.chapter5;

public class SimpleDotCom {
  int[] locationsCells;
  int numOFHits = 0;

  public void setLocationsCells(int[] loc) {
    locationsCells = loc;
  }

  public String checkYourself(String str) {
    int guess = Integer.parseInt(str);
    String result = "Мимо";
    for (int cell : locationsCells) {
      if (guess == cell) {
        result = "Попал";
        numOFHits++;
        break;
      }
    }
    if (numOFHits == locationsCells.length) {
      result = "Потопил";
    }
    System.out.println(result);
    return result;
  }
}
