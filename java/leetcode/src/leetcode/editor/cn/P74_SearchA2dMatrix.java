//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 706 👎 0

package leetcode.editor.cn;

//Java:搜索二维矩阵
//Time:2022-08-31 00:15:26
class P74_SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new P74_SearchA2dMatrix().new Solution();
        System.out.println(solution.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
//        System.out.println(solution.searchMatrix(new int[][]{{1},{3}}, 2));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int i = 0;
            if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1])
                return false;
            while (i < matrix.length) {
                if (matrix[i][0] <= target && matrix[i][matrix[0].length - 1] >= target) {
                    break;
                }
                i++;
            }
            if (i == matrix.length) {
                return false;
            }
            int left = 0;
            int right = matrix[i].length - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                int midVal = matrix[i][mid];
                if (midVal < target) {
                    left = mid + 1;
                } else if (midVal > target) {
                    right = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
//            return Arrays.binarySearch(matrix[i], target) >= 0;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
