// Node class representing each node in the binary tree
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

// BinaryTree class representing the binary tree structure
class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // Insert a new node with given data
    public void insert(int data) {
        root = insertRec(root, data);
    }

    // A recursive function to insert a new key in BST
    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    // Delete a node with the given data
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    // A recursive function to delete a node from BST
    private Node deleteRec(Node root, int data) {
        if (root == null) return root;

        // Traverse the tree to find the node to delete
        if (data < root.data)
            root.left = deleteRec(root.left, data);
        else if (data > root.data)
            root.right = deleteRec(root.right, data);
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    // Find the minimum value node in the subtree rooted at root
    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Pre-order traversal
    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // In-order traversal
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    // Post-order traversal
    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }
}

// Main class to test the BinaryTree class
public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Inserting nodes into the binary tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Pre-order traversal:");
        tree.preOrder(); // Output: 50 30 20 40 70 60 80

        System.out.println("\nIn-order traversal:");
        tree.inOrder(); // Output: 20 30 40 50 60 70 80

        System.out.println("\nPost-order traversal:");
        tree.postOrder(); // Output: 20 40 30 60 80 70 50

        // Deleting a node
        tree.delete(20);
        System.out.println("\nIn-order traversal after deleting 20:");
        tree.inOrder(); // Output: 30 40 50 60 70 80

        // Deleting a node
        tree.delete(30);
        System.out.println("\nIn-order traversal after deleting 30:");
        tree.inOrder(); // Output: 40 50 60 70 80

        // Deleting a node
        tree.delete(50);
        System.out.println("\nIn-order traversal after deleting 50:");
        tree.inOrder(); // Output: 40 60 70 80
    }
}
