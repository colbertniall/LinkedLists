import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simplified ArrayList class that stores Strings
 */
public class GenericArrayList<T> implements IList<T> {
    /**
     * This will hold our data - remember an ArrayList is nothing more than a managed array
     */
    private T[] buffer;

    /**
     * Index of next free location - will also help us to determine if the buffer is full
     */
    private int nextFreeLoc;

    /** This will change as buffer fills up and we allocate more and more storage space */
    private int currentCapacity;

    private static final int INITIAL_CAPACITY = 3;//nice and small so that we test it quickly
    /** Default Constructor */
    public GenericArrayList(){
        currentCapacity = INITIAL_CAPACITY;
        nextFreeLoc = 0;
        buffer = (T[]) new Object[currentCapacity];
    }


    /** Add to the end of the list.
     *
     * Each time you need to grow the array you should declare a temporary array
     * which is double the currentCapacity of buffer.
     *
     * Copy everything in buffer to tempArray
     *
     * Then update the buffer reference to refer to tempArray
     *
     * @param elem The data to be added to the end of the managed array
     */
    public void add(T elem) throws IndexOutOfBoundsException
    {
        growArrayIfNeeded(); //I've farmed this out to a private "helper" method


        buffer[nextFreeLoc++] = (T) elem;
    }


    /**
     * Add an element to a specified index. Make sure to avoid adding beyond the end of the
     * array (no gaps or bufferOverflows).
     * Also, remember to "grow" the managed array, if required. * @param index where to insert (ignore if greater than nextFreeLoc - otherwise you'll get gaps)
     * @param elem the data to insert
     */
    public void add(int index, T elem)
    {
        //if it's valid
        if (index <= nextFreeLoc)
        {
            //Make sure that we "grow" the array if needed.
            growArrayIfNeeded();

            //shuffle everything up from right to left //Note that this is a much easier mechanism to implement than trying to insert the new
            //element and then shuffle everything from left to right
            for (int i = nextFreeLoc; i > index; i--)
            {
                buffer[i] = buffer[i-1];
            }

            //Now everything has moved up we can simply insert the new element
            buffer[index] = (T) elem;
            //Obviously, we've added an extra element so we must update to reflect this
            nextFreeLoc++;
        }
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    /** Retrieve an element from the list
     *
     * @param index the location to be return
     * @return the data at buffer[index]
     */
    public T get(int index)
    {
        try {
            return buffer[index];
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Caught index out of bounds exception while trying to get an element at index " + index);
            return null;
        }
    }



    /**
     * Removes the first occurrence of an element from the array
     * It does this by "closing the gap" after/if it finds a matching element in the array.
     * @param elem the element to remove
     * @return
     */
    public boolean remove(T elem)
    {
        boolean matchFound = false;
        for (int index = 0; index < nextFreeLoc && !matchFound; index++)
        {
            if(buffer[index].equals(elem))
            {
                matchFound = true;

                //Close the gap - move elements 1 position to the left
                for( int i = index; i<nextFreeLoc; i++)
                {
                    buffer[i] = buffer[i+1];
                }

                nextFreeLoc--;

            }
        }
        return matchFound;
    }

    /**
     * Remove the element at the specified index.
     *
     * @param index the index of the element that should be removed
     * @return
     */
    public T remove(int index)
    {
        //if it's valid
        T returnedValue = null;
        if (index <= nextFreeLoc)
        {
            returnedValue = get(index);
            //Close the gap - move elements 1 position to the left
            for( int i = index; i<nextFreeLoc; i++)
            {
                if (nextFreeLoc - i == 1) {
                    buffer[i] = null;
                } else {
                    buffer[i] = buffer[i + 1];
                }
            }

            nextFreeLoc--;
        }
        return returnedValue;
    }


    /**
     * Searches through the array to see if a matching element is present
     * Note: We already use this mechanism for one of the remove() methods.
     * @param elem element to search the array for
     * @return whether the element was present in the list or not
     */
    public boolean contains(T elem)
    {
        boolean matchFound = false;
        for (int index = 0; index < nextFreeLoc && !matchFound; index++){
            if(buffer[index].equals(elem)){
                matchFound = true;
            }
        }
        return matchFound;
    }

    @Override
    public Iterator<T> iterator() {
        return new GenericArrayListIterator();
    }

    /**
     *
     * @return whether the list is empty or not
     */
    public boolean isEmpty()
    {
        return (nextFreeLoc == 0);
    }

    /**
     *
     * @return the size (i.e. the number of elements stored) in the list
     */
    public int size()
    {
        //System.out.println(buffer.length);
        return nextFreeLoc;
    }
    /**
     * Private helper method to check if the currently allocated space is full.
     * If it is then it will allocate a bigger array, copy the contents, and set our
     * instance field (buffer) to refer to the newly allocated space.
     */
    private void growArrayIfNeeded()
    {
        if(nextFreeLoc == currentCapacity){
            //Allocate double the space - that will keep us going for a while
            String[] tempArr = new String[buffer.length * 2];
            currentCapacity *= 2;
            //copy from the old space into the new
            for(int i = 0; i < buffer.length; i++){
                tempArr[i] = (String) buffer[i];
            }
            //Now, update so that our managed array points at the newly created array
            buffer = (T[]) tempArr;
        }
    }



    @Override
    public String toString()
    {
        String data = "";
        for(int i = 0; i < nextFreeLoc; i++)
        {
            data += " " +buffer[i] + ",";
        }

        return "MyStringArrayList[" + data + " ]";
    }


    //This is an inner-class of the GenericArrayList class
    class GenericArrayListIterator implements Iterator<T> {
        private int cursor = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return cursor < nextFreeLoc;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            if (cursor == nextFreeLoc) {
                throw new NoSuchElementException();
            }
            return buffer[cursor++];
        }

        @Override
        //You do not have to provide functionality for the remove() method
        //We already have (non-iterator) mechanism for removing elements
        public void remove() {
            throw new UnsupportedOperationException("not supported yet");
        }
    }
}