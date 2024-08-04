package com.javaHomework.chapter12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiWithButtons {
  JFrame frame;
  JLabel label;
  JButton buttonFromLabel;
  JButton buttonFromCircle;
  boolean labelCondition;
  int xPosition;
  int yPosition;

  public static void main(String[] args) {
    GuiWithButtons miniGui = new GuiWithButtons();
    miniGui.go();
  }

  public void go() {
    frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    label = new JLabel("I'm label");
    buttonFromLabel = new JButton("Change label");
    buttonFromLabel.addActionListener(new InnerLabelListener());

    InnerDrawingPanel panel = new InnerDrawingPanel();
    buttonFromCircle = new JButton("Change circle color");
    buttonFromCircle.addActionListener(new InnerCircleListener());

    frame.getContentPane().add(BorderLayout.CENTER, panel);
    frame.getContentPane().add(BorderLayout.SOUTH, buttonFromCircle);
    frame.getContentPane().add(BorderLayout.WEST, label);
    frame.getContentPane().add(BorderLayout.EAST, buttonFromLabel);
    frame.setSize(600, 600);
    frame.setVisible(true);
  }

  private class InnerLabelListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (!labelCondition) {
        label.setText("I'm changed!!!");
        labelCondition = true;
      } else {
        label.setText("CLick me!");
        labelCondition = false;
      }
    }
  }

  class InnerCircleListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      frame.repaint();
      xPosition++;
      yPosition++;
    }
  }

  class InnerDrawingPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
      int red = (int) (Math.random() * 255);
      int green = (int) (Math.random() * 255);
      int blue = (int) (Math.random() * 255);

      Color randColor = new Color(red, green, blue);
      g.setColor(randColor);
      g.fillOval(xPosition, yPosition, 100, 100);
    }
  }
}
