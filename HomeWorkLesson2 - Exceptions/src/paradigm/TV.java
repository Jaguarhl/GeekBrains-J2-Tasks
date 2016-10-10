package paradigm;

public abstract class TV {
    public static final int DEFAULT_CHANNEL = 0;
    private int channel;

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public abstract String getName();

    public void printColorScheme() {
        System.out.println("Abstract scheme");
    }
}
