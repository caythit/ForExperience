package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：Given a 2d grid map of '1's (land) and '0's (water),
 * count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/9
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem200 {
    /**
     * 01的二维数组中找出岛屿的数量
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;

        Integer cn = 0;
        boolean[][] isVisited = new boolean[row][col];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && isVisited[i][j] == false) {
                    cn++;
                    dfs(i, j, grid, isVisited);
                }
            }
        }
        return cn;
    }

    public void dfs(int i, int j, char[][] grid, boolean[][] isVisited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || isVisited[i][j] == true) {
            return;
        }
        isVisited[i][j] = true;
        dfs(i - 1, j, grid, isVisited);
        dfs(i, j - 1, grid, isVisited);
        dfs(i + 1, j, grid, isVisited);
        dfs(i, j + 1, grid, isVisited);
    }

    public static void main(String[] args) {
        Problem200 problem = new ProblemConstructBuilder<Problem200>(Problem200.class.getName()).build();
//        System.out.println(problem.numIslands(new char[][]{
//                {'1', '0', '1'}
//        }));
//        System.out.println(problem.numIslands(new char[][]{
//                {'1'},
//                {'0'},
//                {'1'}
//        }));
//
//        System.out.println(problem.numIslands(new char[][]{
//                {'0', '0', '0'},
//                {'0', '1', '0'},
//                {'0', '0', '0'}
//        }));

        System.out.println(problem.numIslands(new char[][]{
                {'1', '1', '0'},
                {'0', '0', '0'},
                {'0', '0', '1'}
        }));
        System.out.println(problem.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '0', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));

        System.out.println(problem.numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }
}
