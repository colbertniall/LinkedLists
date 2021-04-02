import java.util.Iterator;

public class GenericLinkedList<T> implements IList<T>, Iterable<T> {
    Node head; // head of list
    Node tail; // end of list

    int numElements = 0;

    public void addToStart(T val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        numElements++;
    }

    public void add(T elem) {
        Node newNode = new Node(elem);
        Node current = head;
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
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

    //Does not work with index set to 0
    @Override
    public void add(int index, T element) {
        Node newNode = new Node(element);
        Node pointNode = new Node(newNode.data);

        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            pointNode.next = head;
            Node trackNode = pointNode;
            for (int i = 0; i < index; ++i) {
                trackNode = trackNode.next;
            }
            newNode.data = element;
            newNode.next = trackNode.next;
            trackNode.next = newNode;
        }
    }

    @Override
    public T set(int index, T element) {
        Node newNode = new Node(element);


        return null;
    }

    public T get(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException("The list is empty");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("The index is too big");
            }
            current = current.next;
        }
        return current.data;
    }

    public boolean contains(T searchItem) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(searchItem)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public boolean remove(T elementToRemove) {
        Node current = head;
        Node previous = head;

        while (current != null) {
            if (current.data.equals(elementToRemove)) {
                numElements--;
                if (current == previous) {
                    head = head.next;
                } else {
                    previous.next = current.next;
                }
                previous.next = current.next;
                return (true);
            } else {
                previous = current;
                current = current.next;
            }
        }
        return (false);
    }

    @Override
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public void printList() {
        //us this to "walk" or traverse the list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
    }

    public int size() {
        return numElements;
    }

    //doesn't work
    @Override
    public T remove(int index) {
        return null;
    }
//        Node current = head;
//        Node previous = head;
//
//        if (isEmpty()) {
//            throw new IndexOutOfBoundsException("The list is empty");
//        } else if (index > size()) {
//            throw new IndexOutOfBoundsException("The index is greater than list size");
//        } else if (index <= size()) {
//            while (head != null) {
//
//            }
//        }
//        System.out.println("");
//    }
//}

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

    private class GenericLinkedListIterator implements Iterator<T>
    {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }
}