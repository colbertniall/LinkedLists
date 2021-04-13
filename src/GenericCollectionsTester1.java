public class GenericCollectionsTester1 {
    public static void main(String[] args) {
        GenericArrayList<Person> myList = new GenericArrayList<>();
        myList.add(new Person(20, "Hegarty", "Dermot"));
        myList.add(new Person(23,"Minchin", "Tim"));
        myList.add(new Person(19, "DiCamillo", "Kate"));
        printList("Original List:", myList);
        //This method uses compareTo() to do its job
        GenericCollections.sort(myList);
        printList("\nSorted List based on natural ordering (age):", myList);
        GenericCollections.rotate(myList, 2);
        printList("\nList rotated by two:", myList);
        System.out.println("\nThe oldest person is " + GenericCollections.max(myList));
    }
    public static void printList(String message, GenericArrayList<Person> listToPrint)
    {
        System.out.println(message);
        for (Person currPerson: listToPrint)
        {
            System.out.println(currPerson.toString());
        }
    }
}