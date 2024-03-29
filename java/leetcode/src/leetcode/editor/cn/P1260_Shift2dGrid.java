//给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。 
//
// 每次「迁移」操作将会引发下述活动： 
//
// 
// 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。 
// 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。 
// 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。 
// 
//
// 请你返回 k 次迁移操作后最终得到的 二维网格。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//输出：[[9,1,2],[3,4,5],[6,7,8]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
//输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
//输出：[[1,2,3],[4,5,6],[7,8,9]]
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m <= 50 
// 1 <= n <= 50 
// -1000 <= grid[i][j] <= 1000 
// 0 <= k <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 54 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Java：二维网格迁移
class P1260_Shift2dGrid {
    public static void main(String[] args) {
        Solution solution = new P1260_Shift2dGrid().new Solution();
//        System.out.println(solution.shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 9));
        System.out.println(solution.shiftGrid(new int[][]{{1}, {2}, {3}, {4}, {7}, {6}, {5}}, 23));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            k = k % (m * n);
            List<List<Integer>> result = new ArrayList<>(m);
            if (k == 0) {
                for (int[] i : grid
                ) {

                    result.add(new ArrayList<>(Arrays.stream(i).boxed().collect(Collectors.toList())));
                }
                return result;
            }
            int[] flat = new int[m * n];
            for (int i = 0; i < grid.length; i++) {
                System.arraycopy(grid[i], 0, flat, i * n, n);
            }

            int i = flat.length - k;
            int count = 1;
            List<Integer> list = new ArrayList<>();
            while (count <= flat.length) {
                list.add(flat[i]);
                if (count % n == 0) {
                    result.add(new ArrayList<>(list));
                    list.clear();
                }
                count++;
                i++;
                i = i % flat.length;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
