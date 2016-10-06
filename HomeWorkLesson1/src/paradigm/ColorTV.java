package paradigm;

/**
 * Created by Tim on 04.10.2016.
 */
public class ColorTV extends TV implements ControlableFromDistance {
    @Override
    public String getName() {
        return "Color TV";
    }

    @Override
    public void setChannelFromDistance(int channel) {
        //do something
    }

    public void printColorScheme() {
        System.out.println("Color scheme");
    }
}
