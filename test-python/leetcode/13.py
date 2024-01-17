class Solution(object):
    
    SYMBOL_VALUES = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000,
    }

    def romanToInt(self,s):
        ans =0
        n =len(s)
        for i in range(n):
            value =Solution.SYMBOL_VALUES[s[i]]
            print(i,n)
            if i<n-1 and value < Solution.SYMBOL_VALUES[s[i+1]]:
                ans -=value
            else:
                ans +=value
        return ans

print(Solution().romanToInt('IV'))
