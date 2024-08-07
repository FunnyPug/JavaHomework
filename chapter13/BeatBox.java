package com.javaHomework.chapter13;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BeatBox {
  JPanel mainPanel;
  ArrayList<JCheckBox> checkBoxList;
  Sequencer sequencer;
  Sequence sequence;
  Track track;
  JFrame frame;
  String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare",
          "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
          "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};
  int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

  public static void main(String[] args) {
    BeatBox beatBox = new BeatBox();
    beatBox.buildGUI();
  }

  public void buildGUI() {
    frame = new JFrame("Cyber BeatBox");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    BorderLayout layout = new BorderLayout();
    JPanel background = new JPanel(layout);
    background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    checkBoxList = new ArrayList<>();
    Box buttonBox = new Box(BoxLayout.Y_AXIS);

    JButton start = new JButton("Start");
    start.addActionListener(new MyStartListener());
    buttonBox.add(start);

    JButton stop = new JButton("Stop");
    stop.addActionListener(new MyStoptListener());
    buttonBox.add(stop);

    JButton upTempo = new JButton("Tempo Up");
    upTempo.addActionListener(new MyUpTempoListener());
    buttonBox.add(upTempo);

    JButton downTempo = new JButton("Tempo Down");
    downTempo.addActionListener(new MyDownTempoListener());
    buttonBox.add(downTempo);

    JButton clear = new JButton("Clear Boxes");
    clear.addActionListener(new MyClearListener());
    buttonBox.add(clear);

    Box nameBox = new Box(BoxLayout.Y_AXIS);
    for (String instrumentName : instrumentNames) {
      nameBox.add(new Label(instrumentName));
    }

    background.add(BorderLayout.EAST, buttonBox);
    background.add(BorderLayout.WEST, nameBox);

    frame.getContentPane().add(background);

    GridLayout gridLayout = new GridLayout(16, 16);
    gridLayout.setVgap(1);
    gridLayout.setHgap(2);

    mainPanel = new JPanel(gridLayout);
    background.add(BorderLayout.CENTER, mainPanel);

    for (int i = 0; i < 256; i++) {
      JCheckBox checkBox = new JCheckBox();
      checkBox.setSelected(false);
      checkBoxList.add(checkBox);
      mainPanel.add(checkBox);
    }

    setUpMidi();
    frame.setBounds(50, 50, 300, 300);
    frame.pack();
    frame.setVisible(true);
  }

  public void clearCheckBoxes() {
    for (JCheckBox checkBox : checkBoxList) {
      checkBox.setSelected(false);

    }
  }

  public void setUpMidi() {
    try {
      sequencer = MidiSystem.getSequencer();
      sequencer.open();
      sequence = new Sequence(Sequence.PPQ, 4);
      track = sequence.createTrack();
      sequencer.setTempoInBPM(120);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void buildTrackAndStart() {
    int[] trackList = null;
    sequence.deleteTrack(track);
    track = sequence.createTrack();
    for (int i = 0; i < 16; i++) {
      trackList = new int[16];
      int key = instruments[i];

      for (int j = 0; j < 16; j++) {
        JCheckBox jc = checkBoxList.get(j + (16 * i));
        if (jc.isSelected()) {
          trackList[j] = key;
        } else {
          trackList[j] = 0;
        }
      }
      makeTracks(trackList);
      track.add(makeEvent(176, 1, 127, 0, 16));
    }

    track.add(makeEvent(192, 9, 1, 0, 15));
    try {
      sequencer.setSequence(sequence);
      sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
      sequencer.start();
      sequencer.setTempoInBPM(120);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void makeTracks(int[] list) {
    for (int i = 0; i < 16; i++) {
      int key = list[i];
      if (key != 0) {
        track.add(makeEvent(144, 9, key, 100, i));
        track.add(makeEvent(128, 9, key, 100, i + 1));
      }
    }
  }

  public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
    MidiEvent event = null;
    try {
      ShortMessage message = new ShortMessage();
      message.setMessage(comd, chan, one, two);
      event = new MidiEvent(message, tick);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return event;
  }


  private class MyStartListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      buildTrackAndStart();
    }
  }

  private class MyStoptListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      sequencer.stop();
    }
  }

  private class MyUpTempoListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      float tempoFactor = sequencer.getTempoFactor();
      sequencer.setTempoFactor((float) (tempoFactor * 1.03));
    }
  }

  private class MyDownTempoListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      float tempoFactor = sequencer.getTempoFactor();
      sequencer.setTempoFactor((float) (tempoFactor * .97));
    }
  }

  private class MyClearListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      clearCheckBoxes();
    }
  }
}