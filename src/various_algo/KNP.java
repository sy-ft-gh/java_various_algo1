package various_algo;

public class KNP {

    public static void main(String[] args){
    	int searchIndex = 0;
		if ((searchIndex = kmpSearch("a eighty-eighty-eighth key", "eighty-eighth")) == -1){
			System.out.println("Œ©‚Â‚©‚è‚Ü‚¹‚ñ‚Å‚µ‚½");
		} else {
			System.out.println("Œ©‚Â‚©‚è‚Ü‚µ‚½:" + searchIndex);
		}
	}
    private static int[] patternMatchTable(String pattern) {
		int[] table  = new int[pattern.length() + 1];
		
		table[0] = -1;
		var i = 0;
		var j = 1;
		while (j < pattern.length()) {
			boolean matched = pattern.charAt(i) == pattern.charAt(j);
			if (!matched && i > 0) 
				i = table[i];
			else {
				if (matched) i++;
				j++;
				table[j] = i;
			}
		}
		
		return table;
    }
	private static int kmpSearch(String text, String pattern){
		int[] table = patternMatchTable(pattern);
		var i = 0;
		var p = 0;
		
		while (i < text.length() && p < pattern.length()) {
			if (text.charAt(i) == pattern.charAt(p)) {
				i++;
				p++;
			} else if (p == 0) {
				i++;
			} else {
				p = table[p];
			}
		}
	    return p == pattern.length() ? i - p: -1;
	}
}
