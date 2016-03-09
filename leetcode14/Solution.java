package leetcode;

public class Solution {
	
    public String longestCommonPrefix(String[] strs) {
        int j = 0;
        String s = "";
        if (strs.length == 0) return s;
        while(true){
        	if (j <  strs[0].length()){
            	char c = strs[0].charAt(j);
            	for(int i = 1 ; i < strs.length ;++i){
            		if (j <  strs[i].length()){
            			if(strs[i].charAt(j) != c) return s;
            		}else return s;
            		
            	}
            	s += c;
            	j++;
        	}else return s;
        }
    }
}