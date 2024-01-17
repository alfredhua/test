class Solution(object):
    def isPalindrome(self,x):
        if x<0:
            return False
        reverNum = 0
        first=x
        while x>0:
            reverNum = reverNum * 10 + x % 10 # 1  10+2 =12  121
            digit = x % 10
            x = ( x - digit) / 10 
        print(reverNum)
        if ( int(reverNum) == first or int(reverNum)/10 == first):
            return True
        else:
            return False

print(Solution().isPalindrome(x=121))          
