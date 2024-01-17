class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if haystack == needle:
            return 0
        for i in range(len(haystack)):
            print(haystack[i:i+len(needle)])
            if haystack[i:i+len(needle)] == needle:
                return i
        
        return -1


print(Solution().strStr("hello","ll"))