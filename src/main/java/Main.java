import Model.*;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        if (!(MinimumSteps(5, 5, 0, 0, 0, 0) == 0))
            System.out.println("Failed test 1");
        if (!(MinimumSteps(5, 5, 0, 0, 1, 0) == 3))
            System.out.println("Failed test 2");
        if (!(MinimumSteps(5, 5, 0, 0, 2, 0) == 2))
            System.out.println("Failed test 3");
        if (!(MinimumSteps(5, 5, 0, 0, 3, 0) == 3))
            System.out.println("Failed test 4");
        if (!(MinimumSteps(5, 5, 0, 0, 4, 0) == 2))
            System.out.println("Failed test 5");
        if (!(MinimumSteps(5, 5, 0, 0, 0, 1) == 3))
            System.out.println("Failed test 6");
        if (!(MinimumSteps(5, 5, 0, 0, 1, 1) == 4))
            System.out.println("Failed test 7");
        if (!(MinimumSteps(5, 5, 0, 0, 2, 1) == 1))
            System.out.println("Failed test 8");
        if (!(MinimumSteps(5, 5, 0, 0, 3, 1) == 2))
            System.out.println("Failed test 9");
        if (!(MinimumSteps(5, 5, 0, 0, 4, 1) == 3))
            System.out.println("Failed test 10");
        if (!(MinimumSteps(5, 5, 0, 0, 0, 2) == 2))
            System.out.println("Failed test 11");
        if (!(MinimumSteps(5, 5, 0, 0, 1, 2) == 1))
            System.out.println("Failed test 12");
        if (!(MinimumSteps(5, 5, 0, 0, 2, 2) == 4))
            System.out.println("Failed test 13");
        if (!(MinimumSteps(5, 5, 0, 0, 3, 2) == 3))
            System.out.println("Failed test 14");
        if (!(MinimumSteps(5, 5, 0, 0, 4, 2) == 2))
            System.out.println("Failed test 15");
        if (!(MinimumSteps(5, 5, 0, 0, 0, 3) == 3))
            System.out.println("Failed test 16");
        if (!(MinimumSteps(5, 5, 0, 0, 1, 3) == 2))
            System.out.println("Failed test 17");
        if (!(MinimumSteps(5, 5, 0, 0, 2, 3) == 3))
            System.out.println("Failed test 18");
        if (!(MinimumSteps(5, 5, 0, 0, 3, 3) == 2))
            System.out.println("Failed test 19");
        if (!(MinimumSteps(5, 5, 0, 0, 4, 3) == 3))
            System.out.println("Failed test 20");
        if (!(MinimumSteps(5, 5, 0, 0, 0, 4) == 2))
            System.out.println("Failed test 21");
        if (!(MinimumSteps(5, 5, 0, 0, 1, 4) == 3))
            System.out.println("Failed test 22");
        if (!(MinimumSteps(5, 5, 0, 0, 2, 4) == 2))
            System.out.println("Failed test 23");
        if (!(MinimumSteps(5, 5, 0, 0, 3, 4) == 3))
            System.out.println("Failed test 24");
        if (!(MinimumSteps(5, 5, 0, 0, 4, 4) == 4))
            System.out.println("Failed test 25");
        if (!(MinimumSteps(1000, 1000, 0, 0, 999, 999) == 666))
            System.out.println("Failed test 26");
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime + " ms");
    }

    public static int MinimumSteps(int BoardHeight, int BoardWidth, int KnightStartXPosition,
                            int KnightStartYPosition, int KnightEndXPosition, int KnightEndYPosition) throws IllegalArgumentException{
        Driver driver = new Driver();
        return driver.MinimumSteps(BoardHeight, BoardWidth, KnightStartXPosition,
                KnightStartYPosition, KnightEndXPosition, KnightEndYPosition);
    }
}