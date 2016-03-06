package leetcode;


public class Solution {
	/**
	 * find the rows and columns in the zigzag pattern
	 * @param n
	 * @param index
	 * @return
	 */
	public int[] locate(int n, int index){
		if(n<= 1) return new int[]{0,index};
		
		index++;
		int mod = index % (2*n-2);
		int div = index / (2*n-2);
		int a[] = new int[2];
		if (mod <= n && mod > 0){
			a[1] = 2 * div;
			a[0] = index - (2*n-2)*div - 1;
		}else{
			if (mod > n){
				a[1] = 2*div + 1;
				a[0] = (2*n-2) * (div+1) - index+1;
			}else {
				a[1] = 2*div -1;
				a[0] = 1;
			}
			
		}
		return a;
	}
	
    public String convert(String s, int numRows) {
        char p[][] = new char[numRows][s.length()];
        for(int i = 0; i < s.length(); ++i){
        	int a[] = locate(numRows, i);
        	
        	p[a[0]][a[1]] = s.charAt(i);
        }
        
        String sNew = "";
        for(int i = 0 ;i< numRows ; ++i){
        	for(int j = 0; j< s.length();++j){
        		if(p[i][j] !='\0') {
        			sNew+=p[i][j];       			
        		}
        	}
        }
        return sNew;
    }
}