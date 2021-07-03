package Task2;

import java.util.ArrayList;
import java.util.List;

public class Runner {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        new ListWriterThread(list).start();
        new ListSummerThread(list).start();
        new ListSquareThread(list).start();
    }
}
