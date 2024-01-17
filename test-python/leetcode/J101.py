class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.check(root.left,root.right)
    

    def check(self,q:TreeNode,p:TreeNode) -> bool:
        if not q and not p:
            return True
        if not q or not p:
            return False
        return q.val==p.val and self.check(q.left,p.right) and self.check(q.right,p.left)