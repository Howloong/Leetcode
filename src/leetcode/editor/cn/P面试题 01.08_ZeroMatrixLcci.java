//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
//
// Related Topics 数组 哈希表 矩阵 👍 119 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;

//Java:零矩阵
//Time:2022-09-30 13:54:52
class ZeroMatrixLcci {
    public static void main(String[] args) {
        Solution solution = new ZeroMatrixLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();
            int m = matrix.length;
            int n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        rowSet.add(i);
                        colSet.add(j);
                    }
                }
            }
            for (Integer integer : rowSet) {
                Arrays.fill(matrix[integer], 0);
            }
            for (Integer integer : colSet) {
                for (int i = 0; i < m; i++) {
                    matrix[i][integer] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
