// https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.HashMap;

class Solution {
    public int hIndex(int[] citations) {
        HashMap<Integer, Integer> citation_scores = new HashMap();
        int citation_count = 0;
        int max_H_index = 0;
        int max = 0;

        for (int num : citations) {
            int count = (citation_scores.get(num)!=null) ? citation_scores.get(num) + 1 : 1;
            citation_scores.put(num, count);
            max = (num > max) ? num : max;
        }

        for (int x=max; x>=1; x--) {
            citation_count = (citation_scores.get(x)!=null) ? citation_count + citation_scores.get(x) : citation_count;
            max_H_index = (x > max_H_index && citation_count >= x) ? x : max_H_index;
        }
        return max_H_index;
    }
}

// loop through citations and fill the arraylist with each number and their count

// loop through array list starting at end
//     if there is as number > 0 at the current index
//         iterate the count
//     if the count > the current index and index > max index
//         reset max index

// Data Structures
//     arraylist for each number in citations and their count
//     int to keep track of how many citations we have seen up to that amount
//     int to track the best possible answer at that point

// Base Cases
//     []
//     [one element]
//     result is a number that doesnt exist in the array