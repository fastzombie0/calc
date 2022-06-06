package Cache;

import java.util.concurrent.atomic.AtomicInteger;

public class H3O {
    static H3O h2O = new H3O();
    public static void main(String[] args) throws InterruptedException {
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
    private volatile char aChar = 'H';

    public void hydrogen() throws InterruptedException {
        synchronized (object) {
            for (int i = 0; i < 2; i++) {
                System.out.println("H");
                aChar = 'O';
                while (aChar != 'H') {
                    object.wait();
                }
                object.notifyAll();
            }
        }
    }

    public void oxygen() throws InterruptedException {
        synchronized (object) {
            while (aChar != 'O') {
                object.wait();
            }
            System.out.println("O");
            aChar = 'H';
            object.notifyAll();
        }

    }
}

