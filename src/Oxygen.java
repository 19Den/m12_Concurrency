public class Oxygen implements Runnable {
    public static void releaseOxygen() {
        while (true) {
            Concurrency.lock.lock();
            try {
                while (Hydrogen.hydCount < 2) {
                    Concurrency.oxyWait.await();
                }
                Hydrogen.hydCount = 0;
                System.out.print("O, ");
                Concurrency.hydWait.signalAll();
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
        releaseOxygen();
    }
}
