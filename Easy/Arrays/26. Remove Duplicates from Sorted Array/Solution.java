// https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150

import java.util.HashMap;


class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> seen_numbers = new HashMap();
        int count = 0;
        int index = 0;
        for (int x=0; x<nums.length; x++) {
            if (seen_numbers.get(nums[x]) == null) {
                nums[index] = nums[x];
                seen_numbers.put(nums[index], 1);
                index++;
            }

            else {
                count++;
            }
        }
        return nums.length - count;
    }
}

// Edge Cases
    // empty array / one element array
    // an array of only one number
    // an array with no duplicates

// Data Structures
    // Hash Map
        // this will keep track of what I have seen and how many times I have seen it
    // one int to keep track of how many duplicates I have seen

// loop through all the elements
    // check to see if the element is in the hashmap
        // if it not is add the element to the hashmap
        // if it is then
            // increment the count
            // switch this element with the element in 
                // nums.length-1-count;
                // in this situation my index should not increment