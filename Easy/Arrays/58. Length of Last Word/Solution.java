// https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int lengthOfLastWord(String s) {
    	int res = 0;
    	boolean seen_whitespace = false;
        for (int x=0; x<s.length(); x++) {
        	if (s.charAt(x) == ' ') {
        		seen_whitespace = true;
        	} else {
        		if (seen_whitespace) {
        			res = 1;
        			seen_whitespace = false;
        		} else {
        			res ++;
        		}
        	}
        }
        return res;
    }
}