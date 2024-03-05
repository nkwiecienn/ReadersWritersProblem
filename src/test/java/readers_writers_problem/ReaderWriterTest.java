package readers_writers_problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ReaderWriterTest {

    @Test
    void readersAndWritersAreAlive () throws InterruptedException {
        Library library = new Library();
        Reader reader1 = new Reader(1, library);
        Reader reader2 = new Reader(2, library);
        Writer writer1 = new Writer(1, library);

        reader1.start();
        reader2.start();
        writer1.start();

        Thread.sleep(10000);

        assertTrue(reader1.isAlive());
        assertTrue(reader2.isAlive());
        assertTrue(writer1.isAlive());
    }

}