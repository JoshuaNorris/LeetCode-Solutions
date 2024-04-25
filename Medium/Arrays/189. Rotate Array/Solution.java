// https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
    	nums = reverseList(nums, 0, nums.length-1);
    	nums = reverseList(nums, 0, k-1);
    	nums = reverseList(nums, k, nums.length-1);
    }

    private int[] reverseList (int[] nums, int start_ind, int end_ind) {
        while (start_ind < end_ind) {
            int temp = nums[start_ind];
            nums[start_ind] = nums[end_ind];
            nums[end_ind] = temp;
            start_ind++;
            end_ind--;
        }
        return nums;
    }
}

//  Reverse list
    // Do this by using two pointers and switching their elements
// reverse the first k elements in the list
// reverse the last k elements in the list