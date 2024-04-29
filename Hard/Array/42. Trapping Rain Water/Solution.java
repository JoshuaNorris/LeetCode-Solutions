// https://leetcode.com/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int trap(int[] height) {
    	int output = 0;
        int [] prefiks = createPrefiks(height);
        int [] postfiks = createPostfiks(height);
        for (int x=0; x<height.length; x++) {
            if (Math.min(prefiks[x], postfiks[x]) - height[x] > 0) {
                output += Math.min(prefiks[x], postfiks[x]) - height[x];
            }
        }

    	return output;
    }

    private int[] createPrefiks (int[] height) {
        int lmax = 0;
        int [] prefiks = new int[height.length];
        for (int x=0; x<height.length; x++) {
            lmax = (height[x] > lmax) ? height[x] : lmax;
            prefiks[x] = lmax;
        }
        return prefiks;
    }

    private int[] createPostfiks (int[] height) {
        int rmax = 0;
        int [] postfiks = new int[height.length];
        for (int x=height.length-1; x>=0; x--) {
            rmax = (height[x] > rmax) ? height[x] : rmax;
            postfiks[x] = rmax;
        }
        return postfiks;
    }
}