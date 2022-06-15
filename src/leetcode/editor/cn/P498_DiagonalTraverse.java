//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,4,7,5,3,6,8,9]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2],[3,4]]
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// -10⁵ <= mat[i][j] <= 10⁵ 
// 
// Related Topics 数组 矩阵 模拟 👍 351 👎 0


//Java：对角线遍历
class P498_DiagonalTraverse {
    public static void main(String[] args) {
        Solution solution = new P498_DiagonalTraverse().new Solution();
        solution.findDiagonalOrder(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int col = mat[0].length;
            int row = mat.length;
            int[] result = new int[row * col];
            int index = 0;
            int t = col + row - 1;
            for (int i = 0; i < t; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j <= i && j < col; j++) {
                        int r = i - j;
                        if (r >= row) {
                            continue;
                        }
                        result[index++] = mat[r][j];
                    }
                } else {
                    for (int j = 0; j <= i && j < row; j++) {
                        int r = i - j;
                        if (r >= col) {
                            continue;
                        }
                        result[index++] = mat[j][r];
                    }
                }
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
