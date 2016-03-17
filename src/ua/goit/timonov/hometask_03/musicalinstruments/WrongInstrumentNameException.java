package ua.goit.timonov.hometask_03.musicalinstruments;

/**
 * Created by Alex on 16.03.2016.
 */
public class WrongInstrumentNameException extends Exception {
    private String message;

    public WrongInstrumentNameException(String message) {
        this.message = message;
    }
}
