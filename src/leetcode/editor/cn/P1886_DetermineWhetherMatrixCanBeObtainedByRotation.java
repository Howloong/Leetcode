//给你两个大小为 n x n 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，如果能够使 mat 与 
//target 一致，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
//输出：true
//解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
// 
//
// 示例 2： 
//
// 
//输入：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
//输出：false
//解释：无法通过轮转矩阵中的元素使 equal 与 target 一致。
// 
//
// 示例 3： 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
//输出：true
//解释：顺时针轮转 90 度两次可以使 mat 和 target 一致。
// 
//
// 
//
// 提示： 
//
// 
// n == mat.length == target.length 
// n == mat[i].length == target[i].length 
// 1 <= n <= 10 
// mat[i][j] 和 target[i][j] 不是 0 就是 1 
// 
// Related Topics 数组 矩阵 👍 20 👎 0

package leetcode.editor.cn;

//Java：判断矩阵经轮转后是否一致
class P1886_DetermineWhetherMatrixCanBeObtainedByRotation {
    public static void main(String[] args) {
        Solution solution = new P1886_DetermineWhetherMatrixCanBeObtainedByRotation().new Solution();
        System.out.println(solution.findRotation(new int[][]{{0,1},{1,1}},new int[][]{{1,0},{0,1}}));
        System.out.println(solution.findRotation(new int[][]{{1,2},{3,4}},new int[][]{{3,1},{4,2}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            int count = 0;
            int n = mat[0].length;
            while (count < 4) {
                int[][] newMat = new int[n][n];
                boolean isSame = true;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        newMat[j][n - i - 1] = mat[i][j];
                        if (newMat[j][n - i - 1] != target[j][n - i - 1]) {
                            isSame = false;
                        }
                    }

                }
                if (isSame) {
                    return true;
                }
                mat = newMat;
                count++;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
