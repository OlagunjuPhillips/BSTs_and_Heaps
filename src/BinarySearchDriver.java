import java.util.Random;

public class BinarySearchDriver {
    static final int NUM_OF_VALUES = 10;
    public static void main(String[] args){
        System.out.println("Binary Search Tree");
        BinarySearch tree = new BinarySearch();
        Random rand = new Random();
        for(int i = 0; i < NUM_OF_VALUES; i++){
            int randomValue = rand.nextInt(211) + 11;
            tree.insert(randomValue);
        }
        System.out.println("Printing Binary Search Tree of ten random values...");
        tree.inorder();
        System.out.println("\nPrinting average of values in tree...");
        System.out.println(tree.average());

        System.out.println("Printing the maximum value in the tree...");
        System.out.println(tree.maximum());
        System.out.println("Done.");

        System.out.println("Printing the minimum value of the tree...");
        System.out.println(tree.minimum());
        System.out.println("Done.");

        System.out.println("Creating random tree...");
        BinaryTree randomTree = new BinaryTree();
        randomTree = randomTree.generateTree(6);
        System.out.println("Done.");

        System.out.println("Checking if random tree is a Binary Search Tree...");
        if(randomTree.isBinarySearch() == true){
            System.out.println("Tree is a binary search tree.");
        } else{
            System.out.println("Tree is not a binary search tree.");
        }


    }
}
