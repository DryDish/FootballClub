import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class PerformanceTest
{
    // region Ansi Codes
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_YELLOW = "\u001B[33m";
    private final String ANSI_BLUE = "\u001B[34m";
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_WHITE = "\u001B[37m";
    // endregion

    Player dummy;
    
    public void runtest()
    {
        // Primary variables for this experiment: The Lists
        ArrayList<Player> arrayList = new ArrayList<Player>();
        LinkedListTest implementedLinkedList = new LinkedListTest();
        LinkedList<Player> javaLinkedList = new LinkedList<Player>();

        this.dummy = new Player("Peter", "Griffin", "Team Red", 100);
        Scanner console = new Scanner(System.in);
        long playerAmount = 0;

        // Main Loop
        while (true)
        {
            System.out.println(ANSI_PURPLE + "----------Performance Testing----------" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "We are going to run a couple of tests to determine which list is fastest" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "How many players do we test with: " + ANSI_RESET);
            while(true)
            {
                try
                {
                    playerAmount = Long.parseLong(console.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println(ANSI_RED + "Wrong input, try again: " + ANSI_RESET);
                }
            }
            if(playerAmount == 0) break;

            // region List Operations
            try
            {
                // region List Population Test
                System.out.println(ANSI_BLUE + "List population test (adding X amount of objects):" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "ArrayList" + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                for (int i = 0; i < playerAmount; i++)
                {
                    arrayList.add(this.dummy);
                }
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);
                System.out.println(ANSI_BLUE + "Java Linked List" + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                for (int i = 0; i < playerAmount; i++)
                {
                    javaLinkedList.add(this.dummy);
                }
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);
                System.out.println(ANSI_BLUE + "Implemented Linked List" + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                for (int i = 0; i < playerAmount; i++)
                {
                    implementedLinkedList.add(this.dummy);
                }
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);
                // endregion

                // region List Iteration Test
                System.out.println(ANSI_BLUE + "\nList iteration test (calling .get() on every element, sequentially):" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "ArrayList" + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                for (int i = 0; i < arrayList.size(); i++)
                {
                    arrayList.get(i);
                }
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);

                System.out.println(ANSI_BLUE + "ArrayList using a FOR EACH" + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                for (Player player:arrayList)
                {
                    // Do nothing
                }
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);

                System.out.println(ANSI_BLUE + "ArrayList using An Iterator" + ANSI_RESET);
                Iterator<Player> iter = arrayList.iterator();
                Player temp;
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                while(iter.hasNext())
                {
                    temp = iter.next();
                }
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);

                System.out.println(ANSI_BLUE + "Java Linked List" + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                for (int i = 0; i < javaLinkedList.size(); i++)
                {
                    javaLinkedList.get(i);
                }
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);

                System.out.println(ANSI_BLUE + "Implemented Linked List" + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                for (int i = 0; i < implementedLinkedList.size(); i++)
                {
                    implementedLinkedList.get(i);
                }
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);

                System.out.println(ANSI_BLUE + "Java Linked List WITH an iterator" + ANSI_RESET);

                iter = javaLinkedList.iterator();
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                while(iter.hasNext())
                {
                    temp = iter.next();
                }
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);

                System.out.println(ANSI_BLUE + "Java Linked List using a FOR EACH" + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                for (Player player:javaLinkedList)
                {
                    // Do nothing, they got accessed
                }
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);
                // endregion

                // region List Accessing First, Middle and Last Element Tests
                System.out.println(ANSI_BLUE + "\nList Accessing First, Middle and Last Element Tests:" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "ArrayList, first Element" + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                arrayList.get(0);
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);

                System.out.println(ANSI_BLUE + "ArrayList, Middle Element" + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                arrayList.get((int)playerAmount/2);
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);

                System.out.println(ANSI_BLUE + "ArrayList, Last Element" + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                arrayList.get(arrayList.size()-1);
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);

                System.out.println(ANSI_BLUE + "Java Linked List, First Element" + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                javaLinkedList.get(0);
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);

                System.out.println(ANSI_BLUE + "Java Linked List, middle Element" + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                javaLinkedList.get((int)playerAmount/2);
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);

                System.out.println(ANSI_BLUE + "Java Linked List, Last Element" + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                javaLinkedList.get(javaLinkedList.size()-1);
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);


                System.out.println(ANSI_BLUE + "Implemented Linked List, First Element" + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                implementedLinkedList.remove(0);
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);

                System.out.println(ANSI_BLUE + "Implemented Linked List, middle Element" + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                implementedLinkedList.remove((int)playerAmount/2);
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);

                System.out.println(ANSI_BLUE + "Implemented Linked List, Last Element" + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
                implementedLinkedList.get(javaLinkedList.size()-1);
                System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);
                // endregion
            } catch (java.lang.OutOfMemoryError e)
            {
                System.out.println(ANSI_RED + "Run out of memory on the head: ");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                System.out.println(sw.toString());
            }
            // endregion
        }
    }

    private String getCurrentTime()
    {
        return LocalTime.now().toString();
    }
}
