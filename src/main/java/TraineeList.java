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

    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) internalArray[index];
    }

    @Override
    public boolean remove(E element) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int size() {
        return size;
    }

    private void expandInternalArray() {
        int length = (int) (internalArray.length * MAGNIFICATION_FACTOR);
        Object[] expandedArray = new Object[length];
        System.arraycopy(internalArray, 0, expandedArray, 0, size);
        internalArray = expandedArray;
    }

}
