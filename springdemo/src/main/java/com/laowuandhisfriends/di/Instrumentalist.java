package com.laowuandhisfriends.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("kenny")
public class Instrumentalist implements Performer {
    public Instrumentalist() {
    }

    @Override
    public void perform() throws PerformanceException {
        System.out.println("Playing " + song + " : ");
        instrument.play();
    }

    private String song;

    public String getSong() {
        return song;
    }

    @Value("Jingle Bells")
    public void setSong(String song) {
        this.song = song;
    }

    private Instrument instrument;

    public Instrument getInstrument() {
        return instrument;
    }

    @Autowired
    @Qualifier("saxophone")
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}
