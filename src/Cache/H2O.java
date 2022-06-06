package Cache;

import java.util.concurrent.atomic.AtomicInteger;

public class H2O {

    public static void main(String[] args) throws InterruptedException {
        H2O h2O = new H2O();
        Runnable t = () -> {
            try {
                h2O.hydrogen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(t, "").start();
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

    private final Object object = new Object();
    private AtomicInteger inct = new AtomicInteger(0);

    public void hydrogen() throws InterruptedException {
        synchronized (object) {
            for (inct.get(); inct.get() < 2; inct.incrementAndGet()) {
                    System.out.println("H");
            }
        }
    }

    public void oxygen() throws InterruptedException {
        synchronized (object) {
            if (inct.get() != 0) {
                inct.set(0);
                System.out.println("O");
            }

        }
    }
}
