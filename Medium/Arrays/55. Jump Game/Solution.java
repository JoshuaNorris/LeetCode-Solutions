class Solution {
    public boolean canJump(int[] nums) {
        boolean[] jumppoints = new boolean[nums.length];
        jumppoints[0] = true;
        for (int x=0; x<nums.length; x++) {
            if (jumppoints[x]) {
                for (int y=1; y<=nums[x] && y+x<nums.length; y++) {
                    jumppoints[x+y] = true;
                }
            }
        }
        return jumppoints[nums.length-1];
    }
}