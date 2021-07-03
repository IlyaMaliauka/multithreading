package Task2;

import Task1.SumThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ListSquareThread extends Thread {

    private List<Integer> list;
    private static final Logger LOGGER = LoggerFactory.getLogger(SumThread.class);

    public ListSquareThread(List<Integer> list) {
        this.list = list;
    }

    public void run() {
        while (true) {
            synchronized (list) {
                int sum = 0;
                for (Integer value : list) {
                    sum += value * value;
                }
                double result = Math.sqrt(sum);
                LOGGER.info("Square root of sum of all numbers squares in collection {}", result);
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
