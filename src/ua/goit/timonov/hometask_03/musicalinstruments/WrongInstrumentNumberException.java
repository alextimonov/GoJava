package ua.goit.timonov.hometask_03.musicalinstruments;

/**
 * Created by Alex on 16.03.2016.
 */
public class WrongInstrumentNumberException extends Exception {
    private String message;

    public WrongInstrumentNumberException(String message) {
        this.message = message;
    }
}
