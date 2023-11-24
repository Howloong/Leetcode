# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def entityParser(self, text: str) -> str:
        n = len(text)
        ans = ''
        _dict = {"&quot;": '"', "&apos;": "'", "&amp;": "&", "&gt;": ">", "&lt;": "<", "&frasl;": "/"}
        i = 0
        while i < n:
            if text[i] == '&':
                replaced = False
                for j in range(i + 1, n):
                    if text[j] == ';':
                        t = text[i:j + 1]
                        if t in _dict:
                            ans += _dict.get(t)
                            replaced = True
                            i = j + 1
                            break
                if not replaced:
                    ans += '&'
                    i += 1
            else:
                ans += text[i]
                i += 1
        return ans


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().entityParser("&amp; is an HTML entity but &ambassador; is not."))
print(Solution().entityParser("and I quote: &quot;...&quot;"))
