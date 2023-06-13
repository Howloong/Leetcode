//给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 元素各不相同的 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的
//元素可以按 任意 顺序排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
//输出：[3,2]
//解释：至少在两个数组中出现的所有值为：
//- 3 ，在全部三个数组中都出现过。
//- 2 ，在数组 nums1 和 nums2 中出现过。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
//输出：[2,3,1]
//解释：至少在两个数组中出现的所有值为：
//- 2 ，在数组 nums2 和 nums3 中出现过。
//- 3 ，在数组 nums1 和 nums2 中出现过。
//- 1 ，在数组 nums1 和 nums3 中出现过。
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
//输出：[]
//解释：不存在至少在两个数组中出现的值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length, nums3.length <= 100 
// 1 <= nums1[i], nums2[j], nums3[k] <= 100 
// 
//
// Related Topics 数组 哈希表 👍 41 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java:至少在两个数组中出现的值
//Time:2022-12-29 11:54:24
class P2032_TwoOutOfThree {
    public static void main(String[] args) {
        Solution solution = new P2032_TwoOutOfThree().new Solution();
//        System.out.println(solution.twoOutOfThree(new int[]{1, 1, 3, 2}, new int[]{2, 3}, new int[]{3}));
        System.out.println(solution.twoOutOfThree(new int[]{1, 2, 2}, new int[]{4, 3, 3}, new int[]{5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i : nums1) {
                map.put(i, 1);
            }
            for (int i : nums2) {
                map.put(i, map.getOrDefault(i, 0) | 2);
            }
            for (int i : nums3) {
                map.put(i, map.getOrDefault(i, 0) | 4);
            }
            List<Integer> res = new ArrayList<Integer>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int k = entry.getKey(), v = entry.getValue();
                if ((v & (v - 1)) != 0) {
                    res.add(k);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
