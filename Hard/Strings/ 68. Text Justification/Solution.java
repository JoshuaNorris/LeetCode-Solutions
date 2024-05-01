// https://leetcode.com/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.List;
import java.util.ArrayList;

class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> paragraph = new ArrayList<>();
    	String line = words[0];
        int current_words = 1;
        for (int word=1; word<words.length; word++) {
        	if (line.length() + words[word].length() + 1 > maxWidth) {
        		paragraph.add(getLine(line, current_words, maxWidth));
        		line = words[word];
        		current_words = 1;
        	} else {
        		line = line + " " + words[word];
        		current_words ++;
        	}
        }

        paragraph.add(getLeftJustifyLine(line, current_words, maxWidth));

        return paragraph;
    }

    private static String getLeftJustifyLine (String line, int current_words, int maxWidth) {
    	return line + getWhitespace(maxWidth - line.length());
    }




    private static String getLine (String line, int current_words, int maxWidth) {
    	if (current_words == 1) { return getLeftJustifyLine(line, current_words, maxWidth); }

    	int spaces_in_line = current_words - 1;
    	int excess_space = maxWidth - line.length();
    	int spaces_per_space = excess_space / spaces_in_line;
    	int line_remainder = excess_space % spaces_in_line;
    	int index = 0;

    	for (int space=0; space<spaces_in_line; space++) {
    		index = getNextSpace(index, line);
    		int remainder = (line_remainder > 0) ? 1 : 0;
    		int spaces_to_add = spaces_per_space + remainder;
    		String extra_space = getWhitespace(spaces_to_add);
    		line = line.substring(0, index + 1) + extra_space + line.substring(index + 1);
    		index += spaces_to_add + 1;

    		line_remainder --;
    	}
    	return line;
    }

    private static int getNextSpace(int index, String line) {
    	while (line.charAt(index) != ' ') { index ++; }
    	return index;
    }

    private static String getWhitespace (int num) {
    	String result = "";
    	for (int x=0; x<num; x++) {
    		result += " ";
    	}
    	return result;
    }

}