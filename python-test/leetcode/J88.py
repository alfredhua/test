class Solution:
    def merge(self, nums1: list[int], m: int, nums2: list[int], n: int) -> None:
        p1=0
        p2=0
        result=[]
        while p1 < m or p2 < n :
            print(p1,p2)
            if p1 == m :
                result.append(nums2[p2])
                p2=p2+1
            elif p2 == n :
                result.append(nums1[p1])
                p1=p1+1
            elif nums1[p1] < nums2[p2] :
                result.append(nums1[p1])
                p1=p1+1
            else:
                result.append(nums2[p2])
                p2=p2+1
        for i in range(len(result)):
            nums1[i]=result[i]
        
print(Solution().merge([1,2,3,0,0,0],3,[1,2,3],3))


    