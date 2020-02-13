public class NodeList {

    //region Attributes
    private Player player;
    private NodeList next;
    //endregion

    //region Constructors
    public NodeList () {
        this(null, null);
    }

    public NodeList ( Player player ) {
        this.player = player;
        this.next = null;
    }

    public NodeList ( Player player, NodeList next ) {
        this.player = player;
        this.next = next;
    }
    //endregion

    //region Methods
    // Adds a player as the last node in a list.
    public void addNode ( Player player ) {
        NodeList currentNode = this; // Creates a node to go through the list
        while ( currentNode.next != null ) {
            currentNode = currentNode.next;
        } // Gets to the end of the list
        currentNode.next = new NodeList( player ); // Adds new element
    }
    public void printList () {
        NodeList currentNode = this;
        while ( currentNode.next != null ) {
            System.out.println(currentNode.toString());
            currentNode = currentNode.next;
        }
        System.out.println(currentNode.toString());
    }
    //endregion

    //region Getters & Setters
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public NodeList getNode() {
        return next;
    }

    public void setNode(NodeList next) {
        this.next = next;
    }
    //endregion

    //region toString
    @Override
    public String toString() {
        return player.toString();
    }
    //endregion
}
