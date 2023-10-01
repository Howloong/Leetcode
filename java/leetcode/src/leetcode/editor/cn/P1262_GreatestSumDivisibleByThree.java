//给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,6,5,1,8]
//输出：18
//解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。 
//
// 示例 2： 
//
// 输入：nums = [4]
//输出：0
//解释：4 不能被 3 整除，所以无法选出数字，返回 0。
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3,4,4]
//输出：12
//解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 4 * 10^4 
// 1 <= nums[i] <= 10^4 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 229 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Java:可被三整除的最大和
//Time:2023-06-19 09:02:41
class P1262_GreatestSumDivisibleByThree {
    public static void main(String[] args) {
        Solution solution = new P1262_GreatestSumDivisibleByThree().new Solution();
//        System.out.println(solution.maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
//        System.out.println(solution.maxSumDivThree(new int[]{0}));
        System.out.println(solution.maxSumDivThree(new int[]{3, 1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumDivThree(int[] nums) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            int sum = 0;
            for (int num : nums) {
                sum += num;
                if (num % 3 == 1) {
                    list1.add(num);
                } else if (num % 3 == 2) {
                    list2.add(num);
                }
            }
            if (sum % 3 == 0) {
                return sum;
            }
            Collections.sort(list1);
            Collections.sort(list2);
            if (sum % 3 == 2) {
                var temp = list2;
                list2 = list1;
                list1 = temp;
            }
            int ans = list1.isEmpty() ? 0 : sum - list1.get(0);
            if (list2.size() >= 2) {
                ans = Math.max(ans, sum - list2.get(0) - list2.get(1));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
