//一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。 
//
// 
// 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。 
// 
//
// 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aabcb"
//输出：5
//解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。 
//
// 示例 2： 
//
// 
//输入：s = "aabcbaa"
//输出：17
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 只包含小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 计数 👍 39 👎 0

package leetcode.editor.cn.java;

import java.util.Arrays;

//Java:所有子字符串美丽值之和
//Time:2022-12-12 11:03:56
class P1781_SumOfBeautyOfAllSubstrings {
    public static void main(String[] args) {
        Solution solution = new P1781_SumOfBeautyOfAllSubstrings().new Solution();
//        System.out.println(solution.beautySum("aabcb"));
//        System.out.println(solution.beautySum("aabcbaa"));
        System.out.println(solution.beautySum("xzvfsppsjfbxdwkqe"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int beautySum(String s) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                int[] counts = new int[26];
                counts[s.charAt(i) - 'a']++;
                for (int j = i + 1; j < s.length(); j++) {
                    int m = s.charAt(j) - 'a';
                    counts[m]++;
                    int max = Arrays.stream(counts)
                            .max()
                            .getAsInt();
                    int min = Arrays.stream(counts)
                            .filter(x -> x != 0)
                            .min().getAsInt();
                    sum += (max - min);
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
