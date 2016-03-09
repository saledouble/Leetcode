package leetcode;

public class Solution {
    public int maxArea(int[] height) {
    	int water = 0;
    	int maxWater = 0, left = 0, right = 0;
    	
    	// the volume of water is decided by the height of lower bar
    	
    	int i = 0, j= height.length - 1;
        while (i < j){
        	water = Math.min(height[i], height[j]) * (j-i);
        	if(water > maxWater) maxWater = water;
        	if(height[i] < height[j])i++;
        	else j--;
        	
        }
        return maxWater;
    }
}