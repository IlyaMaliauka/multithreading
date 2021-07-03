package Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        WritingThread writingThread = new WritingThread();
        writingThread.run();
    }

    private static class WritingThread implements Runnable {

        @Override
        public void run() {
            Random random = new Random(500);
            SumThread sumThread = new SumThread();
            SquareThread squareThread = new SquareThread();
            while (true) {
                int valueToAdd = random.nextInt(100);
                list.add(valueToAdd);
                System.out.println("Added new value to list: " + valueToAdd);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sumThread.run();
                squareThread.run();
            }
        }
    }

    private static class SumThread implements Runnable {

        @Override
        public void run() {
            int sum = list.stream().reduce(0, Integer::sum);
            System.out.println("Sum of all elements in collections: " + sum);
        }
    }

    private static class SquareThread implements Runnable {

        @Override
        public void run() {
            int sum = 0;
            for (Integer value : list) {
                sum += value * value;
            }
            double result = Math.sqrt(sum);
            System.out.println("Square root of sum of all numbers in collection: " + result);
        }
    }
}
