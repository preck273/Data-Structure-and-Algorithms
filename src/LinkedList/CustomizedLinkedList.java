package LinkedList;

public interface CustomizedLinkedList<T> {

    int size();

    void addFirst(T data);

    void addLast(T data);

    T get(int index);

    T getFirst();

    T getLast();

    void removeFirst();

    void removeLast();

    void removeValue(T data);

    void clear();



}
