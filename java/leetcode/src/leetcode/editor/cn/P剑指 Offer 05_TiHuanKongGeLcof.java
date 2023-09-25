//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 👍 298 👎 0

package leetcode.editor.cn;

//Java：替换空格
class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        System.out.println(solution.replaceSpace("We are happy."));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            char[] m = s.toCharArray();
            int len = 0;
            for (Character c :
                    m) {
                if (c == ' ') {
                    ++len;
                }
            }
            char[] c = new char[s.length() + len * 2];
            int j = 0;
            for (int i = 0; i < m.length; i++) {
                if (m[i] == ' ') {
                    c[j++] = '%';
                    c[j++] = '2';
                    c[j++] = '0';
                } else {
                    c[j++] = m[i];
                }
            }
            return new String(c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
