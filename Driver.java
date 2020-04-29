import java.io.IOException;

/**
 * Driver class houses the main method which is the starting point of any Java app.
 * The main method in this class triggers the creation or usage of FileSorter object
 */

public class Driver {

    /**
     * The main method takes the name of the textfile as command line argument and
     * if not passed complains. It creates an instance of FileSorter object which
     * then calls the sorter method where the actual logic to the problem lives
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        if(args.length < 1) {
            throw new IOException("No file passed as argument");
        } else {
            String fName = args[0];
            FileSorter f = FileSorter.getInstance();
            f.sorter(fName);
        }
    }
}