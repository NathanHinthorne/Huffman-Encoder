/*
TCSS 342
Author: Nathan Hinthorne
Implementation of an ArrayHeap
*/

package pq;

public class ArrayHeap<T extends Comparable<T>> {
    
    private int capacity; // the capacity of the heap
    private int count; // the number of elements in the heap
    private T[] heap; // the heap
    
    
    // default constructor
    public ArrayHeap() {

        this.count = 0;
        this.capacity = 10;
        this.heap = (T[]) (new Comparable[capacity+1]); // +1 because we don't use index 0
    }

    // constructor with capacity
    public ArrayHeap(int capacity) {

        this.count = 0;
        this.capacity = capacity;
        this.heap = (T[]) (new Comparable[capacity+1]); // +1 because we don't use index 0
    }

    public void addElement(T element) {
        
        // check for overflow
        if (isFull()) {
            resize();
        }

        heap[count+1] = element; // add the elem to the end of the heap
        bubbleUp(count+1); // heapify
        count++; 
    }

    public T removeMin() {
        
        // check for underflow
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        T min = heap[1]; // the first elem of the heap (the root)

        heap[1] = heap[count]; // replace the root with the last elem
        swap(1, count); // swap the first and last elems
        bubbleDown(1); // heapify

        heap[count] = null; // remove the last elem
        count--;
        return min;
    }

    public T peekMin() {

        // check for underflow
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        T min = heap[1]; // the first elem of the heap (the root)

        return min;
    }

    private void bubbleDown(int curr) {

        int left = 2*curr; // the index of the left child
        int right = 2*curr+1; // the index of the right child

        // base case. check bounds
        if (left > count || right > count) {
            return;
        }

        // check if the current node is bigger than either of its children
        if (isBiggerThan(curr, left) || isBiggerThan(curr, right)) {
            
            int childToSwap; // the index of the child to swap with
            
            if (isBiggerThan(left, right)) { // case 1: right is smaller than left
                childToSwap = right;
            } else { // case 2: left is smaller than right
                childToSwap = left;
            }

            swap(curr, childToSwap); // swap the current node with the smaller child
        }

        bubbleDown(left); // heapify the left subtree
        bubbleDown(right); // heapify the right subtree
    }

    private void bubbleUp(int curr) {

        // base case
        if (curr <= 1) {
            return;
        }

        int parent = curr/2; // the index of the parent

        // check if the parent is larger than the current node
        if (isBiggerThan(parent, curr)) {
            swap(parent, curr);
        }

        bubbleUp(parent); // heapify the parent
    }

    // checks if a given index is smaller than another index
    private boolean isBiggerThan(int index1, int index2) {

        // compare the two elements
        if (heap[index1].compareTo(heap[index2]) > 0) {
            return true;
        }
        return false;
    }

    // checks if the heap is empty
    protected boolean isEmpty() {
        return count == 0;
    }

    // checks if the heap is full
    protected boolean isFull() {
        return count == capacity;
    }

    // resize the heap
    private void resize() {

        capacity = capacity * 2; // double the capacity
        T[] newHeap = (T[]) (new Comparable[capacity + 1]);

        // transfer the contents of the old heap into the resized heap
        for (int i = 1; i < capacity/2 + 1; i++) {
            newHeap[i] = heap[i];
        }
        
        heap = newHeap; // or arrays.copyOf() method? does it matter that newHeap gets garbage collected?
    }

    // swap two elements in the heap
    private void swap(int index1, int index2) {
        T temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    @Override
    public String toString() {

        // case 1: heap is empty
        if (isEmpty()) {
            return "[]";
        }

        // case 2: heap contains at least one element
        StringBuilder s = new StringBuilder(count*2);
        s.append("[");
        s.append(heap[1]); // add the first elem
        for (int i = 2; i <= count; i++) {
            s.append(", " + heap[i]); // add the remaining elements
        }
        s.append("]");

        return s.toString();
    }

    // gets the count
    public int count() {
        return count;
    }

}
