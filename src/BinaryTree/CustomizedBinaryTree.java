package BinaryTree;

public class CustomizedBinaryTree implements TreeInterface {

    private Node tree;

    //method to find where to add a new node.
    //if node data is null, add new node to that position
    public Node addRecursive(Node current, int data) {
        if (current == null){
            return new Node(data);
        }
        //if node data is lower than current node move to left child
        if (data < current.data){
            current.left = addRecursive(current.left, data);
            //if node data is higher than current node move to right child
        }else if (data > current.data){
            current.right = addRecursive(current.right, data);
        }else {
            return current; //already exists
        }
        return current;
    }

    //method to add to the tree node using the addRecursive method
    @Override
    public void add(int data){
        tree = addRecursive(tree, data);
    }

    //method to find an element
    //first create a recursive method that traverse the tree
    public boolean containsNodeRecursive(Node current, int data){
        if (current == null) {
            return false;
        }
        if (data == current.data){
            return true;
        }
        return data < current.data
                ? containsNodeRecursive(current.left, data)
                : containsNodeRecursive(current.right, data);
    }
    //search for the data comparing to the current data node
    @Override
    public boolean containsNode(int data){
        return containsNodeRecursive(tree, data);
    }

    @Override
    public boolean isEmpty() {
        return tree == null;
    }
//method to get the size
    public int getSizeRecursive(Node current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }

    @Override
    public int getSize() {
        return getSizeRecursive(tree);
    }

    //method to find the element to be deleted which takes 3 cases
    public Node deleteRecursive(Node current, int data){
        if (current == null){
            return null;
        }

        if (data == current.data){
            //a node has no child
            if (current.left == null && current.right == null) {
                return null;
            }
            //a node has only 1 child
            if (current.right == null){
                return current.left;
            }
            if (current.left == null){
                return current.right;
            }
            //node has 2 children
            int smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (data < current.data){
            current.left = deleteRecursive(current.left, data);
        }else {
            current.right = deleteRecursive(current.right, data);
        }
        return current;
    }

    public int findSmallestValue(Node tree){
        return  tree.left == null ? tree.data : findSmallestValue(tree.left);
    }

    //method to delete from the tree using deleteRecursive method
    @Override
    public void delete(int data){
        tree = deleteRecursive(tree, data);
    }
//method to print
    private void print(int data){
        System.out.println(" " + data);
    }

    //Depth-First Search( In order)
    //first visit the left sub-tree then the root node
    //finally move to the right sub-tree
    public void traverseInOrder(Node tree){
        if (tree != null) {
            traverseInOrder(tree.left);
            traverseInOrder(tree.left);
            print(tree.data);
            traverseInOrder(tree.right);
        }
    }
    //method for Pre order
    //visit first the root node, then left sub-tree
    //finally the right sub-tree
    public void traversePreOrder(Node tree){
        if (tree != null) {
            print(tree.data);
            traversePreOrder(tree.left);
            traversePreOrder(tree.right);
        }
    }
    //method for post order
    //first visit lef sub-tree then the right sub-tree
    //finally the root node
    public void traversePostOrder(Node tree){
        if (tree != null){
            traversePostOrder(tree.left);
            traversePostOrder(tree.right);
            print(tree.data);
        }
    }


}
