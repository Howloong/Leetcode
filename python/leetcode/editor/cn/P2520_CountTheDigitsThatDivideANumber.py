# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countDigits(self, num: int) -> int:
        t = []
        tmp = num
        while tmp:
            t.append(tmp % 10)
            tmp //= 10
        res=0
        for i in t:
            if num%i==0:
                res+=1
        return res
# leetcode submit region end(Prohibit modification and deletion)
print(Solution().countDigits(7))
print(Solution().countDigits(121))
print(Solution().countDigits(1248))