import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class TraineeListTest {

    private LiteList<Integer> integerTraineeList;
    private LiteList<String> stringTraineeList;

    @BeforeEach
    void init() {
        integerTraineeList = new TraineeList<>();
        stringTraineeList = new TraineeList<>();
    }

    @Test
    @DisplayName("Add Integer elements")
    void testAddWhenIntegerElements() {
        IntStream.range(1, 12).forEach(integerTraineeList::add);

        assertAll(
                () -> assertEquals(11, integerTraineeList.size(),
                        "List must contain 11 elements"),
                () -> assertEquals(1, integerTraineeList.get(0),
                        "Element with index 0 must be equal 1"),
                () -> assertEquals(11, integerTraineeList.get(10),
                        "Element with index 10 must be equal 11")
        );
    }

    @Test()
    @DisplayName("Add String elements")
    void testAddWhenStringElements() {
        IntStream.range(1, 12)
                .mapToObj(n -> "line " + n)
                .forEach(stringTraineeList::add);

        assertAll(
                () -> assertEquals(11, stringTraineeList.size(),
                        "List must contain 11 elements"),
                () -> assertEquals("line 1", stringTraineeList.get(0),
                        "Element with index 0 must be equal line 1"),
                () -> assertEquals("line 11", stringTraineeList.get(10),
                        "Element with index 10 must be equal line 11")
        );

    }

    @Test
    @DisplayName("Add element by index")
    void testAddElementByIndex() {
        IntStream.range(1, 11).forEach(integerTraineeList::add);
        integerTraineeList.add(5, 999);

        assertAll(
                () -> assertEquals(11, integerTraineeList.size(),
                        "List must contain 11 elements"),
                () -> assertEquals(999, integerTraineeList.get(5),
                        "Element with index 5 must be equal 999"),
                () -> assertEquals(6, integerTraineeList.get(6),
                        "Element with index 6 must be equal 6"),
                () -> assertEquals(10, integerTraineeList.get(10),
                        "Element with index 10 must be equal 10"),
                () -> assertEquals(5, integerTraineeList.get(4),
                        "Element with index 4 must be equal 5")
        );
    }

    @Test
    @DisplayName("Get element by index")
    void testGetElementByIndex() {
        IntStream.range(1, 6).forEach(integerTraineeList::add);

        assertAll(
                () -> assertEquals(5, integerTraineeList.get(4), "Element with index 4 must be 5"),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> integerTraineeList.get(5),
                        "method integerTraineeList.get() with index 5 must throw IndexOutOfBoundsException")
        );
    }

    @Test
    @DisplayName("Remove element")
    void remove() {
        IntStream.range(1, 6).forEach(integerTraineeList::add);

        assertEquals(5, integerTraineeList.size(), "List must contain 5 elements");

        boolean removeResult1 = integerTraineeList.remove(3);
        boolean removeResult2 = integerTraineeList.remove(999);

        assertAll(
                () -> assertTrue(removeResult1, "Result of removing element 3 must be true"),
                () -> assertFalse(removeResult2, "Result of removing element 999 must be false"),
                () -> assertEquals(4, integerTraineeList.size(),
                        "List must contain 4 elements"),
                () -> assertEquals(4, integerTraineeList.get(2),
                        "Element with index 2 must be equal 4"),
                () -> assertEquals(2, integerTraineeList.get(1),
                        "Element with index 1 must be equal 2")
        );
    }

    @Test
    @DisplayName("Clear list")
    void clear() {
        IntStream.range(1, 6).forEach(integerTraineeList::add);

        assertEquals(5, integerTraineeList.size(), "List must contain 5 elements");

        integerTraineeList.clear();

        assertAll(
                () -> assertEquals(0, integerTraineeList.size(), "List must contain 0 elements"),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> integerTraineeList.get(0),
                        "method integerTraineeList.get() with index 0 must throw IndexOutOfBoundsException")
        );
    }

    @Test
    @DisplayName("Sorting elements")
    void sort() {
        stringTraineeList.add("short");
        stringTraineeList.add("add");
        stringTraineeList.add("contribution");
        stringTraineeList.add("deserve");
        stringTraineeList.sort(Comparator.comparingInt(String::length));

        assertAll(
                () -> assertEquals("add", stringTraineeList.get(0),
                        "Element with index 0 must be equal add"),
                () -> assertEquals("short", stringTraineeList.get(1),
                        "Element with index 1 must be equal short"),
                () -> assertEquals("deserve", stringTraineeList.get(2),
                        "Element with index 2 must be equal deserve"),
                () -> assertEquals("contribution", stringTraineeList.get(3),
                        "Element with index 3 must be equal contribution")
        );
    }

    @Test
    @DisplayName("Get size list")
    void testSize() {
        IntStream.range(1, 101).forEach(integerTraineeList::add);

        assertEquals(100, integerTraineeList.size(), "integerTraineeList must contain 100 elements");
    }

    @Test
    @DisplayName("Capacity constructor")
    void testCapacityConstructor() {
        LiteList<Integer> liteList = new TraineeList<>(100);

        assertEquals(100, liteList.getCapacity(), "The capacity must be equal 100");
    }

    @Test
    @DisplayName("Trim capacity to size")
    void testTrimCapacityToSize() {
        IntStream.range(1, 6).forEach(integerTraineeList::add);

        assertAll(
                () -> assertEquals(5, integerTraineeList.size(),
                        "List must contain 5 elements"),
                () -> assertEquals(10, integerTraineeList.getCapacity(),
                        "Capacity of list must be equal 10")
        );

        integerTraineeList.trimCapacityToSize();

        assertEquals(5, integerTraineeList.getCapacity(), "Capacity of the list must be equal 5");
    }

    @Test
    @DisplayName("Ensure capacity")
    void testEnsureCapacity() {

        assertEquals(10, integerTraineeList.getCapacity(), "Capacity of list must be equal 10");

        integerTraineeList.ensureCapacity(15);

        assertEquals(15, integerTraineeList.getCapacity(), "Capacity of list must be equal 15");
    }
}