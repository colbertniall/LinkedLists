import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericLinkedListTest {

    GenericLinkedList testLinkedList;

    @BeforeEach
    public void setUp()
    {
        testLinkedList = new GenericLinkedList<String>();
        testLinkedList.add("element one");
        testLinkedList.add("element two");
    }

    @Test
    void addToStart() {
        testLinkedList.addToStart("This is a new element");
        assertEquals("This is a new element", testLinkedList.get(0));
    }

    @Test
    void add() {
        testLinkedList.addToStart("This should be the new last element");
        assertEquals("This should be the new last element", testLinkedList.get(0));
    }

    @Test
    void testAdd() {
        testLinkedList.add(1, "Hello");
        assertEquals("Hello", testLinkedList.get(1));
        assertEquals("element two", testLinkedList.get(2));
    }

    @Test
    void set() {
        testLinkedList.set(1, "This should replace the first element");
        assertEquals(2, testLinkedList.size());
        assertEquals("This should replace the first element", testLinkedList.get(1));
    }

    @Test
    void get() {
        assertEquals("element two", testLinkedList.get(1));
    }

    @Test
    void contains() {
        assertEquals(true, testLinkedList.contains("element two"));
    }

    @Test
    void remove() {

    }

    @Test
    void isEmpty() {
        assertEquals(false, testLinkedList.isEmpty());
        testLinkedList.remove(1);
        testLinkedList.remove(0);
        assertEquals(true, testLinkedList.isEmpty());
    }

    @Test
    void printList() {
    }

    @Test
    void size() {
        assertEquals(2, testLinkedList.size());
        testLinkedList.add("Another element");
        assertEquals(3, testLinkedList.size());
        testLinkedList.add("And a fourth");
        assertEquals(4, testLinkedList.size());
        testLinkedList.remove(3);
        assertEquals(3, testLinkedList.size());
    }

    @Test
    void testRemove() {
        assertEquals("element one", testLinkedList.get(0));
         testLinkedList.remove("element one");
         if(!testLinkedList.contains("element one"))
         {
             assertEquals(1, testLinkedList.size());
         }
    }
}