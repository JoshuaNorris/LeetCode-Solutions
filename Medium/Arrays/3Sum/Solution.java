// https://leetcode.com/problems/3sum/

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            if (i>0 && num == nums[i-1]) {
                // Loop to next number.
            } else {
                int l = i+1;
                int r = nums.length-1;
                int diff = 0-num;
                while (l<r) {
                    if (nums[l] + nums[r] > diff) { r--; } 
                    else if (nums[l] + nums[r] < diff) { l++; }
                    else {
                        ArrayList<Integer> solution = new ArrayList();
                        solution.add(num);
                        solution.add(nums[l]);
                        solution.add(nums[r]);
                        result.add(solution);
                        l++;
                        while (nums[l] == nums[l-1] && l<r) { l++; }
                    }

                }

            }
        }
        return result;
    }
}