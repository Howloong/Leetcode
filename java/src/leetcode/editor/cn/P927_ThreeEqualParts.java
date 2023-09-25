//给定一个由 0 和 1 组成的数组
//
// arr ，将数组分成 3 个非空的部分 ，使得所有这些部分表示相同的二进制值。 
//
// 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来： 
//
// 
// arr[0], arr[1], ..., arr[i] 为第一部分； 
// arr[i + 1], arr[i + 2], ..., arr[j - 1] 为第二部分； 
// arr[j], arr[j + 1], ..., arr[arr.length - 1] 为第三部分。 
// 这三个部分所表示的二进制值相等。 
// 
//
// 如果无法做到，就返回 [-1, -1]。 
//
// 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以 [0,
//1,1] 和 [1,1] 表示相同的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,0,1,0,1]
//输出：[0,3]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,1,0,1,1]
//输出：[-1,-1] 
//
// 示例 3: 
//
// 
//输入：arr = [1,1,0,0,1]
//输出：[0,2]
// 
//
// 
//
// 提示： 
// 
//
// 
// 3 <= arr.length <= 3 * 10⁴ 
// arr[i] 是 0 或 1 
// 
//
// Related Topics 数组 数学 👍 133 👎 0

package leetcode.editor.cn.java;

//Java:三等分
//Time:2022-10-06 13:29:55
class P927_ThreeEqualParts {
    public static void main(String[] args) {
        Solution solution = new P927_ThreeEqualParts().new Solution();
//        System.out.println(Arrays.toString(solution.threeEqualParts(new int[]{1, 0, 1, 0, 1})));
//        System.out.println(Arrays.toString(solution.threeEqualParts(new int[]{1, 1, 0, 1, 1})));
//        System.out.println(Arrays.toString(solution.threeEqualParts(new int[]{1, 1, 0, 0, 1})));
//        System.out.println(Arrays.toString(solution.threeEqualParts(new int[]{0, 1, 0, 1, 1})));
//        System.out.println(Arrays.toString(solution.threeEqualParts(new int[]{1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0,0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0})));
//        System.out.println(Arrays.toString(solution.threeEqualParts(new int[]{1, 1, 0, 1, 1, 1, 0, 1})));
//        System.out.println(Arrays.toString(solution.threeEqualParts(new int[]{1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0})));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] threeEqualParts(int[] arr) {
            int oneCount = 0;
            for (int i : arr) {
                oneCount += i;
            }
            int len = arr.length;
            if (oneCount % 3 != 0) {
                return new int[]{-1, -1};
            }
            if (oneCount == 0) {
                return new int[]{0, len - 1};
            }
            oneCount /= 3;
            int i = 0;
            int sum = 0;
            while (i < arr.length) {
                sum += arr[i];
                if (sum == oneCount) {
                    break;
                }
                i++;
            }
            int j = i + 1;
            sum = 0;
            int zeroCount = 0;
            while (j < arr.length) {
                sum += arr[j];
                if (sum == oneCount) {
                    break;
                }
                j++;
            }
            int k = len - 1;
            while (arr[k] != 1) {
                zeroCount++;
                k--;
            }
            int a = 0, b = i + 1, c = j + 1;
            while (arr[a] == 0) {
                a++;
            }
            while (arr[b] == 0) {
                b++;
            }
            while (arr[c] == 0) {
                c++;
            }
            while (a <= i + zeroCount) {
                if (arr[a] == arr[b] && arr[b] == arr[c]) {
                    a++;
                    b++;
                    c++;
                } else
                    return new int[]{-1, -1};

            }
            return new int[]{i + zeroCount, j + zeroCount + 1};
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
