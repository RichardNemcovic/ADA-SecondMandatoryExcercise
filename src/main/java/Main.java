import Model.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Position position01 = new Position(1,1);
//        Position position02 = new Position(2,2);
//        final Node node12 = new Node(position01);
//        final Node node11 = new Node(position01, new ArrayList<Node>(){{add(node12);}});
//        final Node node10 = new Node(position01, new ArrayList<Node>(){{add(node11);}});
//        final Node node09 = new Node(position01, new ArrayList<Node>());
//        final Node node08 = new Node(position01, new ArrayList<Node>(){{add(node10);}});
//        final Node node07 = new Node(position01, new ArrayList<Node>());
//        final Node node06 = new Node(position01, new ArrayList<Node>());
//        final Node node05 = new Node(position01, new ArrayList<Node>(){{add(node09);}});
//        final Node node04 = new Node(position01, new ArrayList<Node>(){{add(node08);}});
//        final Node node03 = new Node(position01, new ArrayList<Node>());
//        final Position node02 = new Node(position02, new ArrayList<Node>(){{add(node05);add(node06);add(node07);}});
//        final Position node01 = new Node(position01, new ArrayList<Node>(){{add(node02);add(node03);add(node04);}});
//
//        Tree tree01 = new Tree(node01);
//        Tree tree02 = new Tree(node02);
//
//
//        ArrayList<Position> positions01 = tree01.getRoot().calculatePositions(10,10);
//        ArrayList<Position> positions02 = tree02.getRoot().calculatePositions(10,10);
//        ArrayList<Position> positions03 = tree02.getRoot().calculatePositions(3,4);
//        ArrayList<Position> positions04 = tree02.getRoot().calculatePositions(4,3);
//
//        for (Position position : positions01){
//            System.out.print("[" + position.getX() + ", ");
//            System.out.println(position.getY() + "]");
//        }
//
//        System.out.println("");
//        System.out.println("");
//
//        for (Position position : positions02){
//            System.out.print("[" + position.getX() + ", ");
//            System.out.println(position.getY() + "]");
//        }
//
//        System.out.println("");
//        System.out.println("");
//
//        for (Position position : positions03){
//            System.out.print("[" + position.getX() + ", ");
//            System.out.println(position.getY() + "]");
//        }
//
//        System.out.println("");
//        System.out.println("");
//
//        for (Position position : positions04){
//            System.out.print("[" + position.getX() + ", ");
//            System.out.println(position.getY() + "]");
//
        Game game = new Game();
        game.MinimumSteps(100,100,0,0,99,99);
    }
}
