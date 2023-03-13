//给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。 
//
// 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。 
//
// 示例 1: 
//
// 
//输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K",
//"L","M"]
//
//输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
// 
//
// 示例 2: 
//
// 
//输入: ["A","A"]
//
//输出: []
// 
//
// 提示： 
//
// 
// array.length <= 100000 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 140 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Java: 字母与数字
//Time:2023-03-11 18:01:03
class FindLongestSubarrayLcci {
    public static void main(String[] args) {
        Solution solution = new FindLongestSubarrayLcci().new Solution();
        System.out.println(Arrays.toString(solution.findLongestSubarray(new String[]{"A", "1", "B", "C",
                "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"})));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findLongestSubarray(String[] array) {
            int n = array.length;
            Map<Integer, Integer> map = new HashMap<>() {{
                this.put(0, -1);
            }};
            int sum = 0;
            int max = 0;
            int start = -1;
            for (int i = 0; i < n; i++) {
                if (Character.isLetter(array[i].charAt(0))) {
                    sum++;
                } else {
                    sum--;
                }
                if (map.containsKey(sum)) {
                    int first = map.get(sum);
                    if (i - first > max) {
                        max = i - first;
                        start = first + 1;
                    }
                } else {
                    map.put(sum, i);
                }
            }
            return max == 0 ? new String[]{} : Arrays.copyOfRange(array, start, start + max);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
