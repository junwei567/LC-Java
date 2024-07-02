package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumIslands {

    // tuple class for x, y coordinates
    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(int r, int c, int[][] visited, char[][] grid) {
        Deque<Pair> q = new ArrayDeque<>(); // queue
        q.add(new Pair(r, c));
        visited[r][c] = 1;
        // 4 cardinal directions to search BFS
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};

        while (!q.isEmpty()) {
            int row = q.peek().x;
            int col = q.peek().y;
            q.remove();
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                // check cell is within bounds
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                        && grid[newRow][newCol] == '1' // check cell is part of an island
                        && visited[newRow][newCol] == 0) { // check cell has not been visited
                    q.add(new Pair(newRow, newCol));
                    visited[newRow][newCol] = 1;
                }
            }
        }
    }

    public int GetNumIslands(char[][] grid) {
        int islands = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    islands ++;
                    BFS(i, j, visited, grid);
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        char[][] array = {{'1','1','0'}, {'1','1','0'}, {'0','0','1'}};
        NumIslands numIslands = new NumIslands();
        System.out.println(numIslands.GetNumIslands(array));
    }
}
