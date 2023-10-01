//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 1709 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//Java：滑动窗口最大值
class P239_SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new P239_SlidingWindowMaximum().new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
//        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] res = new int[nums.length - k + 1];
            MonotonicQueue monotonicQueue = new MonotonicQueue(k);
            for (int i = 0; i < k; i++) {
                monotonicQueue.offer(nums[i]);
            }
            res[0] = monotonicQueue.peek();
            for (int i = k; i < nums.length; i++) {
                monotonicQueue.poll(nums[i - k]);
                monotonicQueue.offer(nums[i]);
                res[i - k + 1] = monotonicQueue.peek();
            }
            return res;
        }
    }

    class MonotonicQueue {
        private Deque<Integer> deque;

        public MonotonicQueue(int k) {
            this.deque = new ArrayDeque<>(k);
        }

        public int peek() {
            return deque.peek();
        }

        public void offer(int num) {
            while (!deque.isEmpty() && deque.peekLast() < num) {
                deque.pollLast();
            }
            deque.offer(num);
        }

        public void poll(int num) {
            if (deque.peek() == num) {
                deque.poll();
            }
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}
