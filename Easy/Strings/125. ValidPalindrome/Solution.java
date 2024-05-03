class Solution {
    public boolean isPalindrome(String s) {
        int lpoint = 0;
        int rpoint = s.length() - 1;
        while (true) {
            char lchar = Character.toLowerCase(s.charAt(lpoint));
            char rchar = Character.toLowerCase(s.charAt(rpoint));
            if (!Character.isLetter(lchar) && !Character.isDigit(lchar)) {
                lpoint++;
            } else if (!Character.isLetter(rchar) && !Character.isDigit(rchar)) {
                rpoint--;
            } else {
                if (lchar == rchar) {
                    lpoint ++;
                    rpoint --;
                } else {
                    return false;
                }
            }
            if (lpoint >= rpoint) {
                break;
            }
        }
        return true;
    }
}