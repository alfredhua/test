class Solution:
    def maxSubArray(self, nums: list[int]) -> int:
        maxNum=nums[0]
        for i in range(len(nums)):
            num = 0
            for j in range(i,len(nums)):
                num = num+ nums[j]
                maxNum =max(num,maxNum)
        
        return maxNum
    
    def maxSubArray2(self, nums: list[int]) -> int:
        prex=0
        maxAns=nums[0]
        for i in nums:
            prex =max(prex+i,i)
            maxAns=max(maxAns,prex)
        
        return maxAns

