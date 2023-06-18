package Revised.BinaryTree;

public class NodeNew<T extends Comparable<T>> {
    T data;
    NodeNew<T> left;
    NodeNew<T> right;

    public NodeNew(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
