package abstractinterface;

/**
 * Created by Tim on 19.08.2016.
 */
public class TV extends AbstractTV implements Teletextable {
    private int chanel;

    public int getChanel() {
        return this.chanel;
    }

    @Override
    public void setVolume(int volume) {
        //vdfvdvdfvvv
    }

    @Override
    public void showTeletext() {
        //gffgbfbfgbffb
    }
}
