class Solution:
    def searchInsert(self, nums: list[int], target: int) -> int:
        n = len(nums)
        left=0
        right = n-1
        ans = n
        while left<=right:
            mid = left +(right-left)//2
            if nums[mid] < target:
                left=mid+1
            else:
                ans = mid
                right = mid-1
        
        return ans


print(Solution().searchInsert([1,3,5,6],7))