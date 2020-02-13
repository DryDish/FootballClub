public class Main {

    public static void main(String[] args)
    {
        Menu mainMenu = new Menu();

        //testing
        NodeList list = new NodeList();
        Player p = new Player("Thomas", "LastName", "Yeah", 14);
        list.setPlayer(p);

        list.addNode(new Player("T", "g", "s", 12));
        list.addNode(new Player("T", "r", "s", 11));

        list.printList();
        //testing end

        //Populate the LinkedLists from a text file here?
        //mainMenu.display();
        //Save the LinkedList contents to file here?
    }
}
