import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileManagement {

    public FileManagement() {}


    public static void saveToFile(LinkedListTest playerList) throws FileNotFoundException
    {
        boolean hasPrinted = false;
        PrintStream output = new PrintStream(new File ("TextStorage.txt"));

        Node listHead = playerList.getHead();
        output.print(listHead.toString());
        while(listHead.getNext() != null)
        {
            listHead = listHead.getNext();
            output.print("\n" +listHead.toString());
            hasPrinted = true;

        }
    }

    public static void readFromFile(LinkedListTest playerList) throws FileNotFoundException
    {
        String firstName;
        String lastName;
        String team;
        String temp;
        int age;

        Scanner input = new Scanner(new File("TextStorage.txt"));
        while (input.hasNextLine())
        {
            String line;
            line = input.nextLine();
            System.out.println(line);
            Scanner data = new Scanner (line);

            temp = data.next();
            firstName = data.next();
            lastName = data.next();
            temp = data.next();
            team = data.next();
            temp = data.next();
            age = data.nextInt();

            Player createdInput = new Player(firstName,lastName,team, age);
            playerList.add(createdInput);
        }
    }

}
