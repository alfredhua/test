class Solution:
    def climbStaeirs(self, n: int) -> int:
        first =0
        second = 1
        result = 0
        for i in range(n+1):
            print(i)
            first = second
            second = result
            result = first +second
        
        return result


print(Solution().climbStaeirs(3))