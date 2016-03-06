package leetcode;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Solution {
	/**
	 * DP
	 * p[i,j] judges whether the subString s[i,j] is palindrome
	 * @param s
	 * @return
	 */
    public String longestPalindrome(String s) {
        int length = s.length();
        int p[][] = new int[length][length];
        int start = 0, end = 0;
        int j = 0;
        for (int i= length-1 ; i>= 0 ; --i){
        	for (j = i ;j < length; ++j){
        		
        		if(s.charAt(i) == s.charAt(j)){
        			if (j > i + 1){
        				p[i][j] = p[i+1][j-1];
        			}else p[i][j] = 1;	
        		}
        	}
        }
        // Find the longest palindrome
        int maxLength = 0;
        for(int i = 0 ; i < length; ++i){
        	for(j = i ; j < length ; ++j){
        		
        		if (p[i][j] == 1 && maxLength < (j - i + 1)){
        			maxLength = j - i +1;
        			start = i;
        			end = j;
        		}
        	}
        }

        return s.substring(start, end+1);
    }
}