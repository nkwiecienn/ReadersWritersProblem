package readers_writers_problem;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.Semaphore;

@Getter
@Setter
public class Library {
    private final Semaphore in;
    private final Semaphore out;
    private final Semaphore writer;
    int counterIn = 0;
    int counterOut = 0;
    boolean wait = false;

    /**
     * In and out Semaphores have the initial values of 1 to ensure exclusive access while
     * entering or leaving the library. The writer Semaphore initially has the value of 0
     * so that it doesn't allow writers to enter until reader signals it's safe.
     */
    public Library() {
        in = new Semaphore(1);
        out = new Semaphore(1);
        writer = new Semaphore(0);
    }

    /**
     * Reader request to enter the library by trying to acquire the in Semaphore. When it does,
     * it increments the number of readers that have entered the library. Then releases the semaphore
     * to let other readers in.
     * @param readerNumber reader ID number
     * @throws InterruptedException if the thread is interrupted while waiting for access
     */

    public void enterReader(int readerNumber) throws InterruptedException {
        System.out.println("Reader" + readerNumber + " wants to enter the library.");

        in.acquire();
        counterIn++;
        in.release();
    }

    /**
     * Reader leaves the library by trying to acquire the out Semaphore. While leaving checks if
     * any writer is waiting and if so, if they're the last one to leave. Then it releases
     * the writer Semaphore.
     * @param readerNumber reader ID number
     * @throws InterruptedException if the thread is interrupted while waiting for access
     */
    public void leaveReader(int readerNumber) throws InterruptedException {
        System.out.println("Reader" + readerNumber + " is leaving the library.");

        out.acquire();
        counterOut++;

        if (wait && counterIn == counterOut) {
            writer.release();
        }
        out.release();

    }


    /**
     * Writer tries to enter the library by trying to acquire the in and out Semaphores.
     * If counters in and out are equal the library is empty. The writer enters it
     * by releasing the out Semaphore. Otherwise, it sets the wait value to true to indicate
     * there is a writer waiting to enter. Then it can release the out Semaphore to let
     * readers out. It tries to acquire the writer Semaphore and when it does,
     * enters the library and sets the wait value to false since it's no longer waiting.
     * It's important to note that the method doesn't release the in Semaphore, since
     * in this solution no reader can enter a library if a writer signals it's waiting.
     * @param writerNumber writer ID number
     * @throws InterruptedException if the thread is interrupted while waiting for access
     */
    public void enterWriter(int writerNumber) throws InterruptedException {
        System.out.println("Writer" + writerNumber + " wants to enter the library.");

        in.acquire();
        out.acquire();

        if (counterIn == counterOut) {
            out.release();
        } else {
            wait = true;
            out.release();
            writer.acquire();
            wait = false;
        }
    }

    /**
     * Writer leaves the library by releasing the in Semaphore to let others in. From the moment
     * the writer signaled they wanted to enter the library no one was allowed in.
     * @param writerNumber writer ID number
     */
    public void leaveWriter(int writerNumber) {
        System.out.println("Writer" + writerNumber + " is leaving the library.");
        in.release();
    }
}
