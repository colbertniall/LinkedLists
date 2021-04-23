import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericArrayListTest {

    GenericArrayList<String> testList;

    @BeforeEach
    public void setUp()
    {
        testList = new GenericArrayList<String>();
        testList.add("niall");
        testList.add("eva");
    }

    @Test
    void add() {
        testList.add("whatsup");
        assertEquals("whatsup", testList.get(2));
    }



    @Test
    void testAdd() {
        testList.add(0, "New element");
        assertEquals("New element", testList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> testList.add(10, "New element"), "Index is out of bounds Niall");
    }

    @Test
    void test_addUntilArrayGrows() {
        assertEquals(2, testList.size());
        testList.add("Dan"); // 3
        assertEquals(3, testList.size());
        // Grows on this one
        testList.add("Coff"); // 4
        testList.add("Hynes"); //5
        testList.add("Mckenna"); //6
        assertEquals(6, testList.size());
        testList.add("Ro"); // 7
        System.out.println(testList.size()); // replace with asserts
        assertEquals(7, testList.size());
    }

    @Test
    void get() {
        assertEquals("niall", testList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> testList.get(7), "Index is out of bounds Niall");
    }

    @Test
    void remove() {
        assertEquals(testList.size(), 2);
        testList.remove(1);
        assertEquals(testList.size(), 1);
        assertThrows(IndexOutOfBoundsException.class, () -> testList.get(7), "Index is out of bounds in remove method");
    }

}