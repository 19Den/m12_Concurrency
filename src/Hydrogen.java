public class Hydrogen implements Runnable {
    static volatile int hydCount = 0;
    public static void releaseHydrogen() {
        while (true) {
            Concurrency.lock.lock();
            try {
                while (hydCount == 2) {
                    Concurrency.hydWait.await();
                }
                hydCount++;
                System.out.print("H");
                if (hydCount == 2) {
                    Concurrency.oxyWait.signalAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Concurrency.lock.unlock();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        releaseHydrogen();
    }
}
