// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

class Solution {
    
    public static void main(String[] args) {
        // System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        // System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println("-" + minRemoveToMakeValid("))((") + "-");
    }



    public static String minRemoveToMakeValid(String s) {
    	String result = "";
    	Stacky stacky = new Stacky();

    	for (int index = 0; index < s.length(); index++) {
    		char character = s.charAt(index);

    		if (isOpening(character)) {
    			stacky.push(index);
    			result = result + character;
    		} else if (isClosing(character)) {
    			if (stacky.size == 0) {
    				// Do nothing... this skips the extra closing parenthesis
    			} else {
    				stacky.pop();
    				result = result + character;
    			}

    		} else {
    			result = result + character;
    		}
    	}

		if (stacky.size > 0) {
			int size_of_stack = stacky.size;
			int index = result.length() - 1;
			while (true) {
				if (isOpening(result.charAt(index))) {
					result = result.substring(0, index) + result.substring(index + 1);
					size_of_stack --;
				}
				index --;
				if (size_of_stack == 0) {
					break;
				}
			}
		}
		return result;
    }


    private static boolean isOpening(char c) {
    	return (c == '(');
    }

    private static boolean isClosing(char c) {
    	return (c == ')');
    }
}


class Node {
	public int character_index;
	public Node next;

	public Node(int character_index) {
		this.character_index = character_index;
	}
}



class Stacky {
	public Node character_index;
	public int size;

	public void push(int new_char_index) {
		Node temp = this.character_index;
		this.character_index = new Node(new_char_index);
		this.character_index.next = temp;
		size ++;
	}

	public Node pop() {
		Node temp = this.character_index;
		this.character_index = this.character_index.next;
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



















