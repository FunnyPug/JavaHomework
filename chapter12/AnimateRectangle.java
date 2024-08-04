package com.javaHomework.chapter12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimateRectangle {
  int x = 1;
  int y = 1;
  JFrame frame;
  JButton startButton;
  MyDrawP drawP;

  public static void main(String[] args) {
    AnimateRectangle rectangle = new AnimateRectangle();
    rectangle.prepareGame();
  }

  public void prepareGame() {
    frame = new JFrame();
    drawP = new MyDrawP();
    startButton = new JButton("Start!!!");
    startButton.addActionListener(new MyButton());
    frame.getContentPane().add(drawP);
    frame.getContentPane().add(BorderLayout.SOUTH, startButton);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(501, 350);
    frame.setVisible(true);
  }

  public void go() {
    for (int i = 0; i < 124; i++, x++, y++) {
      x++;
      drawP.repaint();
      try {
        Thread.sleep(70);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  class MyDrawP extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, 501,350);
      g.setColor(Color.RED);
      g.fillRect(x, y, 500 - x * 2, 250 - y * 2);
    }
  }

  class MyButton implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      go();
    }
  }
}