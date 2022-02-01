package various_algo;

public class KNP {

    public static void main(String[] args){
    	int searchIndex = 0;
		if ((searchIndex = kmpSearch("a eighty-eighty-eighth key", "eighty-eighth")) == -1){
			System.out.println("見つかりませんでした");
		} else {
			System.out.println("見つかりました:" + searchIndex);
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
	
	public static int kmpMatch(String txt, String pat) {
	    int  pt = 1;                // txtをなぞるカーソル
	    int  pp = 0;                // patをなぞるカーソル
	    int count = 0;              // 比較回数
	    int k = -1;
	    int[] skip = new int[pat.length()+1];  // スキップテーブル

	    // スキップテーブルの作成
	    System.out.println("スキップ表作成");
	    skip[pt] = 0;
	    while (pt != pat.length()) {
	      if (k == pt - pp)
	        System.out.print("    ");
	      else {
	        System.out.printf("%2d  ", pt - pp);
	        k = pt - pp;
	      }

	      count++;
	      if (pat.charAt(pt) == pat.charAt(pp))
	        skip[++pt] = ++pp;
	      else if (pp == 0)
	        skip[++pt] = pp;
	      else
	        pp = skip[pp];
	     }

	    // 探索
	    System.out.println("探索");
	    pt = pp = 0;
	    while (pt != txt.length() && pp != pat.length()) {
	      if (k == pt - pp)
	        System.out.print("    ");
	      else {
	        System.out.printf("%2d  ", pt - pp);
	        k = pt - pp;
	      }
	      for (int i = 0; i < txt.length(); i++)
	        System.out.print(txt.charAt(i) + " ");
	      System.out.println();

	      for (int i = 0; i < pt * 2 + 4; i++)
	        System.out.print(" ");
	      System.out.print(txt.charAt(pt) == pat.charAt(pp) ? '+' : '|');
	      System.out.println();

	      for (int i = 0; i < (pt-pp) * 2 + 4; i++)
	        System.out.print(" ");

	      for (int i = 0; i < pat.length(); i++)
	        System.out.print(pat.charAt(i) + " ");
	      System.out.println();
	      System.out.println();
	      count++;
	      if (txt.charAt(pt) == pat.charAt(pp)) {
	        pt++;
	        pp++;
	      } else if (pp == 0)
	        pt++;
	      else
	        pp = skip[pp];
	    }

	    System.out.printf("比較は%d回でした。\n", count);
	    if (pp == pat.length())    // パターンの全文字を照合
	      return pt - pp;
	    return -1;          // 探索失敗
	  }

}
