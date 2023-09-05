import java.io.FileNotFoundException;
import java.io.FileReader;

public class Checked {

    // Unhandled exception type FileNotFoundException
    // ChekedException dont even allow to compile
    private static void readFile(String filename) throws FileNotFoundException {
        FileReader reader = new FileReader(filename);

    }

    public static void main(String[] args) {
        try {
            readFile("myfile.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
