import java.util.ArrayList;

class Solution {
    public boolean isValidBST(TreeNode root) {
        long max = Long.MAX_VALUE;
        long min = -Long.MAX_VALUE;
        return isValidBSTRecursive(root, max, min);
    }


    private static boolean isValidBSTRecursive (TreeNode root, long right_min, long left_max) {
        // CASE 1 -> IS LEAF
        if (isLeaf(root)) {
            return true;
        }
        // CASE 2 -> HAS ONLY LEFT CHILD
        else if (hasLeft(root) && !hasRight(root)) {
            if (isLeftChildValid(root, right_min, left_max)) {
                right_min = (right_min > root.val) ? root.val : right_min;
                return isValidBSTRecursive(root.left, right_min, left_max);
            } else {
                return false;
            }
        }
        // CASE 3 -> HAS ONLY RIGHT CHILD
        else if (!hasLeft(root) && hasRight(root)) {
            if (isRightChildValid(root, right_min, left_max)) {
                left_max = (left_max < root.val) ? root.val : left_max;
                return isValidBSTRecursive(root.right, right_min, left_max);
            } else {
                return false;
            }
        } 
        // CASE 4 -> HAS TWO CHILDREN
        else {
            if (isLeftChildValid(root, right_min, left_max) && isRightChildValid(root, right_min, left_max)) {
                long rights_left_max = (left_max < root.val) ? root.val : left_max;
                long lefts_right_min = (right_min > root.val) ? root.val : right_min;
                return isValidBSTRecursive(root.right, right_min, rights_left_max) && isValidBSTRecursive(root.left, lefts_right_min, left_max);
            } else {
                return false;
            }
        }
    }

    private static boolean isLeftChildValid(TreeNode root, long right_min, long left_max) {
        return root.left.val < root.val 
        && root.left.val < right_min
        && root.left.val > left_max;
    }

    private static boolean isRightChildValid(TreeNode root, long right_min, long left_max) {
        return root.right.val > root.val 
        && root.right.val > left_max
        && root.right.val < right_min;
    }

    private static boolean isLeaf(TreeNode root) {
        return !hasLeft(root) && !hasRight(root);
    }

    private static boolean hasLeft(TreeNode root) {
        try {
            int numL = root.left.val;
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    private static boolean hasRight(TreeNode root) {
        try {
            int numL = root.right.val;
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }
}