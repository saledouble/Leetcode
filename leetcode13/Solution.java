package leetcode;

public class Solution {
	// the result range: 0 -3999
	private int v[] = new int[]{1000, 500, 100, 50, 10, 5, 1};
    private char r[] = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
	
	private int index(char c){
		for(int i = 0; i < r.length ; ++i)
			if (c == r[i]) return i;
		return -1;
	}
    public int romanToInt(String s) {
        int result = 0;
        if (s.length() == 0) return 0;
        
        for(int i = 0 ; i < s.length() ; ++i){
        	
        	int index = index(s.charAt(i));
        	if (i == s.length() - 1) return result += v[index];
        	
        	int index1 = index(s.charAt(i+1));
        	
        	if ( index1 < index ){
        		result += (v[index1] - v[index]);
        		++i;

        	}else result += v[index];
        }
        
        return result;
    }
}
