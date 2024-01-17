class Solution(object):
    def longestCommonPrefix(self, strs):
        if not strs:
            return ""

        prex=strs[0]
        count = len(strs)
        for i in range(1,count):
            prex=self.get_prex(prex,strs[i])
            if not prex:
                break
        return prex
           
    def get_prex(self,prex,u):
        index = 0
        length=min(len(prex),len(u))
        while index<length and prex[index] ==u[index]:
            index+=1
        print(index)
        return prex[0:index]


print(Solution().longestCommonPrefix(["flower","flow","fl1ght"]))

        


