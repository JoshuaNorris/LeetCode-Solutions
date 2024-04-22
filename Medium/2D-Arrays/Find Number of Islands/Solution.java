// https://leetcode.com/problems/number-of-islands/

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        // a 0 means it has not been visited, a 1 means it has

        int numberOfIslands = 0;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == '1' && !hasVisited(y, x, visited)) {
                    numberOfIslands ++;
                    visited[y][x] = 1;
                    visited = islandBFS(y, x, visited, grid);
                }


            }
        }
        return numberOfIslands;
    }

    private static int[][] islandBFS (int y, int x, int[][] visited, char[][] grid) {
        Queue<IntPair> queue = new LinkedList<>();
        while (true) {

            // check up
            if (y != 0 && grid[y - 1][x] == '1' && visited[y - 1][x] == 0) {
                IntPair this_cord = new IntPair(y-1, x);
                queue.offer(this_cord);
                visited[y-1][x] = 1;
            }
            // check right
            if (x != grid[0].length - 1 && grid[y][x + 1] == '1' && visited[y][x + 1] == 0) {
                IntPair this_cord = new IntPair(y, x+1);
                queue.offer(this_cord);
                visited[y][x+1] = 1;
            }
            // Check down
            if (y != grid.length - 1 && grid[y + 1][x] == '1' && visited[y + 1][x] == 0) {
                IntPair this_cord = new IntPair(y + 1, x);
                queue.offer(this_cord);
                visited[y+1][x] = 1;
            } 
            
            // Check left
            if (x != 0 && grid[y][x - 1] == '1' && visited[y][x - 1] == 0) {
                IntPair this_cord = new IntPair(y, x - 1);
                queue.offer(this_cord);
                visited[y][x-1] = 1;
            }

            if (queue.isEmpty()) {
                break;
            } else {
                IntPair next_node = queue.poll();
                x = next_node.getX();
                y = next_node.getY();
            }

        }
        return visited;
    }

    private static boolean hasVisited(int y, int x, int[][] visited) {
        return (1 == visited[y][x]);
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
