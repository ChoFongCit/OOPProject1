package pong;


import pong.model.Ball;
import pong.model.Player;

public class test {
    public static void main(String[] args){
        double startTime = System.currentTimeMillis();
    stackSizeExperiment(1);
    System.out.println("\nElapsed time: " + (System.currentTimeMillis() - startTime)/1000 );
    }
        public static void heapSizeExperiment() {
            double startTime = System.currentTimeMillis();
            int count = 0;
            try {
                long[][] is = new long[1000000][];
                while (true) {
                    is[count] = new long[10000];
                    count++;
                    System.out.printf("System created %d objects in %.2f secs, total memory: %d MB, Free memory: %d MB \n", count , (System.currentTimeMillis() - startTime) / 1000, Runtime.getRuntime().totalMemory()/(1024*1024), Runtime.getRuntime().freeMemory()/(1024*1024) );
                }
            } catch (Exception e) {
                long endTime = System.currentTimeMillis();
                double elapsedTimeSeconds = (endTime - startTime) / 1000;
                System.out.println("Objects created before OutOfMemoryError: " + count);
                System.out.println("Time to throw OutOfMemoryError: " + elapsedTimeSeconds + " seconds");
            }
        }
        public static void stackSizeExperiment(int count) {
            try {
                System.out.printf("System created %d stacks\n", count);
                stackSizeExperiment(count+1);

            } catch (StackOverflowError e) {
                System.out.printf("\nStackOverflowError occurred");
            }
        }
    }





