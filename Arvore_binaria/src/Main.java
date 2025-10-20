public class Main {
    public static void main(String[] args) {
        int[] elements = {1, 2, 3, 10, 4, 5, 9, 7, 8, 6};

        System.out.println("=".repeat(60));
        System.out.println("COMPARAÇÃO: Árvore Binária de Busca vs Árvore AVL");
        System.out.println("=".repeat(60));
        System.out.println("Elementos inseridos: {1, 2, 3, 10, 4, 5, 9, 7, 8, 6}");
        System.out.println("=".repeat(60));

        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("\n### ÁRVORE BINÁRIA DE BUSCA (BST) ###\n");

        for (int element : elements) {
            bst.insert(element);
        }

        System.out.println("Estrutura da BST:");
        bst.printTree();
        System.out.println();
        bst.preOrder();
        bst.inOrder();
        System.out.println("Altura da BST: " + bst.getHeight());

        AVLTree avl = new AVLTree();
        System.out.println("\n" + "=".repeat(60));
        System.out.println("### ÁRVORE AVL (Auto-balanceada) ###\n");

        for (int element : elements) {
            avl.insert(element);
        }

        System.out.println("Estrutura da AVL:");
        avl.printTree();
        System.out.println();
        avl.preOrder();
        avl.inOrder();
        System.out.println("Altura da AVL: " + avl.getHeight());

        System.out.println("\n" + "=".repeat(60));
        System.out.println("### ANÁLISE COMPARATIVA ###");
        System.out.println("=".repeat(60));
        System.out.println("BST - Altura: " + bst.getHeight());
        System.out.println("AVL - Altura: " + avl.getHeight());
        System.out.println("\nDIFERENÇAS PRINCIPAIS:");
        System.out.println("1. A BST ficou desbalanceada devido à ordem de inserção");
        System.out.println("2. A AVL mantém-se balanceada através de rotações automáticas");
        System.out.println("3. A altura da AVL é menor, garantindo O(log n) para operações");
        System.out.println("4. A BST pode degenerar para O(n) no pior caso");
        System.out.println("=".repeat(60));
    }
}