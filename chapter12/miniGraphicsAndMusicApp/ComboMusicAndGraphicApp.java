package com.javaHomework.chapter12.miniGraphicsAndMusicApp;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class ComboMusicAndGraphicApp {
  JFrame frame;
  MyInnerRectangle rectangle;

  public static void main(String[] args) {
    ComboMusicAndGraphicApp miniApp = new ComboMusicAndGraphicApp();
    miniApp.go();
  }

  public void go() {
    try {
      frame = new JFrame("My first graphics app");
      rectangle = new MyInnerRectangle();
      frame.setContentPane(rectangle);
      frame.setBounds(30, 30, 300, 300);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

      Sequencer sequencer = MidiSystem.getSequencer();
      sequencer.open();
      int[] eventsIWant = {127};
      sequencer.addControllerEventListener(rectangle, eventsIWant);
      Sequence seq = new Sequence(Sequence.PPQ, 4);
      Track track = seq.createTrack();

      for (int i = 5; i < 61; i += 4) {
        int r = (int) ((Math.random() * 50) + 1);
        track.add(MidiHelper.makeEvent(144, 1, r, 100, i));
        track.add(MidiHelper.makeEvent(176, 1, 127, 0, i));
        track.add(MidiHelper.makeEvent(128, 1, r, 100, i));
      }
      sequencer.setSequence(seq);
      sequencer.setTempoInBPM(120);
      sequencer.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static class MyInnerRectangle extends JPanel implements ControllerEventListener {
    @Override
    protected void paintComponent(Graphics g) {
      Graphics2D graphics = (Graphics2D) g;
      int r = (int) (Math.random() * 251);
      int gr = (int) (Math.random() * 251);
      int b = (int) (Math.random() * 251);
      graphics.setColor(new Color(r, gr, b));

      int height = (int) ((Math.random() * 120) + 10);
      int width = (int) ((Math.random() * 120) + 10);
      int x = (int) ((Math.random() * 40) + 10);
      int y = (int) ((Math.random() * 40) + 10);

      graphics.fillRect(x, y, width, height);
    }

    @Override
    public void controlChange(ShortMessage event) {
      repaint();
    }
  }
}
