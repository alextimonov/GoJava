package ua.goit.timonov.hometask_03.musicalinstruments;

public class Guitar extends MusicalInstrument {
    public static final String NAME_GUITAR = "guitar";

    private String name;

    @Override
    public void play() {
        System.out.print("Guitar plays...");
    }
}
