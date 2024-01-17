class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0

        leftMaxDep=self.maxDepth(root=root.left)
        rightMaDep=self.maxDepth(root=root.right)

        return max(leftMaxDep,rightMaDep)+1

