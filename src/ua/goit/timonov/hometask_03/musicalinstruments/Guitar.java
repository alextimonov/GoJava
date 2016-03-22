package ua.goit.timonov.hometask_03.musicalinstruments;

public class Guitar extends MusicalInstrument {
    public Guitar() {
        instrumentType = "guitar";
    }

    @Override
    public void play() {
        System.out.print("Guitar plays...");
    }
}
