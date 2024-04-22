// https://leetcode.com/problems/detect-cycles-in-2d-grid/description/

class Solution {
    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int y=0; y<grid.length; y++) {
            for (int x=0; x<grid[0].length; x++) {
                if (!visited[y][x] && search(grid, grid[y][x], y, x, visited)) {
                    return true;
                }
                System.out.println("y " + y);
                System.out.println("x " + x);
                System.out.println("VISITED");
                printboolarray(visited);
                System.out.println("GRID");
                printchararray(grid);
            }
        }

        return false;
    }

    private static boolean search(char[][] grid, char target, int y, int x, boolean[][] visited) {
        // Base Cases
        if (y<0 || x<0|| y>=grid.length || x>=grid[0].length || grid[y][x]!=target) { return false; }
        if (visited[y][x]) { return true; }

        visited[y][x] = true;
        grid[y][x] = '#';

        boolean found = search(grid, target, y-1, x, visited) ||
                        search(grid, target, y, x+1, visited) ||
                        search(grid, target, y+1, x, visited) ||
                        search(grid, target, y, x-1, visited);
        grid[y][x] = target;
        return found;
    }
}