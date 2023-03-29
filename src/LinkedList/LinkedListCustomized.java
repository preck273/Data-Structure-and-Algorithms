package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import com.dataStructure.ArrayListCustomised;

public class LinkedListCustomized<T> implements CustomizedLinkedList{

    private int size;
    private Node<T> head;


    private static class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }
    }

    //method to return the size of the linked list
    @Override
    public int size() {
        return this.size;
    }
//method to add a node to the linked list, by checking if the head is null
    @Override
    public void addFirst(Object data) {

        Node<T> node = new Node(data);

        if(this.head == null){
            this.head = node;
            this.size++;
            return;
        }

       node.next = this.head;
        this.head = node;
        this.size++;

    }

    //method to add a node to the tail of the linked list
    @Override
    public void addLast(Object data) {

        //first creat a new node
        Node<T> node = new Node(data);

        if(this.head == null){
            this.head = node;
            this.size++;
            return;
        }
//check if the node already exist
        Node<T> currentNode = head;

        //if yes find the tail in the list, loop until the node point is null
        while (currentNode.next !=null){
            currentNode = currentNode.next;
        }
        //add the node and increase the size
        currentNode.next = node;
        this.size++;
    }

//method to implement linear search.
    @Override
    public Object get(int index) {
//check if the index is zero return the value oif the first node(head of the list)
        if (this.size == 0 || index > this.size - 1){
            return null;
        }

        if (index == 0){
            return (T) this.head.data;
        }
// if the index is not zero, it loops through the list increamenting the current index 0 and compare it with the received parameter until match s found
        int currentIndex = 0;
        Node<T> currentNode = this.head;

        while (currentNode.next !=null){
            currentNode = currentNode.next;
            if (++currentIndex == index){
                return (T) currentNode.data;
            }
        }
        return null;
    }
//method to get the first element in the list, it returns the data from the head
    @Override
    public Object getFirst() {
        return (T) this.head.data;
    }

    //method to return the last element if the list, loop to the end of the list and return the data of the tail
    @Override
    public Object getLast() {
        Node<T> currrentNode = this.head;

        while (currrentNode.next != null){
            currrentNode = currrentNode.next;
            if (currrentNode.next == null){
                return (T) currrentNode.data;
            }
        }
        return null;
    }
//this method remove the head of the list and make the next node the head
    @Override
    public void removeFirst() {

        if (this.size == 0){
            return;
        }
        Node<T> currentHead = this.head;
        this.head = this.head.next;
        currentHead.data = null;
        currentHead.next = null;
        this.size--;
    }

    public void addAll(Integer[] values) {

        for (int i = 0; i< values.length; i++) {
            addLast(values[i]);
        }
    }

    //this method loop over the list to look for the last element in the list
    @Override
    public void removeLast() {

        if (this.size == 0){
            return;
        }

        Node<T> currentNode = this.head;
        while (currentNode.next != null){
            currentNode =currentNode.next;
            if (currentNode.next.next == null){
                currentNode.next.data = null;
                currentNode.next = null;
                this.size--;
                return;

            }
        }
    }
//method to remove the value/data in the list
    @Override
    public void removeValue(Object data) {
        //first step check if the list is empty, if yes return and stop
        if (this.head == null){
            return;
        }
        //check if the head is equal the data receive(like 1) if so remove the data and the next element will be the head
        if (this.head.data == data){
            this.head = this.head.next;
            this.size--;
            return;
        }
//if the data received is not equal to the head loop through the list and compare the data until you find a match and remove it
        Node<T> currentNode = this.head;

        while (currentNode.next != null){
            if (currentNode.next.data ==data){
                currentNode.next =currentNode.next.next;
                this.size--;
                return;
            }
            currentNode = currentNode.next;
        }

    }
//method to clear the list, it loops and remove the head until the lst is empty
    @Override
    public void clear() {

        while (this.size != 0){
            this.removeFirst();
        }
    }

    public int search(T element)
    {

        if (head == null) {
            return -1;
        }

        int index = 0;
        Node<T> temp = head;

        // While loop is used to search the entire Linked
        // List starting from the tail
        while (temp != null) {

            // Returns the index of that particular element,
            // if found.
            if (temp.data == element) {
                return index;
            }

            // Gradually increases index while
            // traversing through the Linked List
            index++;
            temp = temp.next;
        }

        // Returns -1 if the element is not found
        return -1;
    }

    public int getLength() {
        int length = 1;
        Node<T> currentNode = this.head;

        while (currentNode.next !=null){
            currentNode = currentNode.next;
            length++;
        }

        return length;
    }

    //method to convert linkedList to array
    public List<Integer> convertToArray() {

        List<Integer> arr = new ArrayList<Integer>(getLength());

        Node<T> currentNode = this.head;
            int length = this.getLength();
        while (length > 0){
            arr.add((Integer) currentNode.data);
            currentNode = currentNode.next;
            length--;
        }
        return arr;
    }

    //method to check if linked list contains value
    //First convert linkedList to arrayList then to arraylistCustomized
    //then calls binary search using bubble sort
    public boolean contains(int value){
        Integer [] array = new Integer[this.getLength()];
        array = this.convertToArray().toArray(new Integer[0]);

        ArrayListCustomised list = new ArrayListCustomised(this.getLength());
        list.addall(array);

        return list.contains(value);
    }


    //to convert Linked list to Iterator<Integer> in the descending order
    //First convert linkedList to arrayList sort in desc using reverse linear sort
    //then calls converts from arrayList to Iterator

    public Iterator<Integer> descendingIterator(){

        Integer [] array = new Integer[this.getLength()];
        array = this.convertToArray().toArray(new Integer[0]);

        ArrayListCustomised list = new ArrayListCustomised(this.getLength());
        list.addall(array);

        Integer[] result = list.descendingInsertionSort();

        Iterator<Integer> iterator = Arrays.asList(result).iterator();

        return iterator;
    }
}


