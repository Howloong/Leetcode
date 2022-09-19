//给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。 
//
// 请你返回排序后的数组。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,2,2,2,3]
//输出：[3,1,1,2,2,2]
//解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,3,1,3,2]
//输出：[1,3,3,2,2]
//解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
// 
//
// 示例 3： 
//
// 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
//输出：[5,-1,4,4,-6,-6,1,1,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// -100 <= nums[i] <= 100 
// 
//
// Related Topics 数组 哈希表 排序 👍 68 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java:按照频率将数组升序排序
//Time:2022-09-19 09:57:13
class P1636_SortArrayByIncreasingFrequency {
    public static void main(String[] args) {
        Solution solution = new P1636_SortArrayByIncreasingFrequency().new Solution();
        System.out.println(Arrays.toString(solution.frequencySort(new int[]{2,3,1,3,2})));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] frequencySort(int[] nums) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int num : nums) {
                treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
            }
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(treeMap.entrySet());
            list.sort((a,b)-> Objects.equals(a.getValue(), b.getValue()) ? b.getKey() - a.getKey() :
                    a.getValue() - b.getValue());
            int i = 0;
            int j = 0;
            while (i < nums.length) {
                Map.Entry<Integer, Integer> entry = list.get(j);
                for (int k = 0; k < entry.getValue(); k++,i++) {
                    nums[i] = entry.getKey();
                }
                j++;
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
