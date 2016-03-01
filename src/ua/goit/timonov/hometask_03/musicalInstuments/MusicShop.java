package ua.goit.timonov.hometask_03.musicalInstuments;

import java.util.ArrayList;
import java.util.List;

public class MusicShop {
    private List<MusicalInstrument> instruments;

    public MusicShop() {
        instruments = new ArrayList<>();
    }

    public void addInstrument(MusicalInstrument instrument) {
        instruments.add(instrument);
    }

    public void tryToPlay() {
        for (MusicalInstrument instrument : instruments) {
            instrument.play();
        }
    }
}
