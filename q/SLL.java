/*
* TCSS 342
* Nathan Hinthorne
* SLL
*/

package q;

public class SLL<T> {

    // the number of elements in the linked list
    private int size;

    // the first node in the list
    private Node<T> front;

    // the last node in the list
    private Node<T> rear;

    // Node class
    public class Node<P> {
        public T data;
        public Node<T> next;

        public Node() {
            this.data = null;
            this.next = null;
        }

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // constructor
    public SLL() {
        size = 0;
        front = new Node<T>();
        rear = front;
    }

    // checks if the list is empty
    private boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    // adds a node to the front of the list
    public void addFront(T elem) {

        if (isEmpty()) { // case 1: list is empty
            front = new Node<T>(elem);
            rear = front;
        } else { // case 2: list has one or more nodes
            Node<T> temp = new Node<>(elem);
            temp.next = front;
            front = temp;
        }

        size++;
    }

    // adds a node to the back of a list
    public void addRear(T elem) {

        if (isEmpty()) { // case 1: list is empty
            rear = new Node<T>(elem);
            front = rear;
        } else { // case 2: list has one or more nodes
            Node<T> temp = new Node<>(elem);
            rear.next = temp;
            rear = temp;
        }

        size++;
    }

    // adds a node at the specified index 
    public void add(int index, T elem) {

        if (index < 0 || index > size) { 
            throw new IllegalArgumentException("index out of range");
        }

        if (index == 0 || isEmpty()) { // case 1: list is empty or the given index is 0
            addFront(elem);
        } else if (index == size) { // case 2: the given index is the last index in the list
            addRear(elem);

        } else { // case 3: the specified index must somewhere in the middle of the list, 
                 // so traverse the list and look for the node
            Node<T> current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            Node<T> temp = new Node<>(elem);

            temp.next = current.next; // make the new node point to current's next node
            current.next = temp; // make current point to the new node
        }

        size++;
    }

    // deletes the node at the specified index
    public T delete(int index) {

        T deletedElement;

        Node<T> current = front;


        if (index == 0) {
            deletedElement = front.data;
            front = front.next;
        } else {
            // search for the node at the specified index
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
    
            deletedElement = current.next.data;
            current.next = current.next.next; // skip over the reference to the node, deleting it from the list
    
            if (index == size-1) {
                rear = current;
            }
        }

        size--;

        return deletedElement;
    }

    // returns the node at the specified index
    public T get(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index out of range");
        }

        T foundElement;

        if (index == 0) { // case 1: the given index is 0
            foundElement = front.data;
        } else if (index == size) {  // case 2: the given index is the last index in the list
            foundElement = rear.data;
        } else { // case 3: the specified index is somewhere in the middle of the list

            Node<T> current = front;

            // iterate through the list to find the node
            for (int i = 0; i < index - 1; i++) {
              current = current.next;
            }
            foundElement = current.next.data;
        }
        
        return foundElement;
    }

    // swaps the nodes at the given indexes
    public void swap(int index1, int index2) {
        
        if (index1 < 0 || index1 > size) {
            throw new IllegalArgumentException("index1 out of range");
        } else if (index2 < 0 || index2 > size) {
            throw new IllegalArgumentException("index2 out of range");
        } else if (index1 > index2) {
            throw new IllegalArgumentException("index1 must be less than or equal to index2");
        }

        if (index1 == index2) { // if both indexes match, simply exit the method
            return;
        }

        // store the deleted elements
        T temp1 = delete(index1);
        T temp2 = delete(index2);

        // add the nodes back with their swapped elements
        add(index1, temp2);
        add(index2, temp1);
    }

    // prints every element of the list
    public String toString() {

        StringBuilder nodeList = new StringBuilder(this.size);

        nodeList.append(front.data);

        Node<T> current = front.next;

        // iterate over the list and append each node's data to a string
        while (current != null) {
            nodeList.append(", " + current.data);

            current = current.next;
        }

        return nodeList.toString();
    }

     // gets the count
     public int count() {
        return size;
    }
}
