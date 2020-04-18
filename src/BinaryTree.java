import java.util.*;


public class BinaryTree {
    static final Random random = new Random();

    private class Node {
        private int key;
        private Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }



    private Node root;

    public BinaryTree(){
        root = null;
    }

    private void insertNode(Node node, int key){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            node = queue.peek();
            queue.remove();


            if (node.left == null) {
                node.left = new Node(key);
                break;
                // I know you said using a break statement here is wrong
                // but I'm not sure how else to do this part.
            } else
                queue.add(node.left);

            if (node.right == null) {
                node.right = new Node(key);
                break;
            } else
                queue.add(node.right);
        }
    }

    private enum Coin{
        HEAD, TAIL;

        public static Coin getSide(){
            return values()[random.nextInt(values().length)];
        }
    }

    public BinaryTree generateTree(int  numberOfNodes){
        int randomValue = random.nextInt(211) + 11;
        BinaryTree randomTree = new BinaryTree();
        randomTree.root = new Node(randomValue);
        for(int i = 0; i < numberOfNodes - 1; i++){
            randomValue = random.nextInt(211) + 11;
            if(Coin.getSide().equals(Coin.HEAD)){
                if(randomTree.root.left != null){
                    insertNode(randomTree.root.left, randomValue);
                }else{
                    randomTree.root.left = new Node(randomValue);
                }
            }else{
                if(randomTree.root.right != null){
                    insertNode(randomTree.root.right, randomValue);
                }else{
                    randomTree.root.right = new Node(randomValue);
                }
            }
        }
        return randomTree;
    }

    private boolean checkSearchTree(Node node) {
        if(node != null) {
            if (node.left != null) {
                if (node.left.key > node.key) {
                    return false;
                }
            }
            if (node.right != null) {
                if (node.right.key < node.key) {
                    return false;
                }
            }
            return checkSearchTree(node.left) && checkSearchTree(node.right);
        }
        return true;
    }

    public boolean isBinarySearch(){
        return checkSearchTree(root);
    }

}
