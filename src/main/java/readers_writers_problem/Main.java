package readers_writers_problem;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        int writersNum = 3;
        int readersNum = 10;

        if(args.length > 0) {
            writersNum = Integer.parseInt(args[0]);
            readersNum = Integer.parseInt(args[1]);
        }

        for (int i = 1; i <= writersNum; i++) {
            Writer writer = new Writer(i, library);
            writer.start();
        }

        for (int i = 1; i <= readersNum; i++) {
            Reader reader = new Reader(i, library);
            reader.start();
        }
    }
}
