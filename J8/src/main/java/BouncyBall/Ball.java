package BouncyBall;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ball {
    Direction direction;

    public Ball(Direction direction) {
        this.direction = direction;
    }

    static Scanner scanner = new Scanner(System.in);

    static Random rand = new Random();
    static String[][] map = new String[4][4];
    static Ball ball = new Ball(ballDirection());

    public static void main(String[] args) {
        ballSpawn();
        while (true) {
            map();
        }
    }

    public static void map() {
        for (String[] strArray : map) {
            System.out.println(Arrays.toString(strArray).replaceAll("null"," "));
        }
    }

    public static void ballSpawn() {
        map[map.length / 8][map.length / 8] = "o";
    }

    public static Direction ballDirection() {
        int dir = rand.nextInt(4);
        return case1(dir);
    }

    public static Direction case1(int dir) {
        if (dir == 1) {
            return Direction.DIRECTION_NORTH;
        }
        return case2(dir);
    }

    public static Direction case2(int dir) {
        if (dir == 2) {
            return Direction.DIRECTION_EAST;
        }
        return case3(dir);
    }

    public static Direction case3(int dir) {
        if (dir == 3) {
            return Direction.DIRECTION_SOUTH;
        }
        return case4(dir);
    }

    public static Direction case4(int dir) {
        if (dir == 4) {
            return Direction.DIRECTION_WEST;
        }
        return null;
    }
    public static void checkDir(){

    }
}
