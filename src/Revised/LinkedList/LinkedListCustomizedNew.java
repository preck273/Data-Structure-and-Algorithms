package Revised.LinkedList;

import Revised.arrayListNew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LinkedListCustomizedNew<T extends Comparable<T>> implements CustomizedLinkedListNew<T> {

    private int size;
    private Node<T> head;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void addFirst(T data) {
        Node<T> node = new Node<T>(data);

        if (this.head == null) {
            this.head = node;
            this.size++;
            return;
        }

        node.next = this.head;
        this.head = node;
        this.size++;
    }

    @Override
    public void addLast(T data) {
        Node<T> node = new Node<T>(data);

        if (this.head == null) {
            this.head = node;
            this.size++;
            return;
        }

        Node<T> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = node;
        this.size++;
    }

    @Override
    public T get(int index) {
        if (this.size == 0 || index > this.size - 1) {
            return null;
        }

        if (index == 0) {
            return this.head.data;
        }

        int currentIndex = 0;
        Node<T> currentNode = this.head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            if (++currentIndex == index) {
                return currentNode.data;
            }
        }
        return null;
    }

    @Override
    public T getFirst() {
        return this.head.data;
    }

    @Override
    public T getLast() {
        Node<T> currentNode = this.head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            if (currentNode.next == null) {
                return currentNode.data;
            }
        }
        return null;
    }

    @Override
    public void removeFirst() {
        if (this.size == 0) {
            return;
        }

        Node<T> currentHead = this.head;
        this.head = this.head.next;
        currentHead.data = null;
        currentHead.next = null;
        this.size--;
    }

    public void addAll(T[] values) {
        for (T value : values) {
            addLast(value);
        }
    }

    @Override
    public void removeLast() {
        if (this.size == 0) {
            return;
        }

        Node<T> currentNode = this.head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            if (currentNode.next.next == null) {
                currentNode.next.data = null;
                currentNode.next = null;
                this.size--;
                return;
            }
        }
    }

    @Override
    public void removeValue(T data) {
        if (this.head == null) {
            return;
        }

        if (this.head.data.equals(data)) {
            this.head = this.head.next;
            this.size--;
            return;
        }

        Node<T> currentNode = this.head;

        while (currentNode.next != null) {
            if (currentNode.next.data.equals(data)) {
                currentNode.next = currentNode.next.next;
                this.size--;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    @Override
    public void clear() {
        while (this.size != 0) {
            this.removeFirst();
        }
    }

    public int getLength() {
        int length = 1;
        Node<T> currentNode = this.head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            length++;
        }

        return length;
    }

    public List<T> convertToArray() {
        List<T> arr = new ArrayList<T>(getLength());

        Node<T> currentNode = this.head;
        int length = this.getLength();
        while (length > 0) {
            arr.add(currentNode.data);
            currentNode = currentNode.next;
            length--;
        }
        return arr;
    }

    public boolean contains(T value) {
        T[] array = (T[]) new Comparable[this.getLength()];
        array = this.convertToArray().toArray(array);
        arrayListNew<T> list = new arrayListNew<T>(this.getLength());

        list.addAll(array);

        return list.contains(value);
    }

    public T[] toArrayList() {
        T[] array = (T[]) new Comparable[this.getLength()];
        array = this.convertToArray().toArray(array);

        arrayListNew<T> list = new arrayListNew<T>(this.getLength());
        list.addAll(array);

        return (T[]) list.cleanArrayList();
    }

    public Iterator<T> descendingIterator() {
        T[] array = (T[]) new Comparable[this.getLength()];
        array = this.convertToArray().toArray(array);

        arrayListNew<T> list = new arrayListNew<T>(this.getLength());
        list.addAll(array);

        T[] result = list.descendingInsertionSort();

        return Arrays.asList(result).iterator();
    }


    public void sort() {
        LinkedListCustomizedNew<T> sortedList = new LinkedListCustomizedNew<T>();

        Iterator<T> descendingIterator = descendingIterator();

        while (descendingIterator.hasNext()) {
            sortedList.addFirst(descendingIterator.next());
        }

        this.head = sortedList.head;
        this.size = sortedList.size;
    }
}
