package com.javaHomework.chapter12;
import javax.swing.*;
import java.awt.event.*;

public class SimpleGuiWithButton implements ActionListener {
  JButton button;
  boolean clickedOrNo;

  public static void main(String[] args) {
    SimpleGuiWithButton simpleGui = new SimpleGuiWithButton();
    simpleGui.go();
  }

  public void go() {
    JFrame frame = new JFrame();
    button = new JButton("Click me!");
    button.addActionListener(this);
    frame.getContentPane().add(button);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (!clickedOrNo) {
      button.setText("I'm clicked!");
      clickedOrNo = true;
    } else {
      button.setText("Click!!!");
      clickedOrNo = false;
    }
  }
}
