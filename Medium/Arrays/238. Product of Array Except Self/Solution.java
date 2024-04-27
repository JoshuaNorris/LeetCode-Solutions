// https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;

        for (int x=1; x<nums.length; x++) {
            result[x] = result[x-1] * nums[x-1];
        }

        for (int x=nums.length-2; x>=0; x--) {
            nums[x] = nums[x] * nums[x+1];
            result[x] = result[x] * nums[x+1];
        }
        return result;
        
    }
}