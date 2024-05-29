package com.javaHomework.chapter10;

import java.util.*;
import static java.lang.System.out;

public class FullMoons {
  private static final int DAY_IM = 1000 * 60 * 60 * 24;

  public static void main(String[] args) {
    Calendar c = Calendar.getInstance();
    c.set(2004, 0, 7, 15, 40);
    long day1 = c.getTimeInMillis();
    for (int x = 0; x < 15; x++) {
      day1 += (DAY_IM * 29.52);
      c.setTimeInMillis(day1);
      out.printf("Последнее полнолуние было в %tc %n", c);
    }
  }
}
