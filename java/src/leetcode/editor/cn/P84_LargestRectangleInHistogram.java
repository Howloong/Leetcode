//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2179 👎 0

package leetcode.editor.cn.java;

import java.util.ArrayDeque;

//Java:柱状图中最大的矩形
//Time:2022-10-01 18:43:26
class P84_LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new P84_LargestRectangleInHistogram().new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int len = heights.length;
            int[] newHeight = new int[len + 2];
            System.arraycopy(heights, 0, newHeight, 1, len);
            ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
            int max = 0;
            arrayDeque.push(0);
            for (int i = 1; i < newHeight.length; i++) {
                while (!arrayDeque.isEmpty() && newHeight[i] < newHeight[arrayDeque.peek()]) {
                    int h = arrayDeque.pop();
                    int w = i - arrayDeque.peek() - 1;
                    max = Math.max(max, newHeight[h] * w);
                    System.out.println(max);
                }
                arrayDeque.push(i);
            }
            return max;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
