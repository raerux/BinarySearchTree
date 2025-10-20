public class BinarySearchTree {
    private Node root;
    
    public BinarySearchTree() {
        this.root = null;
    }
    
    public void insert(int data) {
        root = insertRec(root, data);
    }
    
    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        
        return root;
    }
    
    public void inOrder() {
        System.out.print("In-Order: ");
        inOrderRec(root);
        System.out.println();
    }
    
    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }
    
    public void preOrder() {
        System.out.print("Pre-Order: ");
        preOrderRec(root);
        System.out.println();
    }
    
    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }
    
    public void printTree() {
        printTreeRec(root, "", true);
    }
    
    private void printTreeRec(Node node, String prefix, boolean isRight) {
        if (node != null) {
            System.out.println(prefix + (isRight ? "└── " : "┌── ") + node.data);
            printTreeRec(node.left, prefix + (isRight ? "    " : "│   "), false);
            printTreeRec(node.right, prefix + (isRight ? "    " : "│   "), true);
        }
    }
    
    public int getHeight() {
        return getHeightRec(root);
    }
    
    private int getHeightRec(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeightRec(node.left), getHeightRec(node.right));
    }
}