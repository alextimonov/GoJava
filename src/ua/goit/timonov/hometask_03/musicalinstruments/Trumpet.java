package ua.goit.timonov.hometask_03.musicalinstruments;

public class Trumpet extends MusicalInstrument {
    public Trumpet() {
        instrumentType = "trumpet";
    }

    @Override
    public void play() {
        System.out.print("Trumpet plays...");
    }
}
