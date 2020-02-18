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
        ArrayList<Player> arrList = new ArrayList<Player>();
        //LinkedListTest linkedList = new LinkedListTest();
        LinkedList<Player> linkedList = new LinkedList<Player>();

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
            try
            {
                playerAmount = Long.parseLong(console.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Wrong input, try again: " + ANSI_RESET);
            }

            System.out.println(ANSI_BLUE + "List population test:" + ANSI_RESET);
            // region test Array
            System.out.println(ANSI_BLUE + "ArrayList" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
            try
            {
                for (int i = 0; i < playerAmount; i++)
                {
                    arrList.add(this.dummy);
                }
            } catch (java.lang.OutOfMemoryError e) {
                System.out.println(ANSI_RED + "Run out of memory on the head: ");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                System.out.println(sw.toString());
            }
            System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);
            // endregion add
            // region test LinkedList
            System.out.println(ANSI_BLUE + "Linked List" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
            try
            {
                for (int i = 0; i < playerAmount; i++)
                {
                    linkedList.add(this.dummy);
                }
            } catch (java.lang.OutOfMemoryError e) {
                System.out.println(ANSI_RED + "Run out of memory on the head: ");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                System.out.println(sw.toString());
            }
            System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);
            // endregion


            System.out.println(ANSI_BLUE + "List iteration test:" + ANSI_RESET);
            // region test Array
            System.out.println(ANSI_BLUE + "ArrayList" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
            try
            {
                for (int i = 0; i < arrList.size(); i++)
                {
                    arrList.get(i);
                }
            } catch (java.lang.OutOfMemoryError e) {
                System.out.println(ANSI_RED + "Run out of memory on the head: ");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                System.out.println(sw.toString());
            }
            System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);
            // endregion add
            // region test LinkedList
            System.out.println(ANSI_BLUE + "Linked List" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
            try
            {
                for (int i = 0; i < linkedList.size(); i++)
                {
                    linkedList.get(i);
                }
            } catch (java.lang.OutOfMemoryError e) {
                System.out.println(ANSI_RED + "Run out of memory on the head: ");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                System.out.println(sw.toString());
            }
            System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);
            // endregion
            // region test LinkedList
            System.out.println(ANSI_BLUE + "Linked List WITH an iterator" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "Start: " + getCurrentTime() + ANSI_RESET);
            try
            {
                Iterator<Player> iter = linkedList.iterator();
                Player temp;
                for (int i = 0; i < linkedList.size(); i++)
                {
                    temp = iter.next();
                }
            } catch (java.lang.OutOfMemoryError e) {
                System.out.println(ANSI_RED + "Run out of memory on the head: ");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                System.out.println(sw.toString());
            }
            System.out.println(ANSI_GREEN + "End:   " + getCurrentTime() + ANSI_RESET);
            // endregion
        }
    }

    private String getCurrentTime()
    {
        return LocalTime.now().toString();
    }
}
