package paradigm;

public class TestApp {
    public static void main(String[] args) {
        ColorTV colorTV = new ColorTV();
        colorTV.setChannel(2);

//        ControlableFromDistance tv2 = new ColorTV();
//        tv2.set

        TV tv = new ColorTV();
        tv.getChannel();

        if (tv instanceof ControlableFromDistance) {
            //erfrferff
        }

        Object tv1 = new ColorTV();
        tv1.getClass();

        //===================================
        TV tele = new ColorTV();
        tele.printColorScheme();

    }
}
