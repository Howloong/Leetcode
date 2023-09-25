//给定正整数 n，返回在 [1, n] 范围内具有 至少 1 位 重复数字的正整数的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 20
//输出：1
//解释：具有至少 1 位重复数字的正数（<= 20）只有 11 。
// 
//
// 示例 2： 
//
// 
//输入：n = 100
//输出：10
//解释：具有至少 1 位重复数字的正数（<= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
// 
//
// 示例 3： 
//
// 
//输入：n = 1000
//输出：262
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics 数学 动态规划 👍 153 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Java:至少有 1 位重复的数字
//Time:2023-03-20 09:36:49
class P1012_NumbersWithRepeatedDigits {
    public static void main(String[] args) {
        Solution solution = new P1012_NumbersWithRepeatedDigits().new Solution();
//        System.out.println(solution.numDupDigitsAtMostN(12));
        System.out.println(solution.numDupDigitsAtMostN(10));
        System.out.println(solution.numDupDigitsAtMostN(20));
        System.out.println(solution.numDupDigitsAtMostN(111));
        System.out.println(solution.numDupDigitsAtMostN(100));
        System.out.println(solution.numDupDigitsAtMostN(1000));
        System.out.println(solution.numDupDigitsAtMostN(23345));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] dp;
        HashMap<Integer, Integer> hashMap;
        int[] nums;
        int len;

        public int numDupDigitsAtMostN(int n) {
            if (n <= 10) {
                return 0;
            }
            init(n);//将len-1长度之前的所有 每位都不重复的数字的个数提前保存
            int res1 = pre(nums.length, nums[len - 1]);//假设n为2345,计算0-1999之间的个数
            int res2 = post(nums, len - 1, 1 << nums[len - 1]);//计算2000-2345之间的个数
            int t = 0;
            int m = 1;
            for (int num : nums) {//独立算一下2345是不是符合要求
                if (((t >> num) & 1) == 1) {
                    m = 0;
                }
                t += (1 << num);
            }
            return n - res2 - res1 + 1 - m;
        }

        private int post(int[] nums, int start, int now) {
            if (start == 0) {//到了结尾，返回0
                return 0;
            }
            int pos = start - 1;
            int count = 0;
            for (int i = 0; i < nums[pos]; i++) {//i要小于当前数字,比如2 3 45中的3,我们需要遍历0 1 2
                if (((now >> i) & 1) == 0) {//如果为之前已经出现的数字,比如在3之前2已经出现过,则舍弃
                    count++;
                }
            }
            for (int i = 0; i < pos; i++) {//计算之后位数,比如2345,上面计算的是小于3,这就保证了4 5 位置上的树可以在保证不重复的前提下随意取值
                count *= (10 - (len - pos) - i);
            }
            if (((now >> nums[pos]) & 1) == 1) {//如果当前位之前存在过,则没有必要向下进行
                return count;
            }
            return count + post(nums, start - 1, now + (1 << nums[pos]));
        }

        public int pre(int len, int end) {
            int res = 0;
            res += hashMap.get(len - 1);//先取到len-1位数之前的所有不重复数字
            int t = 1;
            if (t < end) {
                t = end - 1;
                int n = 9;
                while (len > 1) {
                    t *= (n--);
                    len--;
                }
                return t + res;
            }
            return res;
        }

        public void init(int n) {
            List<Integer> list = new ArrayList<>();
            while (n != 0) {
                list.add(n % 10);
                n /= 10;
            }
            nums = list.stream().mapToInt(Integer::intValue).toArray();
            len = nums.length;
            hashMap = new HashMap<>() {{
                put(1, 10);
                put(2, 91);
                put(3, 739);
                put(4, 5275);
                put(5, 32491);
                put(6, 168571);
                put(7, 712891);
                put(8, 2345851);
                put(9, 5611771);
            }};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
