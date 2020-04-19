import java.util.Random;

public class MaxHeapDriver {
    static final int NUMBER_OF_INTEGERS = 10;
    static final int NUMBER_OF_NODES = 6;
    public static void main(String[] args) {
        System.out.println("===== MaxHeap =====");

        System.out.println("\nCreating Max Heap...Done.");
        Random random = new Random();
        MaxHeap heap = new MaxHeap(NUMBER_OF_INTEGERS);
        for(int i = 0; i < NUMBER_OF_INTEGERS;i++){
            int value = random.nextInt(411) + 33;
            heap.insert(value);
        }
        System.out.println("\nPrinting Max Heap.");
        heap.printHeap();

        System.out.println("\nPrinting maximum value in the heap...");
        System.out.println(heap.findMax());

        System.out.println("\nPrinting minimum value in the heap...");
        System.out.println(heap.findMin());

        System.out.println("\nMaking attempt to find a Heap tree from randomly generated binary trees...");
        BinaryTree tree = new BinaryTree();
        int count = 0;
        do{
            tree = tree.generateTree(NUMBER_OF_NODES);
            count++;
        } while(!tree.isHeap());
        System.out.println("Took "+count+" tries to get a MaxHeap.");

        /* Question 4
        (1) The Elders Scrolls IV picture showed a list of skills that were not connected. Just like a regular array is.
        The description of each skill is significantly different from the others.
        (2) The Diable II image showed a connection between each skill in different categories. The connected images are
        largely similar in the Diablo image.
        (4) (1) Skill trees are more complex than skill list. Skill list show a more detailed relationship between the levels
        of a particular skill. They pay intricate attention to the way a particular skill could be developed: the various
        level of a particular skill a player could achieve. It is even more complex when the same relationship is present
        for every skill that a character has. This is different from a skill list that is quite linear and can only be
        increased or decreased, as applicable to each game.
        (2) The span of a skill list is wide since it quite easy to fit in every skill a character could have. I think it
        is easier to see the difference between a skill list and a skill tree in this manner: a skill list represents
        all skills a character can have, while a skill tree represents the levels of mastery of each skill the a character
        can have. This makes skill list quite broad, while skill tree is more specific about a skill.
        (3) Since many of the skills in a skill list may not be related in any way, coupling becomes difficult to do, and
        the vast possibilities of skills available makes it easy to add irrelevant skills to a character.
         */
    }
}
