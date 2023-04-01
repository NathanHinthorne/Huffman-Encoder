/*
   TCSS 342
   Author: Nathan Hinthorne
   Node for the huffman tree
*/

public class TreeNode implements Comparable<TreeNode> {
    
    private Character elem;
    private int priority;
    private TreeNode left;
    private TreeNode right;

    // default constructor
    public TreeNode(int priority) {
        this.elem = null;
        this.priority = priority;
        this.left = null;
        this.right = null;
    }

    // constructor with element and priority
    public TreeNode(Character elem, int priority) {
        this.elem = elem;
        this.priority = priority;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(TreeNode other) {
        if (this.priority > other.priority) {
            return 1;
        }
        return -1;
    }

    // sets the left child
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    // sets the right child
    public void setRight(TreeNode right) {
        this.right = right;
    }

    // gets the left child
    public TreeNode getLeft() {
        return left;
    }

    // gets the right child
    public TreeNode getRight() {
        return right;
    }

    // gets this node's element
    public Character getElem() {
        return elem;
    }

    // gets this node's priority
    public int getPriority() {
        return priority;
    }

    // sets this node's priority
    public void setPriority(int priority) {
        this.priority = priority;
    }

}