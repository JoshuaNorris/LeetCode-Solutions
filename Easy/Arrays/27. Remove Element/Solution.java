// https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int x = 0;

        while (nums.length>0 && x<nums.length && nums[x]!=-1) {
            if (nums[x] == val) {
                if (nums[nums.length-1-count] == val) {
                    nums[x] = nums[nums.length-1-count];
                    nums[nums.length-1-count] = -1;
                    count++;
                } else {
                    nums[x] = nums[nums.length-1-count];
                    nums[nums.length-1-count] = -1;
                    count++;
                    x++;
                }
            } else {x++;}
        }
        return nums.length-count;
    }
}