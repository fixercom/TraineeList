import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TraineeListTest {

    private TraineeList<Integer> integerTraineeList;
    private TraineeList<String> stringTraineeList;

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
        assertEquals(5, integerTraineeList.get(4), "Element with index 4 must be 5");
    }

    @Test
    void remove() {
    }

    @Test
    void clear() {
    }

    @Test
    void sort() {
    }

    @Test
    @DisplayName("Get size of TraineeList")
    void testSize() {
        IntStream.range(1, 101).forEach(integerTraineeList::add);
        assertEquals(100, integerTraineeList.size(), "integerTraineeList must contain 100 elements");
    }
}