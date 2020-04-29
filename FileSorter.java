import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * FileSorter class implements the Singleton design pattern which ensures that only one instance of the FileSorter object is maintained by the JVM and is re-used.
 * 
 * @author Vighnesh Iyer
 */


public class FileSorter {
    /**
     * The private instance of the FileSorter class that will be available to other classes to use, since it is private other classes will not be able to modify the object.
     * 
     */
    
    private static FileSorter instance = new FileSorter();

    /**
     * This is a getter method so that other classes can access the FileSorter instance
     * @return the only copy of the FileSorter instance 
     */
    public static FileSorter getInstance() {
        return instance;
    }

    /**
     * It sorts a text file line by line in an alphabetically case-insesitive order.
     * This methods reads file whose name is fileName, line by line and adds each line to an ArrayList<String> called list.
     * The collections framework in Java allows one to sort an arraylist of string in case-insensitive order as follows - Collections.sort(list, String.CASE_INSENSITIVE_ORDER).
     * After having sorted all the lines, it is then written to an output.txt file using methods from Files class provided by Java.
     * @param fileName The name of the file whose content is going to be read.
     * @throws IOException
     */
    public void sorter(final String fileName) throws IOException {
        File f;
        Scanner sc;
        ArrayList<String> list = new ArrayList<>();
        try {
            f = new File(fileName);
            sc = new Scanner(f);
            while (sc.hasNextLine()) {
                list.add(sc.nextLine());
            }
        } catch (final Exception e) {
            System.out.println("Please double check the name of your textfile");
            System.exit(0);
        }


        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        Path file = Paths.get("output.txt");
        Files.write(file, list, StandardCharsets.UTF_8);

    }


}