import javax.management.NotificationEmitter;
import java.util.ArrayList;

public class LinkedListTest {

    //region Attributes
    private Node head = new Node(); // First node of the list
    //endregion

    //region Constructors
    LinkedListTest () {

    }

    LinkedListTest ( Node head ) {
        this.head = head;
    }
    //endregion

    //region Methods
    //region Add Methods
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
    //endregion

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

    //region Search Methods
    public ArrayList<Integer> searchName ( String name ) {
        ArrayList<Integer> results = new ArrayList<>();
        String toSearch = name.toLowerCase();
        for ( int i = 0; i < this.size(); i++ ) {
            String searchIn1 = this.get(i).getData().getFirstName().toLowerCase();
            String searchIn2 = this.get(i).getData().getLastName().toLowerCase();
            if (searchIn1.contains(toSearch) || searchIn2.contains(toSearch)) {
                results.add(i);
            }
        }
        return results;
    }

    public ArrayList<Integer> searchTeam ( String team ) {
        ArrayList<Integer> results = new ArrayList<>();
        String toSearch = team.toLowerCase();
        for ( int i = 0; i < this.size(); i++ ) {
            String searchIn1 = this.get(i).getData().getTeam().toLowerCase();
            if (searchIn1.contains(toSearch)) {
                results.add(i);
            }
        }
        return results;
    }

    public ArrayList<Integer> searchAge ( int age ) {
        ArrayList<Integer> results = new ArrayList<>();
        for ( int i = 0; i < this.size(); i++ ) {
            if (age == this.get(i).getData().getAge()) {
                results.add(i);
            }
        }
        return results;
    }
    //endregion

    //region Sort Methods
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

    public void sortByFirstName () {
        boolean sorted = false;
        while ( !sorted ) {
            sorted = true;
            Node current = head;
            int index = 0;
            while (current.getNext() != null) {
                if (current.getData().getFirstName().compareTo(current.getNext().getData().getFirstName())>0){
                    sorted = false;
                    swap (index, index+1);
                }
                current = current.getNext();
                index++;
            }
        }
    }

    public void sortByLastName () {
        boolean sorted = false;
        while ( !sorted ) {
            sorted = true;
            Node current = head;
            int index = 0;
            while (current.getNext() != null) {
                if ((current.getData().getLastName().compareTo(current.getNext().getData().getLastName())>0)){
                    sorted = false;
                    swap (index, index+1);
                }
                current = current.getNext();
                index++;
            }
        }
    }

    public void sortByTeam () {
        boolean sorted = false;
        while ( !sorted ) {
            sorted = true;
            Node current = head;
            int index = 0;
            while (current.getNext() != null) {
                if ((current.getData().getTeam().compareTo(current.getNext().getData().getTeam()))>0){
                    sorted = false;
                    swap (index, index+1);
                }
                current = current.getNext();
                index++;
            }
        }
    }
    //endregion

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
    //endregion

    //region Getters & Setters
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
    //endregion
}
