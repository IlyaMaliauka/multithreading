package Task1;
import java.util.concurrent.ConcurrentHashMap;


public class Runner {

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

        new WriterThread(map, "Writer").start();
        new SumThread(map).start();
    }

}
