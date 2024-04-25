class Solution {
    public int jump(int[] nums) {
        int[] min_jumps_to_here = new int[nums.length];
        Arrays.setAll(min_jumps_to_here, i -> -1);
        min_jumps_to_here[0] = 0;
        for (int x=0; x<nums.length; x++) {
            if (min_jumps_to_here[x] != -1) {
                for (int y=1; y<nums[x] && y+nums[x]<nums.length; y++) {
                    min_jumps_to_here[nums[x] + y] = nums[x] + 1;
                }
            }
        }
        return min_jumps_to_here[nums.length-1];
    }
}