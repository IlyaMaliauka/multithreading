package Task2;

import Task1.SumThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class ListSummerThread extends Thread{

    private List<Integer> list;
    private static final Logger LOGGER = LoggerFactory.getLogger(SumThread.class);

    public ListSummerThread(List<Integer> list) {
        this.list = list;
    }

    public void run() {
        while (true) {
            synchronized (list) {
                int sum = 0;
                for (Integer value : list) {
                    sum += value;
                }
                LOGGER.info("Sum of all values in collection {}", sum);
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
