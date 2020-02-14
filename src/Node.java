public class Node {

    private Player data = new Player();
    private Node next;

    public Node ()
    {
        this(null,null);
    }

    public Node ( Player data ) {
        this.data = data;
        this.next = null;
    }

    public Node ( Player data, Node next ) {
        this.data = data;
        this.next = next;
    }

    public Player getData() {
        return data;
    }

    public void setData(Player data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
