from collections import Counter, deque


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def repeatLimitedString(self, s: str, repeatLimit: int) -> str:
        c = Counter(s)
        c = sorted(c.items(), key=lambda x: x[0], reverse=True)
        c = deque(c)
        ans = ""
        while c:
            char, time = c.popleft()
            if time > repeatLimit and c:
                char2, time2 = c.popleft()
                if time2 > 1:
                    c.appendleft((char2, time2 - 1))
                c.appendleft((char, time - repeatLimit))
                c.appendleft((char2, 1))
            ans += char * min(time, repeatLimit)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
print(Solution().repeatLimitedString("aababab", 2))
print(Solution().repeatLimitedString("cczazcc", 3))
