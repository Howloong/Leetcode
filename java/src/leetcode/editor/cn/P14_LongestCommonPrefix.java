//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 2296 👎 0

package leetcode.editor.cn.java;

//Java：最长公共前缀
class P14_LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14_LongestCommonPrefix().new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while (!strs[i].startsWith(prefix)) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                }
                if (prefix.equals("")) {
                    return "";
                }

            }
            return prefix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
