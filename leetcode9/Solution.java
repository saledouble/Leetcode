package leetcode;

public class Solution {
    public boolean isPalindrome(int x) {
        
    	int temple = x;
    	int reverseX = 0;
    	while (temple > 0){
    		reverseX *= 10;
    		reverseX += temple % 10;
    		temple /= 10;
    	}
    	
    	if (reverseX == x) return true;
    	else return false;
    }
}