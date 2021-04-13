import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class GenericCollections {
    /**
     * Sort based on natural ordering (as defined by class's compareTo method)
     *
     * @param listToSort
     */
    public static <T extends Comparable<T>> void sort(IList<T> listToSort) {
        for (int i = 0; i < listToSort.size(); i++) //number of passes
        {
            //keeps track of positions per pass
            for (int j = 0; j < (listToSort.size() - 1 - i); j++) {
                //if left value is greater than right value
                if (listToSort.get(j).compareTo(listToSort.get(j + 1)) > 0) {
                    //swap values
                    T temp = listToSort.get(j);
                    listToSort.set(j, listToSort.get(j + 1));
                    listToSort.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Returns the maximum element of the given collection, according to the natural ordering
     * of its elements.
     *
     * @param list the collection whose maximum element is to be determined
     * @return the maximum element of the given collection, according to the natural ordering
     * of its elements.
     * Throws:
     * NoSuchElementException - if the collection is empty.
     */
    public static <T extends Comparable<T>> T max(IList<T> list) {
        if(!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) //number of passes
            {
                //keeps track of positions per pass
                for (int j = 0; j < (list.size() - 1 - i); j++) {
                    //if left value is greater than right value
                    if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                        //swap values
                        T temp = list.get(j);
                        return temp;
                    }
                }
            }
        }
        else
        {
            throw new NoSuchElementException("The collection is empty");
        }
        return null;
    }

    /**
     * @param list     the list to be rotated.
     * @param distance the distance to rotate the list. There are no constraints on this
     *                 value; it may be zero, negative, or greater than list.size().
     * @param <T>
     */
    public static <T extends Comparable<T>> void rotate(IList<T> list, int distance) {
        if(distance == 0 || distance == list.size())
        {
            return;
        }
        else if (distance < 0)
        {

        }
        else
        {
            distance = distance % list.size();

        }

    }
}