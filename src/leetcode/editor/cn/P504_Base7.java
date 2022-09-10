//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: num = -7
//输出: "-10"
// 
//
// 
//
// 提示： 
//
// 
// -10⁷ <= num <= 10⁷ 
// 
//
// Related Topics 数学 👍 188 👎 0

package leetcode.editor.cn;

//Java:七进制数
//Time:2022-09-10 22:23:40
class P504_Base7 {
    public static void main(String[] args) {
        Solution solution = new P504_Base7().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }
            if (num < 0) {
                return "-" + convert(-num);
            } else {
                return convert(num);
            }
        }

        public String convert(int num) {
            StringBuilder sb = new StringBuilder();
            while (num != 0) {
                sb.insert(0, num % 7);
                num /= 7;
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
