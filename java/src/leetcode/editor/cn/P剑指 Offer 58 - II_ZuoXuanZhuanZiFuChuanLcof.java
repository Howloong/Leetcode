//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 数学 双指针 字符串 👍 261 👎 0

package leetcode.editor.cn.java;

//Java：左旋转字符串
class II_ZuoXuanZhuanZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new II_ZuoXuanZhuanZiFuChuanLcof().new Solution();
        System.out.println(solution.reverseLeftWords("abcdefg", 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*  public String reverseLeftWords(String s, int n) {
              StringBuilder sb = new StringBuilder(s.length());
              sb.append(s.substring(n));
              sb.append(s.substring(0, n));
              return sb.toString();
          }*/
        public String reverseLeftWords(String s, int n) {
            StringBuilder sb = new StringBuilder(s);
            swap(sb, 0, n - 1
            );
            swap(sb, n, s.length() - 1);
            swap(sb, 0, s.length() - 1);
            return sb.toString();
        }

        public void swap(StringBuilder sb, int start, int end) {
            while (start < end) {
                char t = sb.charAt(start);
                sb.setCharAt(start, sb.charAt(end));
                sb.setCharAt(end, t);
                ++start;
                --end;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
