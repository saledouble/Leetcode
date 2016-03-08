package leetcode;

public class Solution {
    public boolean isMatch(String s, String p) {
        
    	//BASE CASE
    	if(p.equals("")) return s.equals("") ;
    	
    	if(s.equals("")){
    		if(p.length() > 1 && p.charAt(1) == '*' ) 
    			return isMatch(s, p.substring(2));
    		return false;
    	}
    	
    	// next char is not '*': must match current character
    	if (p.length() < 2 || p.charAt(1) != '*' ){
    		return ((p.charAt(0) == s.charAt(0)) ||
    				(p.charAt(0) == '.' && s.charAt(0) != '\0') ) && isMatch(s.substring(1), p.substring(1));
    	}else{
    		
  		// next char is '*'
    		while( !s.isEmpty() && ((p.charAt(0) == s.charAt(0) ||
    				p.charAt(0) == '.' && s.charAt(0) != '\0'))){
    			if(isMatch(s, p.substring(2))) return true;
    			s = s.substring(1);
    		}
    		
    		return isMatch(s, p.substring(2));
    	}		
    }
}