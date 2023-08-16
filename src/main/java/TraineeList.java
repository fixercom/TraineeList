import java.util.Arrays;
import java.util.Comparator;

/**
 * Resizable-array implementation of the {@code LiteList} interface.
 *
 * <p>Each {@code TraineeList} instance has an initial capacity of 10,
 * in case of lack of space, the capacity is automatically increased
 * according to the increase factor.
 *
 * @param <E> the type of elements in this list
 * @author Alexander Matyushin
 */
public class TraineeList<E> implements LiteList<E> {
    /**
     * Default initial capacity.
     */
    private static final int INIT_CAPACITY = 10;
    /**
     * The coefficient used to calculate the size of the internal
     * array in case there is not enough space to add a new element
     */
    private static final double MAGNIFICATION_FACTOR = 1.5;
    /**
     * The array buffer into which the elements of the TraineeList are
     * stored.
     */
    private Object[] internalArray;
    /**
     * The size of the TraineeList (the number of elements it contains).
     */
    private int size = 0;

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public TraineeList() {
        internalArray = new Object[INIT_CAPACITY];
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *                                  is negative or zero
     */
    public TraineeList(int initialCapacity) {
        if (initialCapacity > 0) {
            internalArray = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    /**
     * Appends the specified element to the end of this list
     *
     * @param element element to be appended to this list
     */
    @Override
    public void add(E element) {
        if (internalArray.length == size) {
            expandInternalArray();
        }
        internalArray[size++] = element;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, E element) {
        if (internalArray.length == size) {
            expandInternalArray();
        }
        moveToRightStartingFrom(index);
        internalArray[index] = element;
        size++;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= size()})
     */
    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (E) internalArray[index];
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present (optional operation).  If this list does not contain
     * the element, it is unchanged. Returns {@code true} if this list
     * contained the specified element (or equivalently, if this list changed
     * as a result of the call).
     *
     * @param element element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     */
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

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        size = 0;
    }

    /**
     * Sorts this list according to the order induced by the specified
     * {@link Comparator}. A quick sort algorithm is used.
     *
     * @param comparator the {@code Comparator} used to compare list elements.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void sort(Comparator<E> comparator) {
        QuickSort.sort((E[]) internalArray, 0, size - 1, comparator);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Trims the capacity of this {@code TraineeList} instance to be the
     * list's current size.  An application can use this operation to minimize
     * the storage of an {@code TraineeList} instance.
     */
    @Override
    public void trimCapacityToSize() {
        if (size < internalArray.length) {
            internalArray = Arrays.copyOf(internalArray, size);
        }
    }

    /**
     * Increases the capacity of this {@code TraineeList} instance, if
     * necessary, to ensure that it can hold at least the number of elements
     * specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    @Override
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > internalArray.length) {
            internalArray = Arrays.copyOf(internalArray, minCapacity);
        }
    }

    /**
     * Returns the current capacity value of the internal array
     *
     * @return the current capacity value of the internal array
     */
    @Override
    public int getCapacity() {
        return internalArray.length;
    }

    private void expandInternalArray() {
        int newLength = (int) Math.round(internalArray.length * MAGNIFICATION_FACTOR);
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
