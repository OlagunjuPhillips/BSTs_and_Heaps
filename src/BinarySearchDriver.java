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

    }
}
