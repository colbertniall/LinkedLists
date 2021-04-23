import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.Iterator;

public class GenericStack<T> implements IStack<T>{
    private IList list;
    T lastAdded;

    public GenericStack(IList list) {
        this.list = list;
    }

    public GenericStack() {

    }


    @Override
    public void push(T element) {
        list.add(0, element);
        lastAdded = element;
    }

    @Override
    public T pop() {
        if(list.isEmpty())
        {
            return null;
        }
        else {
            return (T) list.remove(list.size() - 1);
        }
    }

    @Override
    public T peek() {
        if(list!=null)
        {
            return lastAdded;
        }
        return null;
    }

    @Override
    public boolean empty() {
        if(list.size() == 0)
        {
            System.out.println("The List is empty");
            return true;
        }
        else System.out.println("There are elements in the list");
        return false;
    }

    class GenericStackIterator implements Iterator<T>
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

    @Override
    public String toString() {
        return "GenericStack elements = { " + list + "}";
    }
}