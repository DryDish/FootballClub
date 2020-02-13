import javax.management.NotificationEmitter;

public class LinkedListTest {

    private Node head = new Node(); // First node of the list

    LinkedListTest () {

    }

    public void add ( Player data )
    {
        if ( head.getData() == null )
        {
            head.setData(data);
        }
        else if ( head.getNext() == null )
        {
            Node temp = new Node( data );
            head.setNext(temp);
        }
        else
        {
            Node temp = new Node(data);
            Node current = head;

            while ( current.getNext() != null )
            {
                current = current.getNext();
            }
            current.setNext(temp);
        }
    }

    public void add ( Player data, int index )
    {
        if ( this.size() > index )
        {
            Node temp = new Node(data);
            Node current = head;
            int i = 0;
            while ( i < index-1 )
            {
                current = current.getNext();
                i++;
            }
            temp.setNext(current.getNext());
            current.setNext(temp);
        }
    }

    public void remove ( int index ) {
        if ( this.size() > index ) {
            Node current = head;
            int i = 0;
            while ( i < index-1 )
            {
                current = current.getNext();
                i++;
            }
            current.setNext(current.getNext().getNext());
        }
    }

    public Player get ( int index )
    {
        if ( this.size() > index ) {
            Node current = head;
            int i = 0;
            while ( i < index )
            {
                current = current.getNext();
                i++;
            }
            return current.getData();
        }
        return null;
    }

    public int size ()
    {
        if ( head == null )
        {
            return 0;
        }
        else
        {
            int length = 1;
            Node current = head;
            while ( current.getNext() != null )
            {
                length++;
                current = current.getNext();
            }
            return length;
        }
    }

    public void printList () {
        Node current = head;
        System.out.println(current.toString());
        while ( current.getNext() != null ) {
            current = current.getNext();
            System.out.println(current.toString());
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}
