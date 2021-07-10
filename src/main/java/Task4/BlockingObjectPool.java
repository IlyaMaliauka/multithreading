package Task4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Pool that block when it has not any items or it full
 */
public abstract class BlockingObjectPool<T> {

    private final BlockingQueue<T> pool;
    private final ReentrantLock lock = new ReentrantLock();
    private int createdObjects = 0;
    private final int size;
    /**
     * Creates filled pool of passed size * * @param size of pool
     */
    public BlockingObjectPool(int size) {
        this(size, false);
    }

    public BlockingObjectPool(int size, Boolean dynamicCreation) {
        pool = new ArrayBlockingQueue<>(size, true);
        this.size = size;
        if (!dynamicCreation) {
            lock.lock();
        }
    }

    /**
     * Gets object from pool or blocks if pool is empty * * @return object from pool
     */
    public T get() throws InterruptedException {
        if (!lock.isLocked()) {
            if (lock.tryLock()) {
                try {
                    ++createdObjects;
                    return createObject();
                } finally {
                    if (createdObjects < size) lock.unlock();
                }
            }
        }
        return pool.take();
    }

    /**
     * Puts object to pool or blocks if pool is full * * @param object to be taken back to pool
     */
    public void take(T t) {
        pool.add(t);
    }

    public void createPool() {
        if (lock.isLocked()) {
            for (int i = 0; i < size; ++i) {
                pool.add(createObject());
                createdObjects++;
            }
        }
    }

    protected abstract T createObject();
}