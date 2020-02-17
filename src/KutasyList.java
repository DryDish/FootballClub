// Ziemniaki zacz€to pisac o 23:42 pod wpylew 5-ciu pilsnerow i marihuannnny
// zakoczono o X
public class KutasyList
{

    private Node head = new Node(); // First node of the list

    public KutasyList()
    {

    }

    public KutasyList(Node head)
    {
        this.head = head;
    }

    public void add(Player data)
    {
        if (this.head.getData() == null)
        {
            this.head.setData(data);
        }
        else if (head.getNext() == null)
        {
            Node nextNode = new Node(data);
            nextNode.setPrevious(this.head);
            this.head.setNext(nextNode);
        }
        else
        {
            Node nextNode = new Node(data);
            Node current = this.head;    // Iterate over elements without moving the head

            while(current.getNext() != null)
            {
                current = current.getNext();
            }

            nextNode.setPrevious(current);
            current.setNext(nextNode);
        }
    }

    public void add(Player data, int index)
    {
        if (this.size() > index)
        {

            Node newNode = new Node(data);
            Node current = this.head;
            if (index == 0)
            {
                newNode.setNext(this.head);
                this.head = newNode;
            } else
            {
                int i = 0;
                while (i < index - 1)
                {
                    current = current.getNext();
                    i++;
                }
                newNode.setNext(current.getNext());
                newNode.setPrevious(current);
                current.setNext(newNode);
            }
        }
    }

    public void remove(int index)
    {
        if (this.size() > index)
        {
            Node current = head;
            if (index == 0)
            {
                head = current.getNext();
            } else
            {
                int i = 0;
                while (i < index - 1)
                {
                    current = current.getNext();
                    i++;
                }
                current.setNext(current.getNext().getNext());
            }
        }
    }

    public Node get(int index)
    {
        if (this.size() > index)
        {
            Node current = head;
            int i = 0;
            while (i < index)
            {
                current = current.getNext();
                i++;
            }
            return current;
        }
        return null;
    }

    public void swap(int index1, int index2)
    {

        if (head == null)
        {
            return;
        }
        if (index1 >= index2)
        {
            return;
        }
        Node temp1 = this.get(index1);
        Node temp2 = this.get(index2);
        this.add(temp2.getData(), index1);
        this.remove(index1 + 1);
        this.add(temp1.getData(), index2);
        this.remove(index2 + 1);

    }

    public void sortByAge()
    {
        boolean sorted = false;
        while (!sorted)
        {
            sorted = true;
            Node current = head;
            int index = 0;
            while (current.getNext() != null)
            {
                if (current.getData().getAge() > current.getNext().getData().getAge())
                {
                    sorted = false;
                    swap(index, index + 1);
                }
                current = current.getNext();
                index++;
            }
        }
    }

    public int size()
    {
        if (head == null)
        {
            return 0;
        } else
        {
            int length = 1;
            Node current = head;
            while (current.getNext() != null)
            {
                length++;
                current = current.getNext();
            }
            return length;
        }
    }

    public void printList()
    {
        Node current = head;
        System.out.println(current.toString());
        while (current.getNext() != null)
        {
            current = current.getNext();
            System.out.println(current.toString());
        }
    }

    public Node getHead()
    {
        return head;
    }

    public void setHead(Node head)
    {
        this.head = head;
    }
}
