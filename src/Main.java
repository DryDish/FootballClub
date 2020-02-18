import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main (String[] args)
    {
        foobar(false);

        try //checks for errors
        {
            GypsyTest();
            // PerformanceTest();
        } catch (Exception e) {
            System.out.println("Someone fucked up: " + e);
        }
    }

    // idk which comments are whose so I just copied all
    public static void GypsyTest() throws FileNotFoundException
    {
        Menu mainMenu = new Menu();


        LinkedListTest list = new LinkedListTest();

        FileManagement.readFromFile(list);
        mainMenu.display(list);
        FileManagement.saveToFile(list);
        //list.printList();
    }


    public static void foobar(boolean doit)
    {
        try
        {
            Musik musik = new Musik("musik");
            if(doit) musik.play();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}