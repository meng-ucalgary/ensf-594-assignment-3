import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Implements the logic to solve the given problem statement
 *
 * @author Bhavyai Gupta
 */
public class App {
    private FileReader inputFile;
    private FileWriter outputFile;
    private ArrayList<LinkedList> wordlist;

    /**
     * Constructs App object with default initializations
     */
    private App() {
        try {
            this.inputFile = new FileReader(new File("input.txt"));
            this.outputFile = new FileWriter(new File("output.txt"));
            this.wordlist = new ArrayList<>();
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
            Runtime.getRuntime().exit(1);
        }

        catch (IOException e) {
            e.printStackTrace();
            Runtime.getRuntime().exit(1);
        }
    }

    /**
     * Read the input file, processes it and writes output in output file
     */
    private void main() {
        System.out.printf("%nProcessing...%n");

        try (BufferedReader br = new BufferedReader(this.inputFile)) {
            String str;

            // read all words till EOF is reached
            while ((str = br.readLine()) != null) {
                boolean inserted = false;

                // try inserting in existing Linked Lists
                for (int i = 0; i < this.wordlist.size(); i++) {
                    if (this.wordlist.get(i).checkAndInsert(str) == true) {
                        inserted = true;
                        break;
                    }
                }

                // if the word is inserted in existing Linked Lists, read the next word
                if (inserted) {
                    continue;
                }

                // if not, store it in its own linked list
                else {
                    LinkedList ll = new LinkedList();
                    ll.checkAndInsert(str);
                    this.wordlist.add(ll);
                }
            }

            // write the processed output in desired form
            this.writeFile();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            System.out.printf("%nDone!%n");
        }
    }

    /**
     * Writes the wordlist to the output file, with each Linked List on its own line
     */
    public void writeFile() {
        PrintWriter pw = new PrintWriter(new BufferedWriter(this.outputFile), true);

        for (int i = 0; i < this.wordlist.size(); i++) {
            pw.printf("%s%n", this.wordlist.get(i).toString());
        }

        pw.close();
    }

    /**
     * Entry point of the program
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        App app = new App();
        app.main();
    }
}
