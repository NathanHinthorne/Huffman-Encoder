/*
   TCSS 342
   Author: Nathan Hinthorne
   A huffman tree used for generating huffman codes
*/

public class HuffmanTree {
    
    private TreeNode root;

    // Default constructor
    public HuffmanTree(TreeNode left, TreeNode right) {

        this.root = new TreeNode(0);
        root.setLeft(left);
        root.setRight(right);
    }

    // gets the root treeNode
    public TreeNode getRoot() {
        return root;
    }
}
