package Revised.BinaryTree;

import java.util.*;

public class CustomizedBinaryTreeNew<T extends Comparable<T>> implements TreeInterfaceNew<T> {

    private NodeNew<T> tree;
    public List<T> toArray = new ArrayList<T>();

    public NodeNew<T> getTree() {
        return tree;
    }

    public void setTree(NodeNew<T> tree) {
        this.tree = tree;
    }

    // Method to add a new node recursively
    public NodeNew<T> addRecursive(NodeNew<T> current, T data) {
        if (current == null) {
            return new NodeNew<T>(data);
        }
        if (data.compareTo(current.data) < 0) {
            current.left = addRecursive(current.left, data);
        } else if (data.compareTo(current.data) > 0) {
            current.right = addRecursive(current.right, data);
        } else {
            return current; // already exists
        }
        return current;
    }

    @Override
    public void add(T data) {
        tree = addRecursive(tree, data);
    }

    // Method to add a list of values to the tree node using the addRecursive method and Bubble sort
    public void addAll(T[] array) {
        for (T value : array) {
            add(value);
        }
    }


    public void addByLevel(List<T> values) {
        if (values.isEmpty()) {
            return;
        }

        Collections.sort(values);

        Queue<NodeNew<T>> queue = new LinkedList<NodeNew<T>>();
        int size = values.size();

        // Create the root node with the middle value
        NodeNew<T> root = new NodeNew<T>(values.get(size / 2));
        tree = root;
        queue.offer(root);

        int level = 1;
        int leftIndex = 0;
        int rightIndex = size - 1;

        // Fill the tree level by level
        while (!queue.isEmpty() && (leftIndex < rightIndex)) {
            int nodesAtLevel = (int) Math.pow(2, level);

            // Add nodes at the current level
            for (int i = 0; i < nodesAtLevel; i++) {
                NodeNew<T> parent = queue.poll();

                // Create left child if available
                if (leftIndex < rightIndex) {
                    NodeNew<T> leftChild = new NodeNew<T>(values.get(++leftIndex));
                    parent.left = leftChild;
                    queue.offer(leftChild);
                }

                // Create right child if available
                if (leftIndex < rightIndex) {
                    NodeNew<T> rightChild = new NodeNew<T>(values.get(++leftIndex));
                    parent.right = rightChild;
                    queue.offer(rightChild);
                }
            }

            level++;
        }
    }

    // Return level of value you're looking for
    public int getLevel(T value) {
        return getLevelRecursive(tree, value, 0);
    }

    private int getLevelRecursive(NodeNew<T> current, T value, int level) {
        if (current == null) {
            return -1; // Value not found in the tree
        }

        if (value.compareTo(current.data) == 0) {
            return level; // Value found at current level
        }

        int leftLevel = getLevelRecursive(current.left, value, level + 1);
        if (leftLevel != -1) {
            return leftLevel; // Value found in the left subtree
        }

        int rightLevel = getLevelRecursive(current.right, value, level + 1);
        if (rightLevel != -1) {
            return rightLevel; // Value found in the right subtree
        }

        return -1; // Value not found in the tree
    }


    // Method to find an element recursively
    public boolean containsNodeRecursive(NodeNew<T> current, T data) {
        if (current == null) {
            return false;
        }
        if (data.compareTo(current.data) == 0) {
            return true;
        }
        return data.compareTo(current.data) < 0
            ? containsNodeRecursive(current.left, data)
            : containsNodeRecursive(current.right, data);
    }

    @Override
    public boolean containsNode(T data) {
        return containsNodeRecursive(tree, data);
    }

    // Method to convert the tree to an array based on the given type
    public List<T> bstToArray(int type) {
        toArray.clear();
        if (type == 1) {
            traverseInOrder(tree);
        } else if (type == 2) {
            traversePreOrder(tree);
        } else if (type == 3) {
            traversePostOrder(tree);
        }
        return toArray;
    }

    // Depth-First Search (In-order traversal)
    public void traverseInOrder(NodeNew<T> tree) {
        if (tree != null) {
            traverseInOrder(tree.left);
            toArray.add(tree.data);
            traverseInOrder(tree.right);
        }
    }

    // Method for Pre-order traversal
    public void traversePreOrder(NodeNew<T> tree) {
        if (tree != null) {
            toArray.add(tree.data);
            traversePreOrder(tree.left);
            traversePreOrder(tree.right);
        }
    }

    // Method for Post-order traversal
    public void traversePostOrder(NodeNew<T> tree) {
        if (tree != null) {
            traversePostOrder(tree.left);
            traversePostOrder(tree.right);
            toArray.add(tree.data);
        }
    }

    @Override
    public boolean isEmpty() {
        return tree == null;
    }

    // Method to get the size of the tree recursively
    public int getSizeRecursive(NodeNew<T> current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }

    @Override
    public int getSize() {
        return getSizeRecursive(tree);
    }

    // Method to find the smallest value in the tree
    public T findSmallestValue(NodeNew<T> tree) {
        return tree.left == null ? tree.data : findSmallestValue(tree.left);
    }

    // Method to delete a node from the tree recursively
    public NodeNew<T> deleteRecursive(NodeNew<T> current, T data) {
        if (current == null) {
            return null;
        }

        if (data.compareTo(current.data) == 0) {
            // A node has no child
            if (current.left == null && current.right == null) {
                return null;
            }
            // A node has only 1 child
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            // Node has 2 children
            T smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }

        if (data.compareTo(current.data) < 0) {
            current.left = deleteRecursive(current.left, data);
        } else {
            current.right = deleteRecursive(current.right, data);
        }
        return current;
    }

    @Override
    public void delete(T data) {
        tree = deleteRecursive(tree, data);
    }
}
