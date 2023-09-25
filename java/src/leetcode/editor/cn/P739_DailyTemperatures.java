//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics 栈 数组 单调栈 👍 1269 👎 0

package leetcode.editor.cn.java;

import java.util.ArrayDeque;

//Java:每日温度
//Time:2022-09-01 00:04:56
class P739_DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new P739_DailyTemperatures().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int len = temperatures.length;
            int[] res = new int[len];
            ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
            arrayDeque.push(0);
            for (int i = 1; i < len; i++) {
                while (!arrayDeque.isEmpty() && temperatures[i] > temperatures[arrayDeque.peek()]) {
                    res[arrayDeque.peek()] = i - arrayDeque.peek();
                    arrayDeque.pop();
                }
                arrayDeque.push(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
