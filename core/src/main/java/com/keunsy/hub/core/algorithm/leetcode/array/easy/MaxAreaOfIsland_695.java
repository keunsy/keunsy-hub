package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * https://leetcode.com/problems/max-area-of-island/description/
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 *
 * Example 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 *
 * 说明：0表示海，1表示到，求最大的连接的岛屿。
 * 采用DFS算法（递归）：从一个点开始查询其所有相邻的点以及其相邻点的相邻部分，并标记该点已经被查询过，以此类推查出最大的数量
 */
public class MaxAreaOfIsland_695 {


  public static void main(String[] args) {
//    int nums[][] = {
//            {0, 1, 1, 0, 0},
//            {0, 0, 1, 1, 0},
//            {0, 1, 1, 1, 0},
//            {1, 0, 0, 0, 0},
//            {0, 0, 1, 1, 0}
//    };
    int nums[][] = {
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    };

    System.out.println(func(nums));
  }

  private static int func(int[][] nums) {

    int maxIsland = 0;
    int m = nums.length;
    int n = nums[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (nums[i][j] == 1) {//当前是岛屿方才进行搜索
          int area = searchIsland2(nums, m, n, i, j);
          maxIsland = Math.max(maxIsland, area);
        }
      }
    }

    return maxIsland;

  }

  private static int searchIsland(int[][] nums, int m, int n, int i, int j, int area) {
    if (i < 0 || i >= m || j < 0 || j >= n || nums[i][j] == 0) {//查询结束条件
      return area;
    }
    nums[i][j] = 0;//搜索过的标记为0
    area++;//符合条件，加上1

    area = searchIsland(nums, m, n, i - 1, j, area);
    area = searchIsland(nums, m, n, i + 1, j, area);
    area = searchIsland(nums, m, n, i, j - 1, area);
    area = searchIsland(nums, m, n, i, j + 1, area);

    return area;
  }


  /**
   * 优化版本
   */
  private static int searchIsland2(int[][] nums, int m, int n, int i, int j) {
    if (i < 0 || i >= m || j < 0 || j >= n || nums[i][j] == 0) {//查询结束条件
      return 0;
    }
    nums[i][j] = 0;//搜索过的标记为0
    //1表示 区域加上1
    return 1 + searchIsland2(nums, m, n, i - 1, j) + searchIsland2(nums, m, n, i + 1, j) + searchIsland2(nums, m, n, i, j - 1) + searchIsland2(nums, m, n, i, j + 1);
  }


  /**
   * dfs 算法解题
   */
  public int maxAreaOfIsland(int[][] grid) {
    int m = grid.length, n = grid[0].length, maxarea = 0;
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        maxarea = Math.max(maxarea, dfs(i, j, grid));
    return maxarea;
  }

  /**
   * grid[i][j]-- 表示标识已经搜索过的，本身值为1 表示累加此值
   */
  private int dfs(int i, int j, int[][] grid) {
    return (i < 0 || grid.length <= i || j < 0 || grid[0].length <= j || grid[i][j] <= 0) ? 0
            : grid[i][j]-- + dfs(i, j + 1, grid) + dfs(i + 1, j, grid) + dfs(i, j - 1, grid) + dfs(i - 1, j, grid);
  }

}
