package com.javaHomework.chapter11;
import com.javaHomework.chapter5.GameHelper;
import javax.sound.midi.*;

public class MiniMusicApp {

  public static void main(String[] args) {
    MiniMusicApp miniMusicApp = new MiniMusicApp();
    GameHelper helper = new GameHelper();
    System.out.println("Номер ноты и интструмента начинаются от 1 до 192");
    int firstValue = Integer.parseInt(helper.getUserInput("Введите номер инструмента"));
    int secondValue = Integer.parseInt(helper.getUserInput("Введите номер ноты"));
    miniMusicApp.play(firstValue, secondValue);
  }

  public void play(int instrument, int note) {
    try {
      Sequencer player = MidiSystem.getSequencer();
      player.open();

      Sequence seq = new Sequence(Sequence.PPQ, 4);
      Track track = seq.createTrack();

      ShortMessage first = new ShortMessage();
      first.setMessage(192, 1, instrument, 100);
      MidiEvent changeInstrument = new MidiEvent(first, 1);
      track.add(changeInstrument);

      ShortMessage a = new ShortMessage();
      a.setMessage(144, 1, note, 100);
      MidiEvent noteOn = new MidiEvent(a, 1);
      track.add(noteOn);

      ShortMessage b = new ShortMessage();
      b.setMessage(128, 1, note, 100);
      MidiEvent noteOff = new MidiEvent(b, 16);
      track.add(noteOff);

      player.setSequence(seq);
      player.start();
      Thread.sleep(2000);
      player.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
