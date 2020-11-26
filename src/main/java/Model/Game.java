package Model;

import java.util.*;

public class Game {
    boolean endPositionFoundIndicator = false;
    int operationCounter = 0;
    int[][] usedPositions;

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
        this.usedPositions = new int[BoardHeight][BoardWidth];
        for (int i = 0; i < BoardHeight; i++){
            for (int j = 0; j < BoardWidth; j++){
                this.usedPositions[i][j] = 0;
            }
        }


        Node root = new Node(KnightStartXPosition, KnightStartYPosition);
        root.setDepth(0);
        Tree tree = new Tree(root);
        Position endPosition = new Position(KnightEndXPosition, KnightEndYPosition);
        fillTree(BoardHeight, BoardWidth, tree, endPosition);
        System.out.println(operationCounter);
        int nodesCount = nodesCount(tree);
        return 0;
    }

    protected int fillTree(int BoardHeight, int BoardWidth, Tree tree, Position endPosition){
        ArrayList<Node> arrayList = new ArrayList<Node>();
        arrayList.add(tree.getRoot());
        fillNode(BoardHeight, BoardWidth, arrayList, endPosition);
        //printChessBoard(BoardHeight, BoardWidth);
        //System.out.println(tree.countHeight());
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

    protected void fillNode(int BoardHeight, int BoardWidth, ArrayList<Node> nodes, Position endPosition) {
        if (!endPositionFoundIndicator){
            operationCounter++;
            for (Node node : nodes) {
                ArrayList<Position> positions = node.calculatePositions(BoardHeight, BoardWidth);

                for (Position position : positions) {
                    if (this.usedPositions[position.getX()][position.getY()] == 0) {
                        Node newChild = new Node(position);
                        node.getChildren().add(newChild);
                        this.usedPositions[position.getX()][position.getY()] = 1;
                        if ((position.getX() == endPosition.getX()) && (position.getY() == endPosition.getY())) {
                            endPositionFoundIndicator = true;
                        }
                    }
                }
                positions = null;
            }

            ArrayList<Node> nextGen = new ArrayList<Node>();
            for (Node oldGenNode : nodes) {
                nextGen.addAll(oldGenNode.getChildren());
            }
            nodes = null;
            fillNode(BoardHeight, BoardWidth, nextGen, endPosition);
        }
    }

    public void printChessBoard(int BoardHeight, int BoardWidth){
        for (int i = 0; i < BoardHeight; i++){
            for (int j =0; j < BoardWidth; j++){
                System.out.print(this.usedPositions[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("------------------------------");
    }

    protected int nodesCount(Tree tree){
        ArrayList<Node> nodes = new ArrayList<Node>();
        nodes.add(tree.getRoot());
        return nodesCount(nodes);
    }

    protected int nodesCount(ArrayList<Node> nodes){
        ArrayList<Node> nextGen = new ArrayList<Node>();
        for (Node oldGenNode : nodes) {
            nextGen.addAll(oldGenNode.getChildren());
        }
        if (nodes.size() == 0){
            return 0;
        }
        return nodes.size() + nodesCount(nextGen);
    }
}
