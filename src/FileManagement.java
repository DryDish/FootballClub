import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintStream;

public class FileManagement {

    public FileManagement() {}

    //File document = new File("TextStorage.txt");


    public static void saveToFile(LinkedListTest playerList) throws FileNotFoundException
    {
        PrintStream output = new PrintStream(new File ("TextStorage.txt"));

        Node listHead = playerList.getHead();
        while(listHead.getNext() != null)
        {
            output.println(listHead.toString());
        }
    }


}
