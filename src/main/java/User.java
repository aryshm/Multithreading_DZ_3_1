public class User extends Thread{

    private final static int SWITCH_ON_NMBS = 5;
    private final static int WAITING_TIME = 3000;
    private final Box box;

    public User(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 0; i < SWITCH_ON_NMBS; i++) {
            try {
                Thread.sleep(WAITING_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!box.isVolatileCurrentPosition()) {
                box.setVolatileCurrentPosition(true);
                System.out.println("Switch on");
            }
        }
    }
}
