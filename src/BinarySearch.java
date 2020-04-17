//copied from geeksforgeeks.com

public class BinarySearch {
    private class Node {
        private int key;
        private Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    private Node root;

    // Constructor
    public BinarySearch() {
        root = null;
    }

    // This method mainly calls insertRec()
    public void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    private Node insertRec(Node root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // A utility function to do inorder traversal of BST
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // This method mainly calls InorderRec()
    public void inorder()  {
        inorderRec(root);
    }



    // A function to find the sum of all values in a BST
    private int sumRec(Node node){
        if(node == null){
            return 0;
        }
        return node.key + sumRec(node.left) + sumRec(node.right);
    }

    private int countNumberOfNodes(Node node){
        if(node == null){
            return 0;
        }
        return 1 + countNumberOfNodes(node.left) + countNumberOfNodes(node.right);
    }

    public double average(){
        double average = sumRec(root)/countNumberOfNodes(root);
        return average;
    }

}
