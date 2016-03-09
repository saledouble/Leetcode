package leetcode;

public class Solution {
	
	// num range: 0-3999
	
    public String intToRoman(int num) {
    	
        int v[] = new int[]{1000, 500, 100, 50, 10, 5, 1};
        char r[] = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        String s ="";
        
        for (int i = 0; i< v.length; ++i){
        	
    		if(num >= 900 && num < 1000) {
    			s += "CM";
    			num -=900;
    		}
    		if(num >= 400 && num < 500) {
    			s += "CD";
    			num -= 400;
    		}
    		if(num >= 90 && num < 100) {
    			s += "XC";
    			num -= 90;
    		}
    		if(num >= 40 && num < 50) {
    			s += "XL";
    			num -= 40;
    		}
    		if(num == 9 ) {
    			s += "IX";
    			num -= 9;
    		}
    		
    		if(num == 4) {
    			s += "IV";
    			num -= 4;
    		}
    		
        	for (int j = 0 ;j< num / v[i]; ++j) s += r[i];
        	num %= v[i];
        	
        		
        }
        return s;
    }
}