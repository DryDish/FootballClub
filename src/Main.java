public class Main {

    public static void main(String[] args)
    {
        Menu mainMenu = new Menu();

        //testing
        LinkedListTest list = new LinkedListTest();
        list.add(new Player ("s", "ds", "da", 3));
        list.add(new Player ("4", "ds", "da", 2));
        list.add(new Player ("5", "ds", "da", 1));
        list.add(new Player ("6", "ds", "da", 7));
        list.add(new Player ("7", "ds", "da", 10));

        //list.add(new Player ("s", "dasdasdad", "da", 5), 3);

        list.printList();

        System.out.println("**********************");

        list.sortByAge();

        list.printList();

        //testing end

        //Populate the LinkedLists from a text file here?
        //mainMenu.display();
        //Save the LinkedList contents to file here?
    }
}
