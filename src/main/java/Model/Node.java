package Model;

import java.util.*;

public class Node {
    private Position position;
    private ArrayList<Node> children;
    private int numberOfChildren;
    private int depth;

    protected boolean addChild(Node node){
        if (node != null){
            ArrayList<Node> list = getChildren();
            list.add(node);
            node.setChildren(list);
            return true;
        }
        return false;
    }

    public ArrayList<Position> calculatePositions(int BoardHeight, int BoardWidth){
        int x = this.position.getX();
        int y = this.position.getY();
        ArrayList<Position> positions = new ArrayList<Position>();
        if ((x >= 0) && (x < BoardWidth) && (y >= 0) && (y < BoardHeight)) {
            if ((x - 2 >= 0) && (y + 1 < BoardHeight)) {
                positions.add(new Position(x - 2, y + 1));
            }
            if ((x - 2 >= 0) && (y - 1 >= 0)) {
                positions.add(new Position(x - 2, y - 1));
            }
            if ((x - 1 >= 0) && (y + 2 < BoardHeight)) {
                positions.add(new Position(x - 1, y + 2));
            }
            if ((x - 1 >= 0) && (y - 2 >= 0)) {
                positions.add(new Position(x - 1, y - 2));
            }
            if ((x + 1 < BoardWidth) && (y + 2 < BoardHeight)) {
                positions.add(new Position(x + 1, y + 2));
            }
            if ((x + 1 < BoardWidth) && (y - 2 >= 0)) {
                positions.add(new Position(x + 1, y - 2));
            }
            if ((x + 2 < BoardWidth) && (y + 1 < BoardHeight)) {
                positions.add(new Position(x + 2, y + 1));
            }
            if ((x + 2 < BoardWidth) && (y - 1 >= 0)) {
                positions.add(new Position(x + 2, y - 1));
            }
            return positions;
        }
        return null;
    }

    // Constructors
    public Node(Position position) {
        setPosition(position);
        setChildren(new ArrayList<Node>());
        setNumberOfChildren(0);
    }

    public Node(Position position, ArrayList<Node> children) {
        setPosition(position);
        setChildren(children);
        setNumberOfChildren(children.size());
    }

    public Node(int x, int y){
        this(new Position(x,y));
    }

    public Node(int x, int y, ArrayList<Node> children){
        this(new Position(x,y), children);
    }

    // Getters
    public Position getPosition() {
        return position;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public int getDepth() {
        return depth;
    }

    // Setters
    public void setPosition(Position position) {
        this.position = position;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
