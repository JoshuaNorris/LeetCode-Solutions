class Solution {
    public boolean canJump(int[] nums) {
        int goalPost = nums.length-1;
        for (int x=nums.length-2; x>=0; x--) {
            goalPost = (nums[x] >= goalPost-x) ? x : goalPost;
        }
        return goalPost==0;
    }
}