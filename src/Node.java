public class Node {

    private Player data = new Player();
    private Node next;
    private Node previous;

    public Node ()
    {
        this(null,null);
    }

    public Node ( Player data ) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public Node ( Player data, Node next ) {
        this.data = data;
        this.next = next;
        this.previous = null;
    }

    public Node ( Player data, Node next, Node previous ) {
        this.data = data;
        this.next = next;
        this.previous = previous;
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

    public Node getPrevious() { return previous;}

    public void setNext(Node next) {
        this.next = next;
    }
    public void setPrevious(Node previous) { this.previous = previous; }

    @Override
    public String toString() {
        return data.toString();
    }
}
