package abstractinterface;

/**
 * Created by Tim on 19.08.2016.
 */
public abstract class AbstractTV {
    private int volume;

    public int getVolume() {
        return volume;
    }

    public abstract void setVolume(int volume);
}
