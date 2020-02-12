import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Menu {

    private int decorationSpace;
    private int lineSpacer = 80;
    private int screenNumber;

    public Menu()
    {
    }

    public void display() //to keep the code clean we put display in its own class
    {
        Scanner input = new Scanner(System.in); //scanner for user input
        boolean run=true; //boolean to be able to exit runtime without need of class specific console commands
        int selection; //to register input
        while (run)
        {
            headerDisplay("FOOTBALL CLUB");
            System.out.println("what would you like to do?");
            System.out.println("1) See all current players");
            System.out.println("2) Add a new player");
            System.out.println("3) Search for a player");
            System.out.println("4) Delete a current player");
            System.out.println("5) Close the program");
            selection = intCheck(1,5);
            switch (selection)
            {
                case 1: //show a list of all current players from linked list
                    headerDisplay("CURRENT PLAYERS");
                    break;
                case 2: //Adds a new player to linked list
                    headerDisplay("CREATE A NEW PLAYER");
                    break;
                case 3: //Searchers for a player in the linked list
                    headerDisplay("SEARCH FOR A PLAYER");
                    break;
                case 4: //Delete a player from the linked list
                    headerDisplay("DELETE A PLAYER");
                    break;
                case 5: //exit the runtime
                    run = false;

            }
        }


    }









    private int intCheck(int min,int max) //verify that the user input an int and that the int is in the desired range
    {
        int selection;
        Scanner console = new Scanner(System.in);
        String rangeMessage = ("Please type a number from " + min + " to " + max + ".");
        System.out.println(rangeMessage);
        while (!console.hasNextInt())
        {
            System.out.println(rangeMessage);
            String wrongSintax = console.next();
        }
        selection = console.nextInt();
        while (selection<min || selection>max)
        {
            System.out.println(rangeMessage);
            while (!console.hasNextInt())
            {
                System.out.println(rangeMessage);
                String wrongSintax = console.next();
            }
            selection = console.nextInt();
        }
        return selection;
    }


    //region Menu decoration
    private void headerDisplay(String header) //header for all menu locations with auto centering spacing
    {
        for (int i = 0; i<80; i++)
        {
            System.out.println();
        }
        decorationSpace = (lineSpacer-header.length())/2; //to measure the space needed to center the text
        for (int i=0;i<lineSpacer;i++)
        {
            System.out.print("-");
        }
        System.out.println();
        blankSpace(decorationSpace);
        System.out.print(header);
        System.out.println();
        for (int i=0; i<lineSpacer; i++)
        {
            System.out.print("-");
        }
        System.out.println();
    }

    private void blankSpace( int amount ) //Method to add blank spaces
    {
        for (int i =0; i< amount; i++)
        {
            System.out.print(" ");
        }
    }
    //endregion


}
