import java.util.Stack;

public class listTester {

    public static void main(String[] args) {

        GenericLinkedList list = new GenericLinkedList();
        GenericArrayList arrayList = new GenericArrayList();






        arrayList.add(new Person(20, "Hegarty", "Dermot"));
        arrayList.add(new Person(23,"Minchin", "Tim"));
        arrayList.add(new Person(19, "DiCamillo", "Kate"));


//        for(Object currElement: arrayList)
//        {
//            System.out.println(currElement);
//        }




//        list.add("abc");
//        list.add(1);
//        list.add("a");
//        list.add("jkl");
//        list.add("Niall");
//
//        list.printList();
//        System.out.println("\n");
//        list.add(2,"This is a new element");
//        list.printList();
//
//        System.out.println("\n");
//        list.add(0, "You better fucking work!!!!");
//        list.printList();
//
//        System.out.println("\n");
//        list.set(1, "My lecturer is really nice");
//        list.printList();
//
//        System.out.println("\n");
//        list.remove(6);
//        list.printList();
//
//        System.out.println("******WWWWWWWWWWWWWW**********");
//
//        GenericArrayList<Integer> aList = new GenericArrayList<>();
//        aList.add(5); aList.add(2); aList.add(3);
//        for(Integer currElement: aList) {
//            System.out.println(currElement + " ");
//        }
//
//        GenericLinkedList<String> bList = new GenericLinkedList<>();
//        bList.add("Niall"); bList.add("Eva"); bList.add("Dan");
//        for(String currElement: bList) {
//            System.out.println(currElement + " ");
//        }
//
//
//        //TestingStack
//        GenericStack genericStack = new GenericStack(new GenericArrayList());
//        genericStack.empty();
//        genericStack.push("November Rain");
//        System.out.println(genericStack.peek());
//        genericStack.push("Sweet Child");
//        System.out.println(genericStack.peek());
//        genericStack.push("Welcome to the Jungle");
//        System.out.println(genericStack.peek());
//
//        genericStack.empty();
//
//        //genericStack.pop();
//        System.out.println("**********");
//        System.out.println(genericStack.toString());

        //Testing Queue
        GenericQueue genQueue = new GenericQueue(new GenericArrayList());
        genQueue.enqueue(1);
        genQueue.enqueue("Hello");
        genQueue.enqueue(3);
        System.out.println(genQueue.toString());
//        genQueue.dequeue();
        System.out.println(genQueue.toString());
        //Doesn't take beyond 3 elements
        genQueue.enqueue(4);
        System.out.println(genQueue.toString());

//
//        System.out.println(s);
//        s.pop();
//        s.pop();
//        System.out.println(s);


//        s.empty();
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