//在二维网格 grid 上，有 4 种类型的方格： 
//
// 
// 1 表示起始方格。且只有一个起始方格。 
// 2 表示结束方格，且只有一个结束方格。 
// 0 表示我们可以走过的空方格。 
// -1 表示我们无法跨越的障碍。 
// 
//
// 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。 
//
// 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。 
//
// 
//
// 示例 1： 
//
// 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
//输出：2
//解释：我们有以下两条路径：
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2) 
//
// 示例 2： 
//
// 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
//输出：4
//解释：我们有以下四条路径： 
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
//2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
//3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
//4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3) 
//
// 示例 3： 
//
// 输入：[[0,1],[2,0]]
//输出：0
//解释：
//没有一条路能完全穿过每一个空的方格一次。
//请注意，起始和结束方格可以位于网格中的任意位置。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length * grid[0].length <= 20 
// 
//
// Related Topics 位运算 数组 回溯 矩阵 👍 324 👎 0

package leetcode.editor.cn;

//Java:不同路径 III
//Time:2023-08-22 15:20:34
class P980_UniquePathsIii {
    public static void main(String[] args) {
        Solution solution = new P980_UniquePathsIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int result = 0;
        public int total;
        public int[][] direct = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        public boolean[][] used;

        public int uniquePathsIII(int[][] grid) {
            used = new boolean[grid.length][grid[0].length];
            int startI = 0;
            int startJ = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0) {
                        total++;
                    } else if (grid[i][j] == 1) {
                        startI = i;
                        startJ = j;
                        used[i][j] = true;
                    } else if (grid[i][j] == -1) {
                        used[i][j] = true;
                    }
                }
            }
            dfs(grid, 0, startI, startJ);
            return result;
        }

        public void dfs(int[][] grid, int sum, int row, int col) {
            if (grid[row][col] == 2) {
                if (sum == total + 1) {
                    result++;
                }
                return;
            }
            for (int k = 0; k < direct.length; k++) {
                int newI = row + direct[k][0];
                int newJ = col + direct[k][1];
                if (newI >= 0 && newI < grid.length
                        && newJ >= 0 && newJ < grid[0].length
                        && !used[newI][newJ]) {
                    used[newI][newJ] = true;
                    dfs(grid, sum + 1, newI, newJ);
                    used[newI][newJ] = false;
                }
            }


        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
