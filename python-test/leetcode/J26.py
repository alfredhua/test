class Solution:
    def removeDuplicates(self, nums: list[int]) -> int:
        preIndex=0
        nextIndex=1
        for i in range(len(nums)):
            while nextIndex <len(nums):
                if nums[preIndex] == nums[nextIndex]:
                    nextIndex=nextIndex+1
                else:
                    temp=nums[preIndex+1]
                    nums[preIndex+1] = nums[nextIndex]
                    nums[nextIndex]=temp
                    nextIndex=nextIndex+1
                    preIndex=preIndex+1
        return preIndex+1


