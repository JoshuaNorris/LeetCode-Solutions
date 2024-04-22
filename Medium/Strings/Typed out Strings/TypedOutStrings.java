

class TypedOutStrings {


	public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a#c", "b"));
        System.out.println(backspaceCompare("xywrrmp", "xywrrmu#p"));

    }


    public static boolean backspaceCompare(String s, String t) {
    	s = getRealString(s);
    	t = getRealString(t);
    	if (!(s.length() == t.length())) {
    		return false;
    	} else {
    		for (int index = 0; index < s.length(); index++) {
    			if (s.charAt(index) == t.charAt(index)) {
    				continue;
    			} else {
    				return false;
    			}
    		}
    	}
    	return true;
    	
    }

    private static String getRealString(String s) {
    	int backspaces = 0;
    	String snew = "";
    	for (int sind = s.length() - 1; sind >= 0; sind--) {
    		char schar = s.charAt(sind);
    		if (schar == '#') {
    			backspaces ++;
    		} else if (backspaces > 0) {
    			backspaces --;
    			continue;
    		} else {
    			snew = snew + schar;
    		}
    	}
    	return snew;
    }
}



















