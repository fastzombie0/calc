package Cache;

import java.util.Arrays;
import java.util.function.Predicate;

public class CacheImpl implements Cache {
    private volatile long[] cache = new long[10];

    @Override
    public synchronized void bulkUpdate(Updater updater) {
        long[] newCache = new long[cache.length];
        Arrays.copyOf()
        System.arraycopy(cache, 0, cache.length, newCache,  newCache.length);
        updater.updateCurrentState(newCache);

        cache = newCache;

    }

    @Override
    public long[] bulkRead(int[] indices) {
        long[] result = new long[indices.length];
        long[] tempCache = cache;
        for (int i = 0; i < result.length; i++) {
            result[i] = tempCache[indices[i]];
        }

        return result;
    }

    public static void main(String[] args) {
        CacheImpl cache = new CacheImpl();

        cache.bulkUpdate(arr -> {
            arr[0] = 123;
            arr[1] = 456;
        });

        long[] cacheValues = cache.bulkRead(new int[]{1, 2});

        System.out.println(Arrays.toString(cacheValues));


    }}
