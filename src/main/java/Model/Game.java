package Model;

import java.util.*;

public class Game {
    boolean endPositionFoundIndicator = false;

    public Game(){

    }

    public int MinimumSteps(int BoardHeight, int BoardWidth, int KnightStartXPosition,
                     int KnightStartYPosition, int KnightEndXPosition, int KnightEndYPosition) throws IllegalArgumentException{
        if ((KnightEndXPosition >= BoardWidth)  && (KnightStartXPosition >= BoardWidth) &&
                (KnightEndYPosition >= BoardHeight) && (KnightStartYPosition >= BoardHeight)){
            throw new IllegalArgumentException("Some of positions out of bounds");
        }
        if ((KnightEndXPosition < 0) && (KnightStartXPosition < 0) &&
                (KnightEndYPosition < 0) && (KnightStartYPosition < 0)){
            throw new IllegalArgumentException("Some of positions negative");
        }
        Node root = new Node(KnightStartXPosition, KnightStartYPosition);
        root.setDepth(0);
        Tree tree = new Tree(root);
        Position endPosition = new Position(KnightEndXPosition, KnightEndYPosition);
        fillTree(BoardHeight, BoardWidth, tree, endPosition);

        return 0;
    }

    protected int fillTree(int BoardHeight, int BoardWidth, Tree tree, Position endPosition){
        ArrayList<Position> usedPositions = new ArrayList<Position>();
        usedPositions.add(tree.getRoot().getPosition());
        ArrayList<Node> arrayList = new ArrayList<Node>();
        arrayList.add(tree.getRoot());
        fillNode(BoardHeight, BoardWidth, arrayList, endPosition, usedPositions);
        printChessBoard(usedPositions, BoardHeight, BoardWidth);
        System.out.println(tree.countHeight());
        return -1;
    }


    protected void fillNode(int BoardHeight, int BoardWidth, Node node, Position endPosition, ArrayList<Position> usedPositions) {
        if (!endPositionFoundIndicator){
            ArrayList<Position> positions = node.calculatePositions(BoardHeight, BoardWidth);

            for (int i = 0; i < positions.size(); i++) {
                int j = 0;
                while (j < usedPositions.size()) {
                    if ((usedPositions.get(j).getX() == positions.get(i).getX()) && (usedPositions.get(j).getY() == positions.get(i).getY())) {
                        break;
                    }
                    j++;
                }
                if (j == usedPositions.size()) {
                    Node newChild = new Node(positions.get(i));
                    node.getChildren().add(newChild);
                    usedPositions.add(positions.get(i));
                    if ((positions.get(i).getX() == endPosition.getX()) && (positions.get(i).getY() == endPosition.getY())) {
                        endPositionFoundIndicator = true;
                    }
                }
            }

            for (Node child : node.getChildren()) {
                fillNode(BoardHeight, BoardWidth, child, endPosition, usedPositions);
            }
        }
    }

    protected void fillNode(int BoardHeight, int BoardWidth, ArrayList<Node> nodes, Position endPosition, ArrayList<Position> usedPositions) {
        if (!endPositionFoundIndicator){
            for (Node node : nodes){
                ArrayList<Position> positions = node.calculatePositions(BoardHeight, BoardWidth);

                for (int i = 0; i < positions.size(); i++) {
                    int j = 0;
                    while (j < usedPositions.size()) {
                        if ((usedPositions.get(j).getX() == positions.get(i).getX()) && (usedPositions.get(j).getY() == positions.get(i).getY())) {
                            break;
                        }
                        j++;
                    }
                    if (j == usedPositions.size()) {
                        Node newChild = new Node(positions.get(i));
                        node.getChildren().add(newChild);
                        usedPositions.add(positions.get(i));
                        if ((positions.get(i).getX() == endPosition.getX()) && (positions.get(i).getY() == endPosition.getY())) {
                            endPositionFoundIndicator = true;
                        }
                    }
                }
            }

            ArrayList<Node> nextGen = new ArrayList<Node>();
            for (Node oldGenNode : nodes) {
                nextGen.addAll(oldGenNode.getChildren());
            }
            fillNode(BoardHeight, BoardWidth, nextGen, endPosition, usedPositions);
        }
    }

    public void printChessBoard(ArrayList<Position> usedPositions, int BoardHeight, int BoardWidth){
        for (int i = 0; i < BoardHeight; i++){
            for (int j =0; j < BoardWidth; j++){
                int k = 0;
                while (k < usedPositions.size()){
                    if ((usedPositions.get(k).getX() == i) && (usedPositions.get(k).getY() == j)){
                        System.out.print("1 ");
                        break;
                    }
                    k++;
                }
                if (k == usedPositions.size()){
                    System.out.print("0 ");
                }
            }
            System.out.println("");
        }
        System.out.println("------------------------------");
    }
}
