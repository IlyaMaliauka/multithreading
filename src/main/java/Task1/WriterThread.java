package Task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.ConcurrentMap;

public class WriterThread extends Thread {

    private static final Logger LOGGER = LoggerFactory.getLogger(WriterThread.class);
    private final ConcurrentMap<Integer, Integer> map;
    private final Random random = new Random();
    private final String name;

    public WriterThread(ConcurrentMap<Integer, Integer> map,
                        String threadName) {
        this.map = map;
        this.name = threadName;
    }

    public void run() {
        while (true) {
            int key = random.nextInt(10);
            int value = random.nextInt(10);
            if (map.putIfAbsent(key, value) == null) {
                LOGGER.info("{} has put [{} => {}]",
                        name, key, value);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}