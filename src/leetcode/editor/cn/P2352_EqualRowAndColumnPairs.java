//给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。 
//
// 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
//输出：1
//解释：存在一对相等行列对：
//- (第 2 行，第 1 列)：[2,7,7]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
//输出：3
//解释：存在三对相等行列对：
//- (第 0 行，第 0 列)：[3,1,2,2]
//- (第 2 行, 第 2 列)：[2,4,2,2]
//- (第 3 行, 第 2 列)：[2,4,2,2]
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 200 
// 1 <= grid[i][j] <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 矩阵 模拟 👍 35 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java:相等行列对
//Time:2023-06-06 09:16:37
class P2352_EqualRowAndColumnPairs {
    public static void main(String[] args) {
        Solution solution = new P2352_EqualRowAndColumnPairs().new Solution();
        System.out.println(solution.equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));
        System.out.println(solution.equalPairs(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int equalPairs(int[][] grid) {
            int n = grid.length;
            int res = 0;
            Set<Integer>[] setsRow = new Set[n];
            Set<Integer>[] setsCol = new Set[n];
            for (int i = 0; i < n; i++) {
                setsRow[i] = new HashSet<>();
                setsCol[i] = new HashSet<>();

                for (int j = 0; j < n; j++) {
                    setsRow[i].add(grid[i][j]);
                    setsCol[i].add(grid[j][i]);

                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    boolean flag = true;
                    if (setsRow[i].size() == setsCol[j].size()) {
                        for (int k = 0; k < n; k++) {
                            if (grid[i][k] != grid[k][j]) {
                                flag = false;
                                break;
                            }
                        }
                        res += flag ? 1 : 0;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
