import org.junit.jupiter.api.BeforeEach;
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

    @Test
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
    void testSize() {
        IntStream.range(1, 101).forEach(integerTraineeList::add);
        assertEquals(100, integerTraineeList.size(), "integerTraineeList must contain 100 elements");
    }
}