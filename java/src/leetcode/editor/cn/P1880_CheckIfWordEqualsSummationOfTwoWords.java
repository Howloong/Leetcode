//字母的 字母值 取决于字母在字母表中的位置，从 0 开始 计数。即，'a' -> 0、'b' -> 1、'c' -> 2，以此类推。 
//
// 对某个由小写字母组成的字符串 s 而言，其 数值 就等于将 s 中每个字母的 字母值 按顺序 连接 并 转换 成对应整数。 
//
// 
// 例如，s = "acb" ，依次连接每个字母的字母值可以得到 "021" ，转换为整数得到 21 。 
// 
//
// 给你三个字符串 firstWord、secondWord 和 targetWord ，每个字符串都由从 'a' 到 'j' （含 'a' 和 'j' ）的
//小写英文字母组成。 
//
// 如果 firstWord 和 secondWord 的 数值之和 等于 targetWord 的数值，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：firstWord = "acb", secondWord = "cba", targetWord = "cdb"
//输出：true
//解释：
//firstWord 的数值为 "acb" -> "021" -> 21
//secondWord 的数值为 "cba" -> "210" -> 210
//targetWord 的数值为 "cdb" -> "231" -> 231
//由于 21 + 210 == 231 ，返回 true
// 
//
// 示例 2： 
//
// 输入：firstWord = "aaa", secondWord = "a", targetWord = "aab"
//输出：false
//解释：
//firstWord 的数值为 "aaa" -> "000" -> 0
//secondWord 的数值为 "a" -> "0" -> 0
//targetWord 的数值为 "aab" -> "001" -> 1
//由于 0 + 0 != 1 ，返回 false 
//
// 示例 3： 
//
// 输入：firstWord = "aaa", secondWord = "a", targetWord = "aaaa"
//输出：true
//解释：
//firstWord 的数值为 "aaa" -> "000" -> 0
//secondWord 的数值为 "a" -> "0" -> 0
//targetWord 的数值为 "aaaa" -> "0000" -> 0
//由于 0 + 0 == 0 ，返回 true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= firstWord.length, secondWord.length, targetWord.length <= 8 
// firstWord、secondWord 和 targetWord 仅由从 'a' 到 'j' （含 'a' 和 'j' ）的小写英文字母组成。 
// 
//
// Related Topics 字符串 👍 11 👎 0

package leetcode.editor.cn.java;

//Java:检查某单词是否等于两单词之和
//Time:2022-09-18 22:26:18
class P1880_CheckIfWordEqualsSummationOfTwoWords {
    public static void main(String[] args) {
        Solution solution = new P1880_CheckIfWordEqualsSummationOfTwoWords().new Solution();
//        System.out.println(solution.isSumEqual("j", "j", "bi"));
        System.out.println(solution.isSumEqual("i", "g", "e"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
            int[] nums1 = new int[firstWord.length()];
            int[] nums2 = new int[secondWord.length()];
            int[] target = new int[targetWord.length()];
            for (int i = 0; i < firstWord.length(); i++) {
                nums1[i] = firstWord.charAt(i) - 'a';
            }
            for (int i = 0; i < secondWord.length(); i++) {
                nums2[i] = secondWord.charAt(i) - 'a';
            }
            for (int i = 0; i < targetWord.length(); i++) {
                target[i] = targetWord.charAt(i) - 'a';
            }
            return add(nums1, nums2, target);
        }

        public boolean add(int[] nums1, int[] nums2, int[] res) {
            if (nums1.length > nums2.length) {
                return add(nums2, nums1, res);
            }
            boolean carry = false;
            int len1 = nums1.length - 1;
            int len2 = nums2.length - 1;
            int len3 = res.length - 1;
            int m;
            while (len1 >= 0 && len2 >= 0 && len3 >= 0) {
                m = nums1[len1] + nums2[len2] + (carry ? 1 : 0);
                carry = m >= 10;
                if (res[len3] != m % 10) {
                    return false;
                }
                len3--;
                len2--;
                len1--;
            }
            while (len2 >= 0 && len3 >= 0) {
                m = nums2[len2] + (carry ? 1 : 0);
                carry = m >= 10;
                if (res[len3] != m % 10) {
                    return false;
                }
                len2--;
                len3--;
            }
            if (len3 >= 0 && res[len3] != (carry ? 1 : 0) || len3 < 0 && carry) {
                return false;
            }
            len3--;
            while (len3 >= 0) {
                if (res[len3] != 0) {
                    return false;
                }
                len3--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
