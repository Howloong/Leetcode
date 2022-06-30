//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
// Related Topics 数组 动态规划 👍 407 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Java：杨辉三角 II
class P119_PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new P119_PascalsTriangleIi().new Solution();
        System.out.println(solution.getRow(33));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> list = new ArrayList<>();
            int i;
            long n = 1;
            list.add(1);
            for (i = 0; i < rowIndex / 2; i++) {
                n = n*(rowIndex - i) / (i + 1);
                list.add((int)n);
            }
            for (int j = i+1; j <= rowIndex; j++) {
                list.add(list.get(rowIndex - j));
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
