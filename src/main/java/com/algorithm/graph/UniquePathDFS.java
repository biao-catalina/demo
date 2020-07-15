package com.algorithm.graph;

import com.algorithm.leetcode.UniquePath;

public class UniquePathDFS {

    public static void main(String[] args) {
        UniquePathDFS u = new UniquePathDFS();

        int[][] array = {{1,0,0,0}, {0,0,0,0}, {0,0,0,2}};

        System.out.println(u.uniquePathsIII(array));
    }


    public int uniquePathsIII(int[][] grid) {

        int entryX = 0;
        int entryY = 0;
        int totalWalkable = 0;

        // quick O(m*n) exploration of grid to count total number of walkable cells along with finding the starting point
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 0){
                    totalWalkable++;
                } else if (grid[i][j] == 1){
                    entryX = i;
                    entryY = j;
                }
            }
        }

        // Initiates the depth first search
        return dfs(entryX, entryY, grid, grid.length, grid[0].length, 0, totalWalkable);
    }

    private int dfs(int posX, int posY, int[][] grid, int sizeX, int sizeY, int steps, int target){
        // Check bounds to make sure inputted coords are within the grid
        if (posX >= sizeX || posX < 0 || posY >= sizeY || posY < 0){
            return 0;
        }

        // If inputted coords are unwalkable then it just backs away and returns with no possible path
        if (grid[posX][posY] == -1){
            return 0;
        }

        // If inputted coords is the final square then it verifies the step count to see if we have explored all unwalked cells
        if (grid[posX][posY] == 2){
            // -1 since steps increments one final time after landing on the final cell, which isn't considered in the target value
            if (target == steps-1){
                // If valid, then the dfs search says that "this path is unique, add me to the total count"
                return 1;
            } else {
                // If still some unexplored cells, it backs away as the ending square needs to be the last square visited
                return 0;
            }
        }

        // If current square is walkable (or starting square when first calling this method)
        if (grid[posX][posY] == 0 || grid[posX][posY] == 1){
            // Temporarily sets the square to unwalkable so that the algorithm does not rewalk over the same square
            grid[posX][posY] = -1;

            // Conducts depth first search on all 4 directions, sums up the total number of unique paths produced from each direction
            int paths =
                    dfs(posX-1, posY, grid, sizeX, sizeY, steps+1, target) +
                            dfs(posX+1, posY, grid, sizeX, sizeY, steps+1, target) +
                            dfs(posX, posY-1, grid, sizeX, sizeY, steps+1, target) +
                            dfs(posX, posY+1, grid, sizeX, sizeY, steps+1, target);

            // Sets back the square to walkable after exploring this square so that other paths may use this square.
            grid[posX][posY] = 0;

            // Returns total number of paths available at this level in the call stack
            return paths;

        }

        return 0;
    }
}
