public interface LiteList<E> {

    void add(E element);

    void add(int index, E element);

    E get(int index);

    boolean remove(E element);

    void clear();

    void sort();

    int size();

}
