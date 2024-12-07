package task01;
import java.util.concurrent.atomic.AtomicInteger;

public class Lucky
{
    static AtomicInteger x = new AtomicInteger(0);
    static AtomicInteger count = new AtomicInteger(0);

    static class LuckyThread extends Thread {
        @Override
        public void run()
        {
            while (true)
            {
                int currentX = x.getAndIncrement();
                if (currentX >= 999999) {
                    break;
                }

                if ((currentX % 10) + (currentX / 10) % 10 + (currentX / 100) % 10 == (currentX / 1000)
                        % 10 + (currentX / 10000) % 10 + (currentX / 100000) % 10) {
                    System.out.println(currentX);
                    count.incrementAndGet();
                }
            }
        }
    }
}