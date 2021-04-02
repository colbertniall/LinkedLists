public class listTester {

    public static void main(String[] args) {

        GenericLinkedList list = new GenericLinkedList();
        GenericArrayList arrayList = new GenericArrayList();

//        arrayList.add(new Person(20, "Hegarty", "Dermot"));
//        arrayList.add(new Person(23,"Minchin", "Tim"));
//        arrayList.add(new Person(19, "DiCamillo", "Kate"));


//        for(Object currElement: arrayList)
//        {
//            System.out.println(currElement);
//        }




        list.add("abc");
        list.add(1);
        list.add("a");
        list.add("jkl");
        list.add("Niall");

        list.printList();
        System.out.println("\n");
        list.add(2,"This is a new element");
        list.printList();

        System.out.println("\n");
        list.add(0, "You better fucking work!!!!");
        list.printList();

        System.out.println("\n");
        list.set(1, "My lecturer is really nice");
        list.printList();

        System.out.println("\n");
        list.remove(6);
        list.printList();


//        list.add("abc");
//        list.add(1);
//        list.add("a");
//        list.add("jkl");
//        list.add("Niall");

//        list.add()
//
//        if(!list.isEmpty())
//        {
//            System.out.println("List will print if the list is not empty");
//            list.printList();
//            System.out.println("\n**************");
//        }
//        else
//            System.out.println("The list is empty so there is nothing to print");
//
//        System.out.println(list.remove(2));
//        System.out.println("-------------");
//        list.printList();
//
//        //list.add(2, "New info");
//
//        System.out.println(list.get(1));
//
//        if(list.contains(1))
//        {
//            System.out.println("\nYes");
//        }
//        else {
//            System.out.println("No");
//        }
//
////        if(list.remove(1))
////        {
////            System.out.println("Remove Success");
////        }
////        else
////        {
////            System.out.println("Remove Failed");
////        }
//        System.out.println("New List");
//        list.printList();
//        //System.out.println("The 3rd element is " + list.get(6));
//
//

    }
}
