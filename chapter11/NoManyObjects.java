package com.javaHomework.chapter11;

public class NoManyObjects {
  private static int countOfObjects;

  public NoManyObjects() throws MyEx {
    if (countOfObjects > 0) {
      System.out.println("Больше объектов создать нельзя!!!");
      throw new MyEx();
    }
    System.out.println("Создан объект № " + countOfObjects);
    countOfObjects++;
  }

  public static void main(String[] args) {
    try {
      NoManyObjects manyObjects = new NoManyObjects();
      manyObjects.someMethod();
      NoManyObjects objectsTwo = new NoManyObjects();
      objectsTwo.someMethod();
    } catch (MyEx ex) {
      ex.printStackTrace();
    }
    System.out.println("main работает дальше");
  }

  public void someMethod() {
    System.out.println("Lol");
  }
}
