package leetcode;

public class Solution {
	
	public double findKth(int[] a, int[] b, int k, int aStart, int bStart) {
		
		// BASE CASE
		if (k == 0) return a.length == 0 ? b[0]:a[0];
		if(aStart >= a.length) return b[bStart+ k - 1];
		if(bStart >= b.length) return a[aStart+ k -1 ];
		
		if (k==1) {
			return Math.min(a[aStart], b[bStart]);
		}
		
		
		// RECURSION
		// Drop k/2 numbers
		// Care about the array boundary
		int aIndex = aStart + k/2 -1 < a.length ? aStart + k/2 -1 : a.length-1;
		int bIndex = bStart + k/2 -1 < b.length ? bStart + k/2 - 1 :b.length-1;
		
		if (a[aIndex] < b[bIndex]){
			return findKth(a, b,k-(aIndex - aStart)-1 ,aIndex + 1, bStart);
		}else{
			return findKth(a, b, k-(bIndex - bStart)-1, aStart, bIndex+1);
		}
			
	}
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	
        int m = nums1.length ;
        int n = nums2.length ;
       
        // Two cases
        if((m+n) % 2 == 0){      
        	return (findKth(nums1, nums2, (m+n)/2,0, 0) +
        			findKth(nums1, nums2,(m+n)/2+1,0,0))/2;
        }else{
        	return findKth(nums1, nums2, (m+n)/2+1,0,0);
        }
    }
}