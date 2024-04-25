// https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.PriorityQueue;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> num_to_count = new HashMap();
        int max_count = 0;
        int max_element = 0;
        for (int x=0; x<nums.length; x++) {
            int num = nums[x];
            int count = 0;
            count = (num_to_count.get(num) == null) ? 1 : num_to_count.get(num) + 1;
                
            num_to_count.put(num, count);
            if (max_count < count) {
                max_count = count;
                max_element = num;
            }
            if (max_count > (nums.length / 2) + 1) {
                break;
            }

        }
        return max_element;
    }
}

// Creating my data structures
    // hashmap for the element and number of times its been found
    // a max count that keeps track of the lagest count we have
    // a max element that keeps track of the element we have seen the most

// loop through nums
    // seeing if the current element exists in the array
        // if it does get the count
        // increase count by 1
        // ask if that increased count is larger that our mox count
            // if so reset that and max element
        // put the element and increased count back into the dictionary.
