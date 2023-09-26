# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def largestGoodInteger(self, num: str) -> str:
        ans = -1
        num = str(num)
        n = len(num)
        cnt = 1
        for idx in range(n - 1):
            if num[idx] == num[idx + 1]:
                cnt += 1
                if cnt == 3:
                    ans = max(ans, ord(num[idx]))
            else:
                cnt = 1

        return "" if ans == -1 else str(ans - ord("0")) * 3


# leetcode submit region end(Prohibit modification and deletion)
s = Solution
print(s.largestGoodInteger(s, "6777133339"))
print(s.largestGoodInteger(s, "2300019"))
print(s.largestGoodInteger(s, "42352338"))
