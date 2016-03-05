package leetcode;

public class Solution {
	boolean flag[] = new boolean[128];
	
    public int lengthOfLongestSubstring(String s) {
    	
    	int length = 0;
    	int maxLength = 0;
    	setTrue();
    	
    	// i is for locating the subString
        for(int i= 0; i < s.length(); ++i){
        	
        	for(int j = i; j< s.length() ; ++j){
        		if (flag[s.charAt(j)] == false) break;
        		flag[s.charAt(j)] = false;
        		++length;
        	}
        	if(length > maxLength) maxLength = length;
        	length = 0;
        	setTrue();
        }
        
        return maxLength;
    }
    
    void setTrue(){
    	for(int i = 0; i < 128 ;++i)
    		flag[i] = true;
    }
}