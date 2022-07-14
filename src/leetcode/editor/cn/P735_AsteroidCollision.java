//给定一个整数数组 asteroids，表示在同一行的行星。 
//
// 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。 
//
// 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：asteroids = [5,10,-5]
//输出：[5,10]
//解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。 
//
// 示例 2： 
//
// 
//输入：asteroids = [8,-8]
//输出：[]
//解释：8 和 -8 碰撞后，两者都发生爆炸。 
//
// 示例 3： 
//
// 
//输入：asteroids = [10,2,-5]
//输出：[10]
//解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。 
//
// 
//
// 提示： 
//
// 
// 2 <= asteroids.length <= 10⁴ 
// -1000 <= asteroids[i] <= 1000 
// asteroids[i] != 0 
// 
// Related Topics 栈 数组 👍 301 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;

//Java：行星碰撞
class P735_AsteroidCollision {
    public static void main(String[] args) {
        Solution solution = new P735_AsteroidCollision().new Solution();
//        System.out.println(Arrays.toString(solution.asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(solution.asteroidCollision(new int[]{8,-8})));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
            for (int aster :
                    asteroids) {
                boolean alive = true;
                while (alive&&aster<0&&!arrayDeque.isEmpty()&&arrayDeque.peek()>0) {
                    alive = arrayDeque.peek() < -aster;
                    if (arrayDeque.peek() <= -aster) {
                        arrayDeque.pop();
                    }
                }
                if (alive) {
                    arrayDeque.push(aster);
                }
            }
            int[] result = new int[arrayDeque.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = arrayDeque.removeLast();
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
