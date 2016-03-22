package ua.goit.timonov.hometask_03.musicalinstruments;

public class Piano extends MusicalInstrument {
    public Piano() {
        instrumentType = "piano";
    }

    @Override
    public void play() {
        System.out.print("Piano plays...");
    }
}
