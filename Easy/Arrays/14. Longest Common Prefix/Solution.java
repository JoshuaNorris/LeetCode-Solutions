// https://leetcode.com/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = strs[0];
        for (int x=1; x<strs.length; x++) {
        	String str = strs[x];
            if (str.length() == 0) { result = ""; }
        	for (int y=0; y<str.length(); y++) {
        		if (y>=result.length()) {
        			result = result.substring(0, y);
        			break;
        		}
        		if (str.charAt(y)!=result.charAt(y)) {
        			result = result.substring(0, y);
        			break;
        		}
                if (y == str.length()-1) {
                    result = result.substring(0, y+1);
        			break;
                }
        	}
        }
        return result;
    }
}