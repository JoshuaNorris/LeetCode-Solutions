// https://leetcode.com/problems/zigzag-conversion/?envType=study-plan-v2&envId=top-interview-150

import java.util.ArrayList;


class Solution {
    public String convert(String s, int numRows) {
        String[][] result = new int[numRows][s.length()];
        int row = 0;
        for (int x=0; x<s.length(); x++) {
            result[row] += s.substring(x, x+1);
        }
        return result;
    }
}