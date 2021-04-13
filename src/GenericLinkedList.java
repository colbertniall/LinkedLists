import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericLinkedList<T> implements IList<T> {

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
    }

    @Override
    public void add(int index, T element) {
        Node newNode = new Node(element);
        Node pointNode = new Node(newNode.data);

        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            if (index == 0) {
                addToStart(element);
                return;
            }
            pointNode.next = head;
            Node trackNode = pointNode;
            for (int i = 0; i < index; ++i) {
                trackNode = trackNode.next;
            }
            newNode.data = element;
            newNode.next = trackNode.next;
            trackNode.next = newNode;
        }
        numElements++;
    }

    @Override
    public T set(int index, T element) {
        T oldNodeData = get(index);
        remove(oldNodeData);
        add(index, element);
        return oldNodeData;
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
        return (T) current.data;
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
        return new GenericLinkedListIterator();
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

    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer();
        Node current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            buff.append(current.data);
            buff.append(", ");
            current = current.next;
        }
        return buff.toString();
    }

    public int size() {
        return numElements;
    }

    @Override
    public T remove(int index) {
        if (isEmpty()) {
            return null;
        } else if (index > size()) {
            throw new IndexOutOfBoundsException("The index is greater than list size");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException("Index can't be less than 0, dumbass");
        } else  {
            T removeData = get(index);
            remove(removeData);
            return removeData;
        }
    }
//}

    /* Linked list Node*/
    private class Node <T> {
        T data;
        Node next;

        // Constructor to create a new node
        Node(T d) {
            data = d;
            next = null;
        }

        public Node getNext() {
            return next;
        }

        public T getData() {
            return data;
        }
    }

    class GenericLinkedListIterator implements Iterator<T> {

        private Node<T> current = null;

        @Override
        public boolean hasNext() {
            if(current == null && head != null)
            {
                return true;
            }
            else if(current != null)
            {
                return current.getNext() != null;
            }
            return false;
        }

        @Override
        public T next() {
            if(current == null && head != null)
            {
                current = head;
                return (T) head.getData();
            }
            else if(current != null)
            {
                current = current.getNext();
                return current.getData();
            }
            throw  new NoSuchElementException();
        }

//        @Override
//        public String toString() {
//            return "GenericLinkedListIterator{" +
//                    "current=" + current +
//                    '}';
//        }
    }
}