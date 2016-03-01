package ua.goit.timonov.hometask_03.musicalInstuments;

public class MusicalInstrumentRunner {
    public static void main(String[] args) {
        MusicShop musicShop = new MusicShop();
        musicShop.addInstrument(new Tube());
        musicShop.addInstrument(new Piano());
        musicShop.addInstrument(new Guitar());
        MusicalInstrument instrument = new Tube();
        musicShop.addInstrument(instrument);
        musicShop.tryToPlay();
    }
}
