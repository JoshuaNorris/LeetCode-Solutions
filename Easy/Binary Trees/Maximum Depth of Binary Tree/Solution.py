from typing import Optional


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right




class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if root is not None:
            return Solution.dfs(root, 1)
        else:
            return 0;
        

    def dfs (root: TreeNode, tail: int) -> int:
        if root.left!=None and root.right!=None:
            return max(Solution.dfs(root.left, tail + 1), Solution.dfs(root.right, tail + 1))
        elif root.left != None:
            return Solution.dfs(root.left, tail + 1)
        elif root.right != None:
            return Solution.dfs(root.right, tail + 1)
        else:
            return tail