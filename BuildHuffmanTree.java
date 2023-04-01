/*
   TCSS 342
   Author: Nathan Hinthorne
   Builds and traverses huffman trees
*/


import java.util.HashMap;

import q.Queue;
import pq.PriorityQueue;

public class BuildHuffmanTree {
    
    // Builds and returns the root node of the final HuffmanTree using a Queue. 
    public static TreeNode buildTreeQueue(HashMap<Character, Integer> freqTable, Queue<TreeNode> q) {

        // add each key-value pair to the queue
        for (Character c : freqTable.keySet()) {
            TreeNode node = new TreeNode(c, freqTable.get(c)); // treeNode containing the key-value pair
            q.enqueue(node);
        }

        while (q.count() > 1) { // q.peek().getElem() != null
            // take the first 2 key-value pairs off the queue
            TreeNode left = q.dequeue(); // future left child
            TreeNode right = q.dequeue(); // future right child

            HuffmanTree tree = new HuffmanTree(left, right); // form a new tree based off the children
            tree.getRoot().setPriority(left.getPriority() + right.getPriority());
            q.enqueue(tree.getRoot()); // add the huffman tree to the back of the queue
        }

        return q.peek(); // return the fully formed huffman tree
    }


    // Builds and returns the root node of the final HuffmanTree using a PriorityQueue. 
    public static TreeNode buildTreePQ(HashMap<Character, Integer> freqTable, PriorityQueue<TreeNode> pq) {

        // add each key-value pair to the queue
        for (Character c : freqTable.keySet()) {
            TreeNode node = new TreeNode(c, freqTable.get(c)); // treeNode containing the key-value pair
            pq.insert(node);
        }

        while (pq.count() > 1) { 
            // take the first 2 key-value pairs off the queue
            TreeNode left = pq.removeMin(); // future left child
            TreeNode right = pq.removeMin(); // future right child

            HuffmanTree tree = new HuffmanTree(left, right); // form a new tree based off the children
            tree.getRoot().setPriority(left.getPriority() + right.getPriority());
            pq.insert(tree.getRoot()); // add the huffman tree somewhere in the queue
        }

        return pq.peekMin(); // return the fully formed huffman tree
    }
    

    // Traverses the HuffmanTree to create the Huffman codes for 
    // each of the characters that appear in the test string.
    public static void encodeTraversal(TreeNode root, String code, HashMap<Character, String> encodeTable) {

        TreeNode left = root.getLeft(); // left child
        TreeNode right = root.getRight(); // right child

        // base case:
        // if this is a leaf node, put the character and element into the table
        if (left == null && right == null) {
            encodeTable.put(root.getElem(), code);
            return;
        }

        if (left != null) {
            encodeTraversal(left, code + "0", encodeTable); // add 0, since we traversed left
        }
        if (right != null) {
            encodeTraversal(right, code + "1", encodeTable); // add 1, since we traversed right
        }
    }
}
