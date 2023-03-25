package LinkedList;

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

//metho to get the vaule of an element in the node.
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
}