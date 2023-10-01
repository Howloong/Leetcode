//如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 
//个字符。） 
//
// 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 
//pattern 匹配时， answer[i] 才为 true，否则为 false。 
//
// 
//
// 示例 1： 
//
// 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]
//, pattern = "FB"
//输出：[true,false,true,true,false]
//示例：
//"FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
//"FootBall" 可以这样生成："F" + "oot" + "B" + "all".
//"FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer". 
//
// 示例 2： 
//
// 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]
//, pattern = "FoBa"
//输出：[true,false,true,false,false]
//解释：
//"FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
//"FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
// 
//
// 示例 3： 
//
// 输出：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]
//, pattern = "FoBaT"
//输入：[false,true,false,false,false]
//解释： 
//"FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
// 
//
// 
//
// 提示： 
//
// 
// 1 <= queries.length <= 100 
// 1 <= queries[i].length <= 100 
// 1 <= pattern.length <= 100 
// 所有字符串都仅由大写和小写英文字母组成。 
// 
//
// Related Topics 字典树 双指针 字符串 字符串匹配 👍 76 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java:驼峰式匹配
//Time:2023-04-14 11:22:09
class P1023_CamelcaseMatching {
    public static void main(String[] args) {
        Solution solution = new P1023_CamelcaseMatching().new Solution();
        System.out.println(solution.camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"},
                "FB"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Boolean> camelMatch(String[] queries, String pattern) {
            List<Boolean> res = new ArrayList<>();
            for (String query : queries) {
                res.add(pattern(query, pattern));
            }
            return res;
        }

        public boolean pattern(String s, String p) {
            int j = 0;
            int k = 0;
            while (j < s.length() && k < p.length()) {
                char c = s.charAt(j);
                if (c == p.charAt(k)) {
                    j++;
                    k++;
                } else if (Character.isUpperCase(c)) {
                    return false;
                } else {
                    j++;
                }
            }
            while (j < s.length()) {
                if (Character.isUpperCase(s.charAt(j))) {
                    return false;
                }
                j++;
            }
            return k == p.length();
        }

/*        public List<Boolean> camelMatch(String[] queries, String pattern) {
            StringBuilder sb = new StringBuilder();
            sb.append("[a-z]*");
            List<Boolean> res = new ArrayList<>();
            for (char c : pattern.toCharArray()) {
                sb.append(c).append("[a-z]*");
            }
            for (String query : queries) {
                res.add(query.matches(sb.toString()));
            }
            return res;
        }*/
    }

//leetcode submit region end(Prohibit modification and deletion)

}
