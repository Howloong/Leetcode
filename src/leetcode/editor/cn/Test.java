package leetcode.editor.cn;

import java.io.IOException;
import java.util.HashMap;

/**
 * @ClassName: Test
 * @Package: leetcode.editor.cn
 * @Description:
 * @Datetime: 2022/8/16   18:09
 * @Author: YuHan.Kang@outlook.com
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Solution solution = new Test().new Solution();
    }


    class Solution {
        public int numberOfPairs(int[] nums) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            long res = 0;
            for (int num : nums) {
                int temp = Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());
                hashMap.put(num - temp, hashMap.getOrDefault(num - temp, 0) + 1);
            }
            long mod = (long) 10e9 + 7;
            for (Integer value : hashMap.values()) {
                Long v = Long.valueOf(value);
                v = ((v - 1) * v / 2) % mod;
//                value = (value - 1) * value / 2;
                res = (res + v) % mod;
            }
            return (int) res;
        }
    }

}
