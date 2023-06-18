package Revised.BinaryTree;

public interface TreeInterfaceNew<T> {

    void add(T data);

    void delete(T data);

    boolean containsNode(T data);

    boolean isEmpty();

    int getSize();
}
