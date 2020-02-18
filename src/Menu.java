import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    private int decorationSpace;
    private int lineSpacer = 80;
    private int screenNumber;
    int selection; //to register input

    public Menu()
    {
    }

    public void display(LinkedListTest list) //to keep the code clean we put display in its own class
    {
        Scanner input = new Scanner(System.in); //scanner for user input
        boolean run=true; //boolean to be able to exit runtime without need of class specific console commands


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
            System.out.println("4) Kick out a current player");
            System.out.println("5) Close the program");
            System.out.println("6) Bonus - performance comparison");
            selection = intCheck(1,6);
            switch (selection)
            {
                case 1: //show a list of all current players from linked list
                    headerDisplay("SHOW A LIST OF ALL PLAYERS");
                    System.out.println("What would you like to sort the list of players by?");
                    System.out.println("1) First name");
                    System.out.println("2) Last name");
                    System.out.println("3) Age");
                    System.out.println("4) Team");
                    System.out.println("5) Return to main menu");
                    int selection2 = intCheck(1,5);
                    switch (selection2)
                    {
                        case 1:
                            headerDisplay("ALL PLAYERS SORTED BY FIRST NAME");
                            list.sortByFirstName();
                            list.printList();
                            selection = 1;
                            backQuit();
                            break;
                        case 2:
                            headerDisplay("ALL PLAYERS SORTED BY LAST NAME");
                            list.sortByLastName();
                            list.printList();
                            selection = 1;
                            backQuit();
                            break;
                        case 3:
                            headerDisplay("ALL PLAYERS SORTED BY AGE");
                            list.sortByAge();
                            list.printList();
                            selection = 1;
                            backQuit();
                            break;
                        case 4:
                            headerDisplay("ALL PLAYERS SORTED BY TEAM");
                            list.sortByTeam();
                            list.printList();
                            selection = 1;
                            break;
                        case 5:
                            selection = 1;
                            break;
                    }
                    break;

                    /*
                    headerDisplay("CURRENT PLAYERS");
                    try
                    {
                        for (int i = 0; i < list.size(); i++)
                        {
                            System.out.println(list.get(i));
                        }
                    } catch (NullPointerException e) {
                        System.out.println("There is currently no players, add some first");
                    }
                    System.out.print("Press Enter to continue");
                    input.nextLine();
                    break;
                    */

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
                    System.out.println("New player: " + firstName + " " + lastName + " has been created.");
                    run = backQuit();
                    //endregion
                    break;
                case 3: //Searches for a player in the linked list
                    headerDisplay("SEARCH FOR A PLAYER");
                    System.out.println("Choose a search criteria :");
                    System.out.println("1) Name");
                    System.out.println("2) Team");
                    System.out.println("3) Age");
                    int result = intCheck(1, 3);
                    Scanner in = new Scanner (System.in);
                    ArrayList<Integer> players = new ArrayList<>();

                    switch (result) {
                        case 1:
                            System.out.println("Next, please type the Name :");
                            String nameInput = in.next() + in.nextLine();
                            players = list.searchName(nameInput);
                            for (int i = 0; i < players.size(); i ++ ) {
                                System.out.println(list.get(players.get(i)).getData().toString());
                                System.out.println();
                            }
                            break;
                        case 2:
                            System.out.println("Next, please type the Team :");
                            String teamInput = in.next() + in.nextLine();
                            players = list.searchTeam(teamInput);
                            for (int i = 0; i < players.size(); i ++ ) {
                                System.out.println(list.get(players.get(i)).getData().toString());
                                System.out.println();
                            }
                            break;
                        case 3:
                            System.out.println("Next, please type the Age :");
                            int ageInput = intCheck(0, 99);
                            players = list.searchAge(ageInput);
                            for (int i = 0; i < players.size(); i ++ ) {
                                System.out.println(list.get(players.get(i)).getData().toString());
                                System.out.println();
                            }
                    }
                    backQuit();
                    break;
                case 4: //Delete a player from the linked list
                    headerDisplay("PERISH A PLAYER");
                    list.printList();
                    System.out.println("What is the index of a player you would like to remove from the Team?");
                    selection = intCheck(1, list.size())-1;
                    System.out.println("Player " + list.get(selection) + " has been kicked out");
                    list.remove(selection);
                    run = backQuit();
                    break;
                case 5: //exit the runtime
                    run = false;
                    break;
                case 6:
                    PerformanceTest test = new PerformanceTest();
                    test.runtest();
                    break;
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
