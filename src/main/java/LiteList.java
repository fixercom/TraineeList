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
    /**
     * Appends the specified element to the end of this list
     *
     * @param element element to be appended to this list
     */
    void add(E element);

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    void add(int index, E element);

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= size()})
     */
    E get(int index);

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
    boolean remove(E element);

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    void clear();

    /**
     * Sorts this list according to the order induced by the specified
     * {@link Comparator}.
     *
     * @param comparator the {@code Comparator} used to compare list elements.
     */

    void sort(Comparator<E> comparator);

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    int size();

}
