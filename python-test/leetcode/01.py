
class Solution(object):
    """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
    """

    def twoSum(self,nums,target):
        for i in range(len(nums)):
            for j in range(i+1,len(nums)):
                if nums[i] + nums[j] ==target:
                    return i,j



class object():
    pass

print(Solution().twoSum(nums=[1,2,5,8,10],target=6))

