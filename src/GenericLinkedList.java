public class GenericLinkedList<T> implements IList<T>{
    Node head; // head of list
    Node tail; // end of list

    int numElements = 0;

    public void addToStart(T val)
    {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        numElements++;
    }

    public void add(T val)
    {
        Node newNode = new Node(val);
        Node current = head;
        if(head ==null)
        {
            head = newNode;
            tail = head;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
        numElements++;

        /*
        if(head == null)
        {
            head = newNode;

        }
    else
        {
            while(current.next != null)
            {
                current = current.next;
            }
            current.next = newNode;
        }
    numElements++;

         */
    }

    public T get(int index)
    {
        if(head == null)
        {
            throw new IndexOutOfBoundsException("The list is empty");
        }
        Node current = head;
        for(int i = 0; i < index; i++)
        {
            if(current == null)
            {
                throw new IndexOutOfBoundsException("The index is too big");
            }
            current = current.next;
        }
        return current.data;
    }

    public boolean contains(T searchItem)
    {
        Node current = head;
        while(current != null)
        {
            if(current.data.equals(searchItem))
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean remove(T elementToRemove)
    {
        Node current = head;
        Node previous = head;
        while(current != null)
        {
            if(current.data.equals(elementToRemove))
            {
                numElements--;
                if(current == previous)
                {
                    head = head.next;
                }
                else
                {
                    previous.next = current.next;
                }
                previous.next = current.next;
                return(true);
            }
            else
            {
                previous = current;
                current = current.next;
            }
        }
        return(false);
    }

    public void printList()
    {
        //us this to "walk" or traverse the list
        Node current = head;
        while(current != null){
            System.out.print(current.data + ", ");
            current = current.next;
        }
    }

    public int size()
    {
        return numElements;
    }

    /* Linked list Node*/
    private class Node {
        T data;
        Node next;

        // Constructor to create a new node
        Node(T d) {
            data = d;
            next = null;
        }
    }
}