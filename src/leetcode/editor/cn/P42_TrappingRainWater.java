//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3820 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;

//Java:接雨水
//Time:2022-09-21 19:51:34
class P42_TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new P42_TrappingRainWater().new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
//        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*       动态规划
                public int trap(int[] height) {
                    int len = height.length;
                    int[] left = new int[len];
                    int[] right = new int[len];
                    Arrays.fill(left, -1);
                    Arrays.fill(right, -1);
                    left[0] = height[0];
                    for (int i = 1; i < len; i++) {
                        left[i] = Math.max(height[i], left[i - 1]);
                    }
                    right[len - 1] = height[len - 1];
                    for (int i = len - 2; i >= 0; i--) {
                        right[i] = Math.max(height[i], right[i + 1]);
                    }
                    int sum = 0;
                    for (int i = 0; i < len; i++) {
                        if (left[i] == -1 || right[i] == -1) {
                            continue;
                        }
                        int res = Math.min(left[i], right[i]) - height[i];
                        sum += Math.max(res, 0);

                    }
                    return sum;
                }*/
        public int trap(int[] height) {
            ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
            int len = height.length;
            int[] res = new int[len];
            int sum = 0;
            arrayDeque.push(0);

            for (int i = 1; i < len; i++) {
                while (!arrayDeque.isEmpty() && height[i] > height[arrayDeque.peek()]) {
                    int mid = height[arrayDeque.pop()];
                    if (!arrayDeque.isEmpty()) {
                        int left = arrayDeque.pop();
                        sum += ((i - left - 1) * (Math.min(height[left], height[i]) - height[mid]));
                    }
                }
                arrayDeque.push(i);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
