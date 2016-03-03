package ua.goit.timonov.hometask_03.musical_instruments;

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
