// https://leetcode.com/problems/roman-to-integer/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int romanToInt(String s) {
    	return romToIntHelp(s, 0);
    }

    private int romToIntHelp (String s, int num) {
    	if (s.length == 0) { return num; }
    	else {
    		char letter = s.charAt(0);
    		s = s.substring(1);
    		int new_num = romLetterToNumber(letter);
    		if (s.length > 0) { new_num = adjustForSubtraction(new_num, s); }
    		return romToIntHelp(s, num + new_num);
    	}
    }

    private int adjustForSubtraction (int number, String s) {
    	// I am assuming a string of 1 char long. 
    	if (romLetterToNumber(s.charAt(0)) > number) {
    		return number *= -1;
    	}
    }

    private int romLetterToNumber (char letter) {
    	switch (letter) {
    		case 'I':
    			return 1;
    		case 'V':
    			return 5;
    		case 'X':
    			return 10;
    		case 'L':
    			return 50;
    		case 'C':
    			return 100;
    		case 'D':
    			return 500;
    		case 'M':
    			return 1000;
    		default:
    			throw new Exception("I am not seeing a Roman Numeral Character");
    	}
    }
}