package ua.goit.timonov.hometask_03.musicalinstruments;

public class MusicalInstrument {
    protected String instrumentType;

    public void play() {
    }

    public String getType() {
        return instrumentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MusicalInstrument that = (MusicalInstrument) o;
        return instrumentType.equals(that.instrumentType);
    }

    @Override
    public int hashCode() {
        return instrumentType.hashCode();
    }
}