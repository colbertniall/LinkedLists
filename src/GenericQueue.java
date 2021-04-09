import java.util.NoSuchElementException;

public class GenericQueue <T> implements IQueue <T>{
    private IList list;

    public GenericQueue(IList list) {
        this.list = list;
    }

    @Override
    public void enqueue(T element) {
        list.add(element);
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
        else {
            return (T) list.get(0);
        }
    }

    @Override
    public boolean empty() {
        if(list.isEmpty())
        {
            return true;
        }
        return false;
    }

//    @Override
//    public String toString() {
//        return "GenericQueue{} " + list.getList();
//    }
}
