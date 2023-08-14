import java.util.Arrays;

public class TraineeList<E> implements LiteList<E> {

    private static final int INIT_CAPACITY = 10;
    private static final double MAGNIFICATION_FACTOR = 1.5;
    private Object[] internalArray;
    private int size;

    public TraineeList() {
        internalArray = new Object[INIT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(E element) {
        if (internalArray.length == size) {
            expandInternalArray();
        }
        internalArray[size++] = element;
    }

    @Override
    public void add(int index, E element) {
        if (internalArray.length == size) {
            expandInternalArray();
        }
        moveToRightStartingFrom(index);
        internalArray[index] = element;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (E) internalArray[index];
    }

    @Override
    public boolean remove(E element) {
        for (int index = 0; index < size; index++) {
            if (internalArray[index].equals(element)) {
                moveToLeftStartingFrom(index);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        internalArray = new Object[INIT_CAPACITY];
        size = 0;
    }

    @Override
    public void sort() {

    }

    @Override
    public int size() {
        return size;
    }

    private void expandInternalArray() {
        int newLength = (int) (internalArray.length * MAGNIFICATION_FACTOR);
        internalArray = Arrays.copyOf(internalArray, newLength);
    }

    private void moveToRightStartingFrom(int index) {
        for (int i = size - 1; i >= index; i--) {
            internalArray[i + 1] = internalArray[i];
        }
    }

    private void moveToLeftStartingFrom(int index) {
        for (int i = index; i < size - 1; i++) {
            internalArray[i] = internalArray[i + 1];
        }
    }

}
