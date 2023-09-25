//给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。 
//
// 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：text = "nlaebolko"
//输出：1
// 
//
// 示例 2： 
//
// 
//
// 输入：text = "loonbalxballpoon"
//输出：2
// 
//
// 示例 3： 
//
// 输入：text = "leetcode"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 10^4 
// text 全部由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 117 👎 0

package leetcode.editor.cn.java;

//Java:“气球” 的最大数量
//Time:2022-10-06 19:16:48
class P1189_MaximumNumberOfBalloons {
    public static void main(String[] args) {
        Solution solution = new P1189_MaximumNumberOfBalloons().new Solution();
        System.out.println(solution.maxNumberOfBalloons("loonbalxballpoon"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxNumberOfBalloons(String text) {
            int[] num = new int[5];
            int a = 0;
            int b = 0;
            int max = Integer.MAX_VALUE;
            for (char c : text.toCharArray()) {
                switch (c) {
                    case 'b' -> num[0]++;
                    case 'a' -> num[1]++;
                    case 'l' -> {
                        b++;
                        if (b % 2 == 0) {
                            num[2] = b / 2;
                        }
                    }
                    case 'o' -> {
                        a++;
                        if (a % 2 == 0) {
                            num[3] = a / 2;
                        }
                    }
                    case 'n' -> {
                        num[4]++;
                    }
                }
            }
            for (int i : num) {
                max = Math.min(max, i);
            }

            return max;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
