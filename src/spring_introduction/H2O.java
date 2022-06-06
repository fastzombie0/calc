package spring_introduction;

import java.util.concurrent.Semaphore;

public class H2O {
    Semaphore h = new Semaphore(2);
    Semaphore o = new Semaphore(2);

    public void hydrogen() throws InterruptedException {
        h.acquire(1);
        System.out.println("H");
        o.release(1);
    }

    public void oxygen() throws InterruptedException {
        o.acquire(2);
        System.out.println("O");
        h.release(2);
    }

    public static void main(String[] args) throws InterruptedException {
        H2O h2O = new H2O();
        new Thread(() -> {
            try {
                h2O.hydrogen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                h2O.oxygen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
