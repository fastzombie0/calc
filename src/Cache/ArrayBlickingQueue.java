package Cache;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlickingQueue {
    private final Object obj = new Object();
    private final int maxSize;
    private final Object[] array;
    private int count = 0;
    private int size = 0;
    private int take = 0;


    public ArrayBlickingQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new Object[maxSize];

    }

    public void offer(int elt) {
        synchronized (obj) {
            try {
                if (size == array.length) {
                    obj.wait();
                }
                array[count] = elt;
                count++;
                size++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                obj.notifyAll();
            }
        }

    }

    public int take() {
        int result = 0;
        try {
            synchronized (obj) {
                if (size == 0) {
                    obj.wait();
                }
                result = (int) array[take];
                take = 0;
                size--;

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            obj.notifyAll();
        }
        return result;
    }
}
