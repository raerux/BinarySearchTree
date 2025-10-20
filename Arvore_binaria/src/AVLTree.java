public class AVLTree {
    private Node root;
    
    public AVLTree() {
        this.root = null;
    }
    
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }
    
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        
        x.right = y;
        y.left = T2;
        
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        
        return x;
    }
    
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        
        y.left = x;
        x.right = T2;
        
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        
        return y;
    }
    
    public void insert(int data) {
        root = insertRec(root, data);
    }
    
    private Node insertRec(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        
        if (data < node.data) {
            node.left = insertRec(node.left, data);
        } else if (data > node.data) {
            node.right = insertRec(node.right, data);
        } else {
            return node;
        }
        
        node.height = 1 + Math.max(height(node.left), height(node.right));
        
        int balance = getBalance(node);

        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }
        
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }
        
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        return node;
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
        return height(root);
    }
}