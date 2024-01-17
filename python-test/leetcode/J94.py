class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right


class Solution:
    def inorderTraversal(self, root: TreeNode) -> list[int]:
        list=[]
        self.getNode(root,list)
        return list

    
    def getNode(self,root:TreeNode,list:list[int]):
        if not root:
            return
        self.getNode(root=root.left,list=list)
        list.append(root.val)
        self.getNode(root=root.right,list=list)
        