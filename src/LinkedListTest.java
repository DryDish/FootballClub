import javax.management.NotificationEmitter;

public class LinkedListTest {

    private Node head = new Node(); // First node of the list

    LinkedListTest () {

    }

    LinkedListTest ( Node head ) {
        this.head = head;
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
            if (index == 0) {
                temp.setNext(head);
                head = temp;
            }
            else {
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
    }

    public void remove ( int index ) {
        if ( this.size() > index ) {
            Node current = head;
            if (index == 0 ) {
                head = current.getNext();
            }
            else {
            int i = 0;
            while ( i < index-1 )
            {
                current = current.getNext();
                i++;
            }
            current.setNext(current.getNext().getNext());
            }
        }
    }

    public Node get ( int index )
    {
        if ( this.size() > index ) {
            Node current = head;
            int i = 0;
            while ( i < index )
            {
                current = current.getNext();
                i++;
            }
            return current;
        }
        return null;
    }

    public void swap ( int index1, int index2 ) {

        if(head == null) {
            return;
        }
        if(index1 >= index2) {
            return;
        }
        /*Node temp1 = this.get(index1);
        Node prev1 = this.get(index1-1);
        Node temp2 = this.get(index2);
        Node prev2 = this.get(index2-1);

        if (prev1 != null) {
            prev1.setNext(temp2);
        }
        else {
            head = temp2;
        }
        if (prev2 != null) {
            prev2.setNext(temp1);
        }
        else {
            head = temp1;
        }

        Node current = temp1.getNext();
        temp1.setNext(temp2.getNext());
        temp2.setNext(current);*/
        Node temp1 = this.get(index1);
        Node temp2 = this.get(index2);
        this.add (temp2.getData(), index1);
        this.remove (index1+1);
        this.add (temp1.getData(), index2);
        this.remove (index2+1);

    }

    public void sortByAge () {
        boolean sorted = false;
        while ( !sorted ) {
            sorted = true;
            Node current = head;
            int index = 0;
            while (current.getNext() != null) {
                if (current.getData().getAge() > current.getNext().getData().getAge()){
                    sorted = false;
                    swap (index, index+1);
                }
                current = current.getNext();
                index++;
            }
        }
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
