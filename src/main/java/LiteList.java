import java.util.Comparator;

/**
 * An ordered collection (also known as a sequence). The user of this
 * interface has precise control over where in the list each element
 * is inserted. The user can access elements by their integer index
 * (position in the list).<p>
 * <p>
 * The {@code LiteList} interface provides two methods for adding an
 * element: one to the end of the list, the other to the corresponding
 * index.<p>
 * The {@code LiteList} interface provides a method for getting a list
 * item by index<p>
 * The {@code LiteList} interface provides a method for removing an
 * item from a collection<p>
 * The {@code LiteList} interface provides methods for completely
 * clearing the list and getting the size of the list<p>
 * The {@code LiteList} interface provides a method for sorting the list
 *
 * @param <E> the type of elements in this list
 * @author Alexander Matyushin
 */
public interface LiteList<E> {

    void add(E element);

    void add(int index, E element);

    E get(int index);

    boolean remove(E element);

    void clear();

    void sort(Comparator<E> comparator);

    int size();

}
