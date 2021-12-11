import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Concurrency {
    final static Lock lock = new ReentrantLock(true);
    final static Condition oxyWait = lock.newCondition();
    final static Condition hydWait = lock.newCondition();


    public static void main(String[] args) {
            Runnable hydrogen1 = new Hydrogen();
            Runnable hydrogen2 = new Hydrogen();
            Runnable oxygen = new Oxygen();
            Thread threadH_1 = new Thread(hydrogen1);
            Thread threadH_2 = new Thread(hydrogen2);
            Thread threadO_3 = new Thread(oxygen);
            threadH_1.start();
            threadH_2.start();
            threadO_3.start();
    }
}
