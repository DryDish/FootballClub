// Ziemniaki zacz€to pisac o 23:42 pod wpylew 5-ciu pilsnerow i marihuannnny
// zakoczono o X
public class DoubleLinkedList
{

    private Node head = new Node(); // First node of the list

    public DoubleLinkedList()
    {

    }

    public DoubleLinkedList(Node head)
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
            Node currentNode = this.head;    // Iterate over elements without moving the head

            while(currentNode.getNext() != null)
            {
                currentNode = currentNode.getNext();
            }

            nextNode.setPrevious(currentNode);
            currentNode.setNext(nextNode);
        }
    }

    public void add(Player data, int index)
    {
        if (this.size() > index)
        {

            Node newNode = new Node(data);
            Node currentNode = this.head;
            if (index == 0)
            {
                newNode.setNext(this.head);
                this.head = newNode;
            } else
            {
                int i = 0;
                while (i < index - 1)
                {
                    currentNode = currentNode.getNext();
                    i++;
                }
                newNode.setNext(currentNode.getNext());
                newNode.setPrevious(currentNode);
                currentNode.setNext(newNode);
            }
        }
    }

    public void remove(int index)
    {
        if (this.size() > index)
        {
            Node currentNode = head;
            if (index == 0)
            {
                head = currentNode.getNext();
            } else
            {
                int i = 0;
                while (i < index - 1)
                {
                    currentNode = currentNode.getNext();
                    i++;
                }
                currentNode.setNext(currentNode.getNext().getNext());
            }
        }
    }

    public Node get(int index)
    {
        if (this.size() > index)
        {
            Node currentNode = head;
            int i = 0;
            while (i < index)
            {
                currentNode = currentNode.getNext();
                i++;
            }
            return currentNode;
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
            Node currentNode = head;
            int index = 0;
            while (currentNode.getNext() != null)
            {
                if (currentNode.getData().getAge() > currentNode.getNext().getData().getAge())
                {
                    sorted = false;
                    swap(index, index + 1);
                }
                currentNode = currentNode.getNext();
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
            Node currentNode = head;
            while (currentNode.getNext() != null)
            {
                length++;
                currentNode = currentNode.getNext();
            }
            return length;
        }
    }

    public void printList()
    {
        Node currentNode = head;
        System.out.println(currentNode.toString());
        while (currentNode.getNext() != null)
        {
            currentNode = currentNode.getNext();
            System.out.println(currentNode.toString());
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
