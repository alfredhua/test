class Solution(object):

    def isValid(self, s) -> bool:
        if not s or len(s) % 2 !=0:
            return False
        paris={')':'(','}':'{',']':'['}

        stack=[]
        for i in range(len(s)):
            c=s[i]
            if paris.__contains__(c):
                print(stack[-1],paris.get(c))
                if len(stack)==0 or stack[-1]!=paris.get(c):
                    return False
                stack.pop()
            else:
                stack.append(c)
        
        return len(stack)==0

print(Solution().isValid('[(([{()}]))]'))


