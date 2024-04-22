/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.lang.Math;


class Solution {
    public int countNodes(TreeNode root) {
        if (isNull(root)) {
            return 0;
        }
        // I might need to add a case of there just being one layer past the root
        int farRight = countRight(root);
        int farLeft = countLeft(root);
        int xcord = (int) Math.pow(2, farLeft);

        if (farRight == farLeft) {
            return calculateNumberOfNodesForCompleteLayers(farRight);
        }

        return countNodesTailRecursion(root, farRight, farLeft, 1, xcord);
    }

    private int countNodesTailRecursion (TreeNode root, int farRight, int farLeft, int layer, int xcord) {
        if (farRight == 0 && farLeft == 0) {
            int result = calculateNumberOfNodesForCompleteLayers(layer);
            return result;
        } else if (farRight == 0 && farLeft == 1) {
            xcord --;
            int result = calculateNumberOfNodesForCompleteLayers(layer - 1) + xcord;
            return result;
        } else if (rootsRigthChildIsLeaf(root) && rootsLeftChildIsNotLeaf(root)){
            xcord = xcord - (int) Math.pow(2, farLeft - 1);
            int result = calculateNumberOfNodesForCompleteLayers(layer) + xcord;
            return result;
        } else {
            int leftsMiddle = countRight(root.left) + 1;
            int rightsMiddle = countLeft(root.right) + 1;
            if (leftsMiddle != rightsMiddle) {
                xcord = xcord - (int) Math.pow(2, farLeft - 1);
                int result = calculateNumberOfNodesForCompleteLayers(
                    layer + (farRight - 1)
                    ) + xcord;
                return result;
            } else if (leftsMiddle == farLeft) {
                return countNodesTailRecursion (
                    root.right,
                    farRight - 1,
                    leftsMiddle - 1,
                    layer + 1,
                    xcord
                );
            } else {
                xcord = xcord - (int) Math.pow(2, farLeft - 1);
                return countNodesTailRecursion (
                    root.left,
                    countRight(root.left),
                    farLeft - 1,
                    layer + 1,
                    xcord
                );
            }

        }
    }


    private int calculateNumberOfNodesForCompleteLayers(int x) {
        int result = 0;
        while (x >= 0) {
            result = result + (int) Math.pow(2, x);
            x --;
        }
        return result;
    }

    private boolean rootsLeftChildIsNotLeaf(TreeNode root) {
        try {
            int num = root.left.val;
            try {
                num = root.left.right.val;
                return true;
            } catch (NullPointerException e) {
                return false;
            }
        } catch (NullPointerException e) {
            return false;
        }
    }

    private boolean rootsRigthChildIsLeaf(TreeNode root) {
        try {
            int num = root.right.val;
            try {
                num = root.right.left.val;
                return false;
            } catch (NullPointerException e) {
                return true;
            }
        } catch (NullPointerException e) {
            return false;
        }
    }

// This function assumes that the given node is not null
    private int countLeft(TreeNode root) {
        int counter = 0;
        while (true) {
            if (hasLeft(root)) {
                root = root.left;
                counter ++;
            } else {
                break;
            }
        }
        return counter;
    }

// This function assumes that the given node is not null
    private int countRight(TreeNode root) {
        int counter = 0;
        while (true) {
            if (hasRight(root)) {
                root = root.right;
                counter ++;
            } else {
                break;
            }
        }
        return counter;
    }

    private boolean hasNoChildren(TreeNode root) {
        return hasLeft(root);
    }

    private boolean hasRight(TreeNode root) {
        try {
            int test = root.right.val;
            return true;
        }  catch (NullPointerException e) {
            return false;
        }
    }
    
    private boolean hasLeft(TreeNode root) {
        try {
            int test = root.left.val;
            return true;
        }  catch (NullPointerException e) {
            return false;
        }
    }

    private boolean isNull(TreeNode root) {
        try {
            int test = root.val;
            return false;
        }  catch (NullPointerException e) {
            return true;
        }
    }
}