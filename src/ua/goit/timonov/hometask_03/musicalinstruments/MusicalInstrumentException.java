package ua.goit.timonov.hometask_03.musicalinstruments;

public class MusicalInstrumentException extends Exception {
    private String message;

    public MusicalInstrumentException(String message) {
        this.message = message;
    }
}