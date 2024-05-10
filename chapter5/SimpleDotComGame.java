package com.javaHomework.chapter5;

public class SimpleDotComGame {
  public static void main(String[] args) {
    int numOfHits = 0;
    GameHelper helper = new GameHelper();
    SimpleDotCom dotCom = new SimpleDotCom();
    int randomNum = (int) (Math.random() * 5);
    int[] locationCells = {randomNum, randomNum + 1, randomNum + 2};
    dotCom.setLocationsCells(locationCells);
    boolean isAlive = true;

    while (isAlive) {
      String guess = helper.getUserInput("Введите число ");
      String result = dotCom.checkYourself(guess);
      numOfHits++;
      if (result.equals("Потопил")) {
        isAlive = false;
        System.out.println("Вам потребовалось " + numOfHits + " попыток(и)");
      }
    }
  }
}
