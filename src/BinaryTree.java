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

    int countNodes(Node root)
    {
        if(root==null)
            return 0;
        return(1 + countNodes(root.left) + countNodes(root.right));
    }

    /* This function checks if the binary tree is complete or not */
    private boolean isCompleteUtil(Node root, int index, int number_nodes)
    {
        // An empty tree is complete
        if(root == null)
            return true;

        // If index assigned to current node is more than
        // number of nodes in tree, then tree is not complete
        if(index >= number_nodes)
            return false;

        // Recur for left and right subtrees
        return isCompleteUtil(root.left, 2*index+1, number_nodes) &&
                isCompleteUtil(root.right, 2*index+2, number_nodes);

    }

    // This Function checks the heap property in the tree.
    private boolean isHeapUtil(Node root)
    {
        //  Base case : single node satisfies property
        if(root.left == null && root.right==null)
            return true;

        //  node will be in second last level
        if(root.right == null)
        {
            //  check heap property at Node
            //  No recursive call , because no need to check last level
            return root.key >= root.left.key;
        }
        else
        {
            //  Check heap property at Node and
            //  Recursive check heap property at left and right subtree
            if(root.key >= root.left.key && root.key >= root.right.key)
                return isHeapUtil(root.left) && isHeapUtil(root.right);
            else
                return false;
        }
    }

    //  Function to check binary tree is a Heap or Not.
    private boolean isHeapRec(Node root)
    {
        if(root == null)
            return true;

        // These two are used in isCompleteUtil()
        int node_count = countNodes(root);

        if(isCompleteUtil(root, 0 , node_count)==true && isHeapUtil(root)==true)
            return true;
        return false;
    }

    public boolean isHeap(){
        return isHeapRec(root);
    }
}
