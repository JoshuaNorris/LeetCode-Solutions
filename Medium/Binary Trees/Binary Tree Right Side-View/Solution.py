

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        else:
            parents: List[TreeNode] = [root]
            result = [root.val]
            return levelOrderRecursive(parents, result)



def levelOrderRecursive(parents: List[TreeNode], result: List[int]) -> List[int]:
    childrenNodes: List[TreeNode] = []
    childrenInts: List[int] = []

    for parent in parents:
        if hasLeft(parent):
            childrenNodes.append(parent.left)
            childrenInts.append(parent.left.val)
        if hasRight(parent):
            childrenNodes.append(parent.right)
            childrenInts.append(parent.right.val)
    if len(childrenInts) == 0:
        return result
    result.append(childrenInts[len(childrenInts) - 1])
    return (levelOrderRecursive( childrenNodes, result))


def hasRight(TreeNode):
    return not(TreeNode.right is None)

def hasLeft(TreeNode):
    return not(TreeNode.left is None)