/*
* TCSS 342
* Nathan Hinthorne
* Queue
*/

package q;

public class Queue<T> extends SLL<T> {

    // adds an element to the back of the queue
    public void enqueue(T elem) {
        addRear(elem);
    }

    // returns and deletes the front element
    public T dequeue() {
        T removedElem = delete(0);
        return removedElem;
    }

    // returns the front element
    public T peek() {
        return get(0);
    }

    // prints the elements of the queue from back to front
    @Override
    public String toString() {
        if (getSize() == 0) { // check for underflow
            return "Queue is empty";
        }

        return super.toString();
    }
}