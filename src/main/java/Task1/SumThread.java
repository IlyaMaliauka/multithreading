package Task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class SumThread extends Thread {

    private static final Logger LOGGER = LoggerFactory.getLogger(SumThread.class);
    private final ConcurrentHashMap<Integer, Integer> map;

    public SumThread(ConcurrentHashMap<Integer, Integer> map) {
        this.map = map;
    }

    public void run() {
        while (true) {
            ConcurrentHashMap.KeySetView<Integer, Integer> keySetView = map.keySet();
            Iterator<Integer> iterator = keySetView.iterator();
            int sum = 0;
            while (iterator.hasNext()) {
                Integer key = iterator.next();
                sum += map.get(key);
            }
            LOGGER.info("Sum of all values in collection {}", sum);
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}