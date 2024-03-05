package readers_writers_problem;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class Writer extends Thread {
    private final int number;
    private final Library library;
    Random random = new Random();

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                library.enterWriter(number);

                System.out.println("Writer" + number + " is writing.");

                int secondsWriting = random.nextInt(2000) + 1000;
                Thread.sleep(secondsWriting);

                library.leaveWriter(number);

                int secondsWaiting = random.nextInt(5000) + 2000;
                Thread.sleep(secondsWaiting);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
