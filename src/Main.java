import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main (String[] args)
    {
        foobar(false);

        try
        {
            presentTheMenu();
            // GypsyTest();
            // PizzaTest();
            //PolishTest();
            // PerformanceTest();
        } catch (Exception e) {
            System.out.println("Someone fucked up: " + e);
        }
    }

    public static void presentTheMenu()
    {
        LinkedListTest list = new LinkedListTest();
        Menu mainMenu = new Menu();
        mainMenu.display(list);
    }
    //region Tests
    public static void PolishTest()
    {
        // region ANSI CODES
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLACK = "\u001B[30m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_CYAN = "\u001B[36m";
        String ANSI_WHITE = "\u001B[37m";

        String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        String ANSI_RED_BACKGROUND = "\u001B[41m";
        String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        String ANSI_WHITE_BACKGROUND = "\u001B[47m";
        // endregion

        System.out.println(ANSI_PURPLE + "Yeet" + ANSI_RESET);

        // region List init and assigment testing

        DoubleLinkedList list = new DoubleLinkedList();
        System.out.println(ANSI_YELLOW + "> Empty list after init:" + ANSI_RESET);
        System.out.print(ANSI_GREEN);
        //list.printList();
        System.out.print(ANSI_RESET);


        list.add(new Player("yeet", "yeet", "yeet", 42));
        System.out.println(ANSI_YELLOW + "> Added one element:" + ANSI_RESET);
        System.out.print(ANSI_GREEN);
        list.printList();
        System.out.print(ANSI_RESET);


        list.add(new Player("yeet", "yeet", "yeet", -100));
        list.add(new Player("yeet2", "yeet", "yeet", 0));
        list.add(new Player("yeet3", "yeet", "yeet", 50));
        list.add(new Player("yeet4", "yeet", "yeet", 70));
        list.add(new Player("yeet5", "yeet", "yeet", 42));
        list.add(new Player("yeet6", "yeet", "yeet", 990));

        System.out.println(ANSI_YELLOW + "> Added a lot:" + ANSI_RESET);
        System.out.print(ANSI_GREEN);
        list.printList();
        System.out.print(ANSI_RESET);


        list.sortByAge();
        System.out.println(ANSI_YELLOW + "> Sorted by Age:" + ANSI_RESET);
        System.out.print(ANSI_GREEN);
        list.printList();
        System.out.print(ANSI_RESET);

        // endregion

        // region File Management Testing
        // Clear the List
        list = new DoubleLinkedList();

        try
        {
            FileManagement.readFromFile(list);
            System.out.println(ANSI_YELLOW + "> Reading from File, 3 Players:" + ANSI_RESET);
            System.out.print(ANSI_GREEN);
            list.printList();
            System.out.print(ANSI_RESET);


            FileManagement.saveToFile(list);
            System.out.println(ANSI_YELLOW + "> Saving to file, 3 elements:" + ANSI_RESET);
            System.out.print(ANSI_GREEN);
            list.printList();
            System.out.print(ANSI_RESET);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }

        // endregion

        Scanner console = new Scanner(System.in);
        System.out.print(ANSI_YELLOW + "Press enter to finish" + ANSI_RESET);
        console.nextLine();
    }

    public static void PerformanceTest()
    {
        PerformanceTest test = new PerformanceTest();
        test.runtest();
    }

    // idk which comments are whose so I just copied all
    public static void GypsyTest() throws FileNotFoundException
    {
        Menu mainMenu = new Menu();

        //testing
        LinkedListTest list = new LinkedListTest();

        //list.add(new Player ("s", "ds", "da", 3));
        /*
        list.add(new Player ("4", "ds", "da", 3));
        list.add(new Player ("5", "ds", "da", 3));
        list.add(new Player ("6", "ds", "da", 3));
        list.add(new Player ("7", "ds", "da", 3));

        list.add(new Player ("s", "dasdasdad", "da", 5), 3);
        */


        System.out.println("**********************");

        list.sortByAge();

        list.printList();

        //testing end

        //Populate the LinkedLists from a text file here?
        FileManagement.readFromFile(list);
        mainMenu.display(list);
        FileManagement.saveToFile(list);
        list.printList();
        //Save the LinkedList contents to file here?
    }

    public static void PizzaTest() throws FileNotFoundException
    {
        Menu mainMenu = new Menu();

        //testing
        LinkedListTest list = new LinkedListTest();

        //list.add(new Player ("s", "ds", "da", 3));

        list.add(new Player ("Cristi", "ds", "da", 3));
        list.add(new Player ("Alexander", "ds", "da", 3));
        list.add(new Player ("Jan", "ds", "da", 3));
        list.add(new Player ("Teo", "ds", "da", 3));
        list.add(new Player ("Alex", "ds", "da", 3));

        //list.add(new Player ("s", "dasdasdad", "da", 5), 3);



        System.out.println("**********************");

        list.sortByFirstName();

        list.printList();

        //testing end

        //Populate the LinkedLists from a text file here?
        /*FileManagement.readFromFile(list);
        mainMenu.display(list);
        FileManagement.saveToFile(list);
        list.printList();*/
        //Save the LinkedList contents to file here?
    }
    //endregion
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