package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pause {
    private static int nveces = 0;
    
    public static void main(String[] args) {
        MiHilo a, b, c, d;
        a = new MiHilo('a');
        b = new MiHilo('b');
        c = new MiHilo('c');
        d = new MiHilo('d');

        Thread at = new Thread(a);
        Thread bt = new Thread(b);
        Thread ct = new Thread(c);
        Thread dt = new Thread(d);

        ExecutorService exec = Executors.newCachedThreadPool();
        ExecutorService exc = Executors.newFixedThreadPool(4);
        ExecutorService ec = Executors.newSingleThreadExecutor();

        exec.execute(a);
        exec.execute(b);
        exec.execute(c);
        exec.execute(d);
        exec.shutdown();

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println("\n"+nveces);
    }

    private static class MiHilo implements Runnable {
        private char c;

        public MiHilo(char carac) {
            c = carac;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                int x = nveces;
                System.out.print(c);
                try {
                    Thread.sleep((long)(Math.random()*50));
                } catch (InterruptedException ex) { System.out.println(ex); }
                nveces = x + 1;
            }
        }
    }
}
