package com.javaHomework.chapter5;

public class SimpleDotCom {
  int[] locationsCells;
  int[] strikeCells;
  int numOFHits;
  String result;

  public void setLocationsCells(int[] loc) {
    locationsCells = loc;
    prepareStrikeCells(loc);
  }

  public void prepareStrikeCells(int[] validateCells) {
    strikeCells = new int[validateCells.length];
    for (int x = 0; x < strikeCells.length; x++) {
      strikeCells[x] = -1;
    }
  }

  public String checkYourself(String str) {
    int guess = Integer.parseInt(str);
    result = "Мимо";
    if (!checkStrikeCells(guess)) {
      for (int x = 0; x < locationsCells.length; x++) {
        if (guess == locationsCells[x]) {
          result = "Попал";
          numOFHits++;
          strikeCells[x] = guess;
          break;
        }
      }
    }
    if (numOFHits == locationsCells.length) {
      result = "Потопил";
    }
    System.out.println(result);
    return result;
  }

  public boolean checkStrikeCells(int shot) {
    boolean isStrike = false;
    for (int strikeCell : strikeCells) {
      if (shot == strikeCell) {
        result = "Ячейка с номером " + shot + " поражена, попробуйте другую";
        isStrike = true;
        break;
      }
    }
    return isStrike;
  }
}
