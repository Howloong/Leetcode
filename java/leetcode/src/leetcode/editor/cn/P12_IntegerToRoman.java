//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。 
//
// 
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + 
//II 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给你一个整数，将其转为罗马数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 3
//输出: "III" 
//
// 示例 2: 
//
// 
//输入: num = 4
//输出: "IV" 
//
// 示例 3: 
//
// 
//输入: num = 9
//输出: "IX" 
//
// 示例 4: 
//
// 
//输入: num = 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
// 
//
// 示例 5: 
//
// 
//输入: num = 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 3999 
// 
//
// Related Topics 哈希表 数学 字符串 👍 922 👎 0

package leetcode.editor.cn;

//Java:整数转罗马数字
//Time:2022-07-25 11:56:33
class P12_IntegerToRoman {
    public static void main(String[] args) {
        Solution solution = new P12_IntegerToRoman().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String intToRoman(int num) {
            if (num >= 1 && num <= 9) {
                return one(num);
            }
            if (num >= 10 && num <= 99) {
                return ten(num);
            }
            if (num >= 100 && num <= 999) {
                return hundred(num);
            }
            if (num >= 1000 && num <= 3999) {
                return thousand(num);
            }
            return null;
        }

        public String one(int num) {
            String str = "";
            switch (num) {
                case 1 -> str = "I";
                case 2 -> str = "II";
                case 3 -> str = "III";
                case 4 -> str = "IV";
                case 5 -> str = "V";
                case 6 -> str = "VI";
                case 7 -> str = "VII";
                case 8 -> str = "VIII";
                case 9 -> str = "IX";
            }
            return str;
        }

        public String ten(int num) {
            StringBuilder str = new StringBuilder();
            switch (num / 10) {
                case 1 -> str.append("X");
                case 2 -> str.append("XX");
                case 3 -> str.append("XXX");
                case 4 -> str.append("XL");
                case 5 -> str.append("L");
                case 6 -> str.append("LX");
                case 7 -> str.append("LXX");
                case 8 -> str.append("LXXX");
                case 9 -> str.append("XC");
            }
            return str.append(one(num % 10)).toString();
        }

        public String hundred(int num) {
            StringBuilder str = new StringBuilder();
            switch (num / 100) {
                case 1 -> str.append("C");
                case 2 -> str.append("CC");
                case 3 -> str.append("CCC");
                case 4 -> str.append("CD");
                case 5 -> str.append("D");
                case 6 -> str.append("DC");
                case 7 -> str.append("DCC");
                case 8 -> str.append("DCCC");
                case 9 -> str.append("CM");
            }
            return str.append(ten(num % 100)).toString();
        }

        public String thousand(int num) {
            StringBuilder str = new StringBuilder();
            switch (num / 1000) {
                case 1 -> str.append("M");
                case 2 -> str.append("MM");
                case 3 -> str.append("MMM");
                case 4 -> str.append("MMMM");
            }
            return str.append(hundred(num % 1000)).toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
