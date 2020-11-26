package Model;

import java.util.*;

public class Tree {
    private Node root;
    private int height;

    protected int countHeight() {
        if (this.root == null){
            return 0;
        }
        ArrayList<Node> used = new ArrayList<Node>();
        used.add(root);
        return countHeight(getRoot());
    }

    protected int countHeight(Node node) {
        if (node.getNumberOfChildren() != 0) {
            ArrayList<Node> children = new ArrayList<Node>();
            int maxHeight = 1;
            int height;

            for (int i = 0; i < node.getNumberOfChildren(); i++){
                children.add(node.getChildren().get(i));
            }


            for (Node child : children) {
                height = 1 + countHeight(child);
                if (height > maxHeight) {
                    maxHeight = height;
                }
            }
            return maxHeight;
        } else {
            return 0;
        }
    }

    // Constructor
    public Tree(Node root) {
        setRoot(root);
    }

    // Getters
    public Node getRoot() {
        return root;
    }

    public int getHeight() {
        return height;
    }

    // Setters
    public void setRoot(Node root) {
        this.root = root;
        this.height = countHeight();
    }
}
