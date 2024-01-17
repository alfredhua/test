class Solution:
    def plusOne(self, digits: list[int]) -> list[int]:
        n = len(digits)-1
        for i in range(n,-1,-1):
            num = digits[i]
            a = num +1
            if a < 10 :
                digits[i] = a
                return digits
            else:
                digits[i]=0

        result=[]
        for i in range(len(digits)+1):
            if i == 0:
                result.append(1)
            else:
                result.append(0)
        
        return result




Solution().plusOne(digits=[1,2,3])