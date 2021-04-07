import java.util.EmptyStackException;

public class GenericStack<T> implements IStack<T>{
    private GenericArrayList<T> genArrList;
    private GenericLinkedList<T> genLinkedList;
    T lastAdded;

    public GenericStack()
    {
        genArrList = new GenericArrayList<T>();
    }


    @Override
    public void push(T element) {
        genArrList.add(element);
        lastAdded = element;
    }

    @Override
    public T pop() {
        if(genArrList.isEmpty())
        {
            return null;
        }
        else
        return genArrList.remove(genArrList.size() - 1);
    }

    @Override
    public T peek() {
        if(genArrList!=null)
        {
            return lastAdded;
        }
        return null;
    }

    @Override
    public boolean empty() {
        if(genArrList.size() == 0)
        {
            System.out.println("The List is empty");
            return true;
        }
        else System.out.println("There are elements in the list");
        return false;
    }

    @Override
    public String toString() {
        return "GenericStack elements = {" + genArrList + " }";
    }
}
