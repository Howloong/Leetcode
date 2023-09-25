//给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。 
//
// 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [1,2,2,1,1,3]
//输出：true
//解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。 
//
// 示例 2： 
//
// 输入：arr = [1,2]
//输出：false
// 
//
// 示例 3： 
//
// 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// -1000 <= arr[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 👍 153 👎 0

package leetcode.editor.cn.java;

import java.util.HashMap;
import java.util.HashSet;

//Java:独一无二的出现次数
//Time:2022-10-03 20:37:29
class P1207_UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        Solution solution = new P1207_UniqueNumberOfOccurrences().new Solution();
        System.out.println(solution.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i : arr) {
                hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
            }
            return new HashSet<>(hashMap.values()).size() == hashMap.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
