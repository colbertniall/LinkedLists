import java.util.NoSuchElementException;

public class GenericQueue <T> implements IQueue <T>{
    private GenericLinkedList<T> genLinkedList = new GenericLinkedList<>();
    private GenericArrayList<T> genArrayList = new GenericArrayList<>();

//    public GenericQueue(GenericLinkedList<T> genLinkedList) {
//        this.genLinkedList = genLinkedList;
//    }
//
//    public GenericQueue(GenericArrayList<T> genArrayList) {
//        this.genArrayList = genArrayList;
//    }
//
//

    @Override
    public void enqueue(T element) {
            genLinkedList.addToStart((T) element);
    }



    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public T first() {
        if(empty())
        {
            throw new NoSuchElementException("The list is empty");
        }
        else return (T) genLinkedList.head;
    }

    @Override
    public boolean empty() {
        if(genLinkedList.isEmpty())
        {
            return true;
        }
        return false;
    }

//    @Override
//    public String toString() {
//        return "GenericQueue{}" + genLinkedList.printList();
//    }
}
