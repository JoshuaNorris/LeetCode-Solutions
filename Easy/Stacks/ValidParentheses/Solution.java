// https://leetcode.com/problems/valid-parentheses/description/

class Solution {
    
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }



    public static boolean isValid(String s) {
        Stacky stacky = new Stacky();
        for (char character : s.toCharArray()) {
        	if (isOpening(character)) {
        		stacky.push(character);
        	} else {
        		if (stacky.size > 0){
	        		Node top = stacky.pop();
	        		if (!doesMatch(top.character, character)) {
	        			return false;
	        		}
	        	} else {
	        		return false;
	        	}
        	}
        } 
        System.out.println(stacky.size);
        if (stacky.size == 0) {
        	return true;
        } else {
        	return false;
        }
    }


    private static boolean doesMatch(char opening, char closing) {
    	if (opening == '(' && closing == ')') {
    		return true;
    	} else if (opening == '[' && closing == ']') {
    		return true;
    	} else if (opening == '{' && closing == '}') {
    		return true;
    	}
    	return false;
    }

    private static boolean isOpening(char character) {
    	if (character == '(' || character == '[' || character == '{') {
    		return true;
    	} else {
    		return false;
    	}
    }
}



class Node {
	public char character;
	public Node next;

	public Node(char character) {
		this.character = character;
	}
}



class Stacky {
	public Node character;
	public int size;

	public void push(char new_char) {
		Node temp = this.character;
		this.character = new Node(new_char);
		this.character.next = temp;
		size ++;
	}

	public Node pop() {
		Node temp = this.character;
		this.character = this.character.next;
		size --;
		return temp;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;

	}
}















