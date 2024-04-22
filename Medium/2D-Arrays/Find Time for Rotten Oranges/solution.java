// https://leetcode.com/problems/rotting-oranges/?source=submission-noac

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<ArrayList<IntPair>> queue = new LinkedList<>();
        int[][] visited = new int[grid.length][grid[0].length];
        ArrayList<IntPair> layer0 = new ArrayList();
        
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 2) {
                    IntPair rotten_orange = new IntPair(y, x);
                    visited[y][x] = 1;
                    layer0.add(rotten_orange);
                }
            }
        }

        queue.offer(layer0);
        return bfsOranges(queue, grid, visited);

    }

    private static int bfsOranges(Queue<ArrayList<IntPair>> queue, int[][] grid, int[][] visited) {
        int layer = 0;
        while (true) {
            ArrayList<IntPair> this_layer = queue.poll();
            ArrayList<IntPair> next_layer = new ArrayList();
            for (IntPair orange : this_layer) {
                // check Up
                if (orange.getY() != 0 && visited[orange.getY() - 1][orange.getX()] == 0) {
                    if (grid[orange.getY() - 1][orange.getX()] == 1) {
                        IntPair next_node = new IntPair(orange.getY() - 1, orange.getX());
                        next_layer.add(next_node);
                        grid[orange.getY() - 1][orange.getX()] = 2;
                    }
                    visited[orange.getY() - 1][orange.getX()] = 1;
                }
                
                // check Right

                if (orange.getX() != grid[0].length-1 && visited[orange.getY()][orange.getX() + 1] == 0) {
                    if (grid[orange.getY()][orange.getX() + 1] == 1) {
                        IntPair next_node = new IntPair(orange.getY(), orange.getX() + 1);
                        next_layer.add(next_node);
                        grid[orange.getY()][orange.getX() + 1] = 2;
                    }
                    visited[orange.getY()][orange.getX() + 1] = 1;
                }
                // check Down

                if (orange.getY() != grid.length-1 && visited[orange.getY() + 1][orange.getX()] == 0) {
                    if (grid[orange.getY() + 1][orange.getX()] == 1) {
                        IntPair next_node = new IntPair(orange.getY() + 1, orange.getX());
                        next_layer.add(next_node);
                        grid[orange.getY() + 1][orange.getX()] = 2;
                    }
                    visited[orange.getY() + 1][orange.getX()] = 1;
                }

                // check Left
                if (orange.getX() != 0 && visited[orange.getY()][orange.getX() - 1] == 0) {
                    if (grid[orange.getY()][orange.getX() - 1] == 1) {
                        IntPair next_node = new IntPair(orange.getY(), orange.getX() - 1);
                        next_layer.add(next_node);
                        grid[orange.getY()][orange.getX() - 1] = 2;
                    }
                    visited[orange.getY()][orange.getX() - 1] = 1;
                }
            }
            if (next_layer.isEmpty()) {
                break;
            } else {
                layer ++;
                queue.offer(next_layer);

            }
        }
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 1) {
                    return -1;
                }
            }
        }
        return layer;
    }

    private static void printArray(int[][] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}



class IntPair {
    private int y;
    private int x;

    public IntPair(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "(" + y + ", " + x + ")";
    }
}