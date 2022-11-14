//给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。 
//
// 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含
//有大写和小写字母。 
//
// 如果 a 和 b 相似，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "book"
//输出：true
//解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
// 
//
// 示例 2： 
//
// 
//输入：s = "textbook"
//输出：false
//解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
//注意，元音 o 在 b 中出现两次，记为 2 个。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 1000 
// s.length 是偶数 
// s 由 大写和小写 字母组成 
// 
//
// Related Topics 字符串 计数 👍 32 👎 0

package leetcode.editor.cn;

//Java:判断字符串的两半是否相似
//Time:2022-11-11 10:44:03
class P1704_DetermineIfStringHalvesAreAlike {
    public static void main(String[] args) {
        Solution solution = new P1704_DetermineIfStringHalvesAreAlike().new Solution();
        System.out.println(solution.halvesAreAlike("book"));
        System.out.println(solution.halvesAreAlike("textbook"));
        System.out.println(solution.halvesAreAlike("AbCdEfGh"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean halvesAreAlike(String s) {
            int len = s.length() / 2;
            int sum = 0;
            for (int i = 0; i < len; i++) {
                switch (s.charAt(i)) {
                    case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> sum++;
                }
            }
            for (int i = len; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> sum--;

                }
            }
            return sum == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

