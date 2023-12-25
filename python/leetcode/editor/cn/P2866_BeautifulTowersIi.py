from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumSumOfHeights(self, maxHeights: List[int]) -> int:
        n = len(maxHeights)
        suf = [0] * (n + 1)
        st = [n]
        s = 0
        for i in range(n - 1, -1, -1):
            x = maxHeights[i]
            while len(st) > 1 and x <= maxHeights[st[-1]]:
                j = st.pop()
                s -= maxHeights[j] * (st[-1])
            s += x * (maxHeights[-1] - i)
            suf[i]=s
            st.append(i)

# leetcode submit region end(Prohibit modification and deletion)
