public class Box extends Thread {

    private volatile static boolean volatileCurrentPosition = false;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (volatileCurrentPosition) {
                volatileCurrentPosition = false;
                System.out.println("Switch off");
            }
        }
    }

    public static boolean isVolatileCurrentPosition() {
        return volatileCurrentPosition;
    }

    public static void setVolatileCurrentPosition(boolean volatileCurrentPosition) {
        Box.volatileCurrentPosition = volatileCurrentPosition;
    }
}
