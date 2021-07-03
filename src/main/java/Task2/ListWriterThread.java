package Task2;

import Task1.SumThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public class ListWriterThread extends Thread{

    private List<Integer> list;
    private static final Logger LOGGER = LoggerFactory.getLogger(SumThread.class);
    private Random random = new Random();

    public ListWriterThread(List<Integer> list) {
        this.list = list;
    }

    public void run() {
        while (true) {
            int value = random.nextInt(10);
            list.add(value);
            LOGGER.info("Writer has added new value {} to list", value);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
