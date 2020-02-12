import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Menu {

    private int decorationSpace;
    private int lineSpacer = 80;
    private int screenNumber;

    public Menu()
    {
    }

    public void display()
    {
        Scanner input = new Scanner(System.in);
        boolean run=true;
        int selection;
        while (run)
        {
            screenNumber = 1;
            switch (screenNumber)
            {
                case 1:
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
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            run = false;
                    }



                }
            }
        }


    }









    private int intCheck(int min,int max)
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
    private void headerDisplay(@NotNull String header)
    {
        decorationSpace = (lineSpacer-header.length())/2;
        for (int i=0;i<lineSpacer;i++)
        {
            System.out.print("-");
        }
        System.out.println();
        blankSpace(decorationSpace);
        System.out.print(header);
        blankSpace(decorationSpace);
        System.out.println();
        for (int i=0; i<lineSpacer; i++)
        {
            System.out.print("-");
        }
        System.out.println();
    }

    private void blankSpace( int amount )
    {
        for (int i =0; i< amount; i++)
        {
            System.out.print(" ");
        }
    }
    //endregion


}
