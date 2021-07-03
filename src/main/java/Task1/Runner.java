package Task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class Runner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        WriterThread writerThread = new WriterThread();
        writerThread.run();
    }

    private static class WriterThread implements Runnable {

        @Override
        public void run() {
            int counter = 0;
            SumThread sumThread = new SumThread();
            while (true) {
                counter++;
                map.put(counter,counter);
                sumThread.run();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class SumThread implements Runnable {

        @Override
        public void run() {
            for (Integer key : map.keySet()) {
                System.out.println("Map Value:" + map.get(key));
            }
        }
    }

}
