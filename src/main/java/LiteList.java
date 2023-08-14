import java.util.Comparator;

public interface LiteList<E> {

    void add(E element);

    void add(int index, E element);

    E get(int index);

    boolean remove(E element);

    void clear();

    void sort(Comparator<E> comparator);

    int size();

}
