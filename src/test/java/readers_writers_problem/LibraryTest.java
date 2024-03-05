package readers_writers_problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibraryTest {

    Library library;

    @BeforeEach
    public void beforeEach() {
        library = new Library();
    }

    @Test
    void multipleReadersCanEnter () throws InterruptedException {
        library.enterReader(1);
        library.enterReader(2);
        library.enterReader(3);

        Assertions.assertEquals(3, library.getCounterIn());
        Assertions.assertEquals(0, library.getCounterOut());
    }

    @Test
    void readerSignalsThatLibraryIsEmpty() throws InterruptedException {
        library.enterReader(1);
        library.enterReader(2);
        library.leaveReader(1);
        library.setWait(true);

        Assertions.assertEquals(0, library.getWriter().availablePermits());

        library.leaveReader(2);

        Assertions.assertEquals(1, library.getWriter().availablePermits());
    }

    @Test
    void noReaderCanEnterAfterWriterSignal() throws InterruptedException {
        library.enterWriter(1);

        Assertions.assertEquals(0, library.getIn().availablePermits());
    }

}