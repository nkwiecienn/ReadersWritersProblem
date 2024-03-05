package readers_writers_problem;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class Reader extends Thread {
    private final int number;
    private final Library library;
    Random random = new Random();

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                library.enterReader(number);

                System.out.println("Reader" + number + " is reading.");

                int secondsReading = random.nextInt(2000) + 1000;
                Thread.sleep(secondsReading);

                library.leaveReader(number);

                int secondsWaiting = random.nextInt(5000) + 2000;
                Thread.sleep(secondsWaiting);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
