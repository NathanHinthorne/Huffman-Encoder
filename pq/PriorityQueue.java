/*
   TCSS 342
   Author: Nathan Hinthorne
   Implementation of a PriorityQueue 
*/

package pq;

public class PriorityQueue<T extends Comparable<T>> extends ArrayHeap<T> {
    

   // default constructor
   public PriorityQueue() {
      super();
   }

   // constructor with capacity
   public PriorityQueue(int capacity) {
      super(capacity);
   }

   // insert an element into the queue (it will be arranged as needed depending on its priority)
   public void insert(T element) {
      addElement(element);
   }

   @Override
   public String toString() {

      if (isEmpty()) { // case 1: heap is empty
         return "PriorityQueue is empty";
      } else { // case 2: heap contains at least one element
         return super.toString();
      }

   }
}
