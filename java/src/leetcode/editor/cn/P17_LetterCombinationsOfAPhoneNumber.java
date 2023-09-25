//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1991 👎 0

package leetcode.editor.cn.java;

import java.util.ArrayList;
import java.util.List;

//Java：电话号码的字母组合
class P17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17_LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String[] strings;
        List<String> list;
        StringBuilder path;

        public List<String> letterCombinations(String digits) {
            strings = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            list = new ArrayList<>();
            path = new StringBuilder();
            if (digits.equals("")) {
                return list;
            }
            backTracking(0, digits);
            return list;
        }

        public void backTracking(int index, String str) {
            if (index == str.length()) {
                list.add(path.toString());
                return;
            }
            String s = strings[str.charAt(index) - '0'];
            for (int i = 0; i < s.length(); i++) {
                path.append(s.charAt(i));
                backTracking(index + 1, str);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
