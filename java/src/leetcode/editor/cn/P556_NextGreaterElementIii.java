//给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。 
//
// 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：21
// 
//
// 示例 2： 
//
// 
//输入：n = 21
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 数学 双指针 字符串 👍 237 👎 0

package leetcode.editor.cn.java;

//Java：下一个更大元素 III
class P556_NextGreaterElementIii {
    public static void main(String[] args) {
        Solution solution = new P556_NextGreaterElementIii().new Solution();
//        System.out.println(solution.nextGreaterElement(21));
//        System.out.println(solution.nextGreaterElement(12));
        System.out.println(solution.nextGreaterElement(2147483486));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nextGreaterElement(int n) {
            StringBuilder s = new StringBuilder(n + "");
            int i = s.length() - 1;
            int j = i;
            boolean flag = false;
            while (j > 0) {
                if (s.charAt(j) <= s.charAt(j - 1)) {
                    --j;
                    continue;
                }
                int t = j;
                int min = Integer.MAX_VALUE;
                while (i >= j) {
                    if (s.charAt(j - 1) < s.charAt(i)) {
                        if (s.charAt(i) < min) {
                            min = s.charAt(i);
                            t = i;
                        }
                    }
                    --i;
                }
                char temp = s.charAt(j - 1);
                s.setCharAt(j - 1, s.charAt(t));
                s.setCharAt(t, temp);
                i = s.length() - 1;
                while (j < i) {
                    temp = s.charAt(i);
                    s.setCharAt(i, s.charAt(j));
                    s.setCharAt(j, temp);
                    --i;
                    ++j;
                }
                flag = true;
                break;
            }
            return flag && Long.parseLong(s.toString()) <= Integer.MAX_VALUE ? Integer.parseInt(s.toString()) : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
