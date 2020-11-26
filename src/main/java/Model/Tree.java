package Model;

public class Tree {
    private Node root;

    // Constructor
    public Tree(Node root) {
        setRoot(root);
    }

    // Getter
    public Node getRoot() {
        return root;
    }

    // Setter
    public void setRoot(Node root) {
        this.root = root;
    }
}
