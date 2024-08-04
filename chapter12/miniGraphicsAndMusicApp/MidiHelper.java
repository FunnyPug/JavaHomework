package com.javaHomework.chapter12.miniGraphicsAndMusicApp;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class MidiHelper {
  public static MidiEvent makeEvent (int comd, int chan, int one, int two, int tick) {
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
}
