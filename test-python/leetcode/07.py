class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        rev =0
        INT_MIN, INT_MAX = -2**31, 2**31 - 1
        y=x
        while( x!=0 ):
            if rev < INT_MIN // 10 or rev > INT_MAX // 10:
                return 0
            if x < 0:
                x=-x
            digit = x % 10 # 求余数
            x =(x-digit) // 10
            rev = rev * 10 + digit

        if y > 0:
            return rev
        else:
            return -rev



print(Solution().reverse(912))      