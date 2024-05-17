package com.javaHomework.chapter6;

import com.javaHomework.chapter5.GameHelper;

import java.util.*;

public class DotComGame {
  private GameHelper helper = new GameHelper();
  private ArrayList<DotCom> dotComList = new ArrayList<>();
  private int numOfGuesses = 0;


  public static void main(String[] args) {
    DotComGame game = new DotComGame();
    game.setUpGame();
    game.startPlaying();
  }

  private void setUpGame() {
    DotCom one = new DotCom();
    one.setName("Pets.com");
    DotCom two = new DotCom();
    two.setName("eToys.com");
    DotCom three = new DotCom();
    three.setName("Go2.com");
    dotComList.add(one);
    dotComList.add(two);
    dotComList.add(three);


    System.out.println("Ваша цель - потопить три сайта.");
    System.out.println("Pets.com, eToys.com, Go2.com");
    System.out.println("Попытайтесь потопить из за минимальное количество ходов");

    for (DotCom dotComToSet : dotComList) {
      ArrayList<String> newLocation = helper.placeDotCom(3);
      dotComToSet.setLocationCells(newLocation);
    }
  }

  private void startPlaying() {
    while (!dotComList.isEmpty()) {
      String userGuess = helper.getUserInput("Сделайте ход");
      checkUserGuess(userGuess);
    }
    finishGame();
  }

  private void checkUserGuess(String userGuess) {
    numOfGuesses++;
    String result = "Мимо";

    for (DotCom dotComToTest : dotComList) {
      result = dotComToTest.checkYourSelf(userGuess);
      if (result.equals("Попал")) {
        break;
      }
      if (result.equals("Потопил")) {
        dotComList.remove(dotComToTest);
        break;
      }
      System.out.println(result);
    }
  }

  private void finishGame() {
    System.out.println("Все сайты ушли под воду!");
    if (numOfGuesses <= 18) {
      System.out.println("Это заняло у вас всего " + numOfGuesses + " попыток.");
      System.out.println("Вы молодец!!!!");
    } else {
      System.out.println("Это заняло у вас достаточно много времени и " + numOfGuesses + " попыток.");
    }
  }
}
