import java.util.Scanner;

public class Menu {

    private int decorationSpace;
    private int lineSpacer = 80;
    private int screenNumber;

    public Menu()
    {
    }

    public void display(LinkedListTest list) //to keep the code clean we put display in its own class
    {
        Scanner input = new Scanner(System.in); //scanner for user input
        boolean run=true; //boolean to be able to exit runtime without need of class specific console commands
        int selection; //to register input

        String firstName;
        String lastName;
        String team;
        int age;

        while (run)
        {
            headerDisplay("FOOTBALL CLUB");
            System.out.println("what would you like to do?");
            System.out.println("1) See all current players");
            System.out.println("2) Add a new player"); //complete
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
                    //region Add new player
                    headerDisplay("CREATE A NEW PLAYER");
                    System.out.println("In order to create a new player we will need some information about them.");
                    System.out.println("Please type the new player's first name.");
                    firstName = input.next();
                    System.out.println("Next, please type the new player's last name.");
                    lastName = input.next();
                    System.out.println("Next, please type the new player's age.");
                    age = intCheck();
                    System.out.println("For what team will this new player be playing for?");
                    System.out.println("1) F.C. København");
                    System.out.println("2) Randers FC.");
                    selection =intCheck(1,2);
                        if (selection==1)
                        {
                            team = "F.C.København";
                        } else
                        {
                            team = "RandersFC";
                        }
                    Player createdInput = new Player(firstName, lastName,team, age);
                    list.add(createdInput);
                        // TEMP needs to be stored somewhere.
                    System.out.println("New player: " + firstName + " " + lastName + " has been created.");
                    run = backQuit();
                    //endregion
                    break;
                case 3: //Searches for a player in the linked list
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




    private boolean backQuit() //gives a choice of main menu or quiting program
    {
        int selection;
        System.out.println();
        System.out.println("What would you like to do now?");
        System.out.println("1) Return to main menu");
        System.out.println("2) Quit.");
        selection = intCheck(1,2);
        if (selection==1) //it returns true or false so u can set run to the returned value.
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    private int intCheck() //verify that the user input an int
    {
        int selection;
        Scanner console = new Scanner(System.in);
        while (!console.hasNextInt())
        {
            System.out.println("Please type a number.");
            String wrongSintax = console.next();
        }
        selection = console.nextInt();
        return selection;
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
