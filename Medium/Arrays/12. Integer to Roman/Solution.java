// https://leetcode.com/problems/integer-to-roman/?envType=study-plan-v2&envId=top-interview-150


class Solution {
	public String intToRoman(int num) {
		return intToRomanHelper(num, "");
	}

	private String intToRomanHelper(int num, String result) {
		if (num == 0) {
			return result;
		} else if (num >= 1000) {
			return intToRomanHelper(num - 1000, result + "M");
		} else if (num >= 900) {
			return intToRomanHelper(num - 900, result + "CM");
		} else if (num >= 500) {
			return intToRomanHelper(num - 500, result + "D");
		} else if (num >= 400) {
			return intToRomanHelper(num - 400, result + "CD");
		} else if (num >= 100) {
			return intToRomanHelper(num - 100, result + "C");
		} else if (num >= 90) {
			return intToRomanHelper(num - 90, result + "XC");
		} else if (num >= 50) {
			return intToRomanHelper(num - 50, result + "L");
		} else if (num >= 40) {
			return intToRomanHelper(num - 40, result + "XL");
		} else if (num >= 10) {
			return intToRomanHelper(num - 10, result + "X");
		} else if (num >= 9) {
			return intToRomanHelper(num - 9, result + "IX");
		} else if (num >= 5) {
			return intToRomanHelper(num - 5, result + "V");
		} else if (num >= 4) {
			return intToRomanHelper(num - 4, result + "IV");
		} else {
			return intToRomanHelper(num - 1, result + "I");
		}
	}
}