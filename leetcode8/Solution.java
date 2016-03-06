package leetcode;

public class Solution {
	
    public int myAtoi(String str) {
    	long result = 0;
    	int positive = 1;
    	
    	int i = 0;
    	
    	// drop whitespace
    	if(str.isEmpty()) return 0;
    	while (str.charAt(i) ==' '){
    		i++;
    	}
    	
    	// judge negative / positive
    	if (str.charAt(i)=='-' || str.charAt(i) == '+') {
    		if (str.charAt(i)=='-' )positive = -1;
    		i++;
    	}
    	
    	if(i== str.length()) return 0;
    	
    	for (;i< str.length(); ++i){
    		
    		if (str.charAt(i) >='0' && str.charAt(i)<='9'){
        		if(result < Integer.MAX_VALUE){
        			result *= 10;
            		result += str.charAt(i) - '0';
        		}
        		// avoid out of boundary
        		if(result > Integer.MAX_VALUE){
        			if (positive > 0)
        				return Integer.MAX_VALUE ;
        			else return Integer.MIN_VALUE;
        		}
    		}else{
    			while (i< str.length())++i;
    		}
    	}

    	return positive * (int)result;
    }
}