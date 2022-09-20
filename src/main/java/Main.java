public class Main {

    public static void main(String[] args) {

        Box box = new Box();
        User user = new User(box);
        user.start();
        box.start();
        try {
            user.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        box.interrupt();
    }
}
