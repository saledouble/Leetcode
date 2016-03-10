package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	// QuickSort
	public static void quickSort(int[] arr){
	    qsort(arr, 0, arr.length-1);
	}
	
	private static void qsort(int[] arr, int low, int high){
	    if (low < high){
	        int pivot=partition(arr, low, high);        //将数组分为两部分
	        qsort(arr, low, pivot-1);                   //递归排序左子数组
	        qsort(arr, pivot+1, high);                  //递归排序右子数组
	    }
	}
	
	private static int partition(int[] arr, int low, int high){
	    int pivot = arr[low];     //枢轴记录
	    while (low<high){
	        while (low<high && arr[high]>=pivot) --high;
	        arr[low]=arr[high];             //交换比枢轴小的记录到左端
	        while (low<high && arr[low]<=pivot) ++low;
	        arr[high] = arr[low];           //交换比枢轴小的记录到右端
	    }
	    //扫描完成，枢轴到位
	    arr[low] = pivot;
	    //返回的是枢轴的位置
	    return low;
	}
	
	// the numbers in num array sorted in ascending order
	private List<ArrayList<Integer>>  twoSum(int[] nums, int sum){
		int i = 0, j = nums.length -1;
		List<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>();
		
		for(;i<nums.length ;++i)
			if(nums[i] == -sum){ i++; break;}
		
		while(i<j){
			if (nums[i] + nums[j] > sum) {
				do{
					j--;
					
				}while(nums[j] == nums[j+1] && i<j);
			}
			else if(nums[i] + nums[j] < sum) {
				do{
					i++;
				}while(nums[i] == nums[i-1] && i < j);

			}
			else {
				ArrayList<Integer> a = new ArrayList<Integer>();				
				a.add(nums[i]);
				a.add(nums[j]);
				aList.add(a);
				do{
					j--;
					i++;
				}while( nums[j] == nums[j+1]  && nums[i] == nums[i-1] && i<j);
				
			}
		}
		return aList;		
	}
	
    public List<List<Integer>> threeSum(int[] nums) {
        quickSort(nums);
        List list = new ArrayList<ArrayList<Integer>>();
        
        int j = 0;
        
        if(nums.length < 3) return list;
        
        for(int i = 0; i< nums.length ; ++i){
        	
        	if(nums[i] < 0){
        		
        		List<ArrayList<Integer>> a = twoSum(nums, -nums[i]);

        		while (!a.isEmpty()){
        			ArrayList<Integer> tmp = a.remove(0);
        			tmp.add(0, nums[i]);
        			list.add(tmp);			
        		}
        		
        		while(i < nums.length -1 && nums[i] == nums[i+1]) i++;
        		if(i == nums.length -1) i++;
        	}else if(nums[i] == 0){
        		j++;
        		if(j==3){
        			ArrayList<Integer> tmp =new ArrayList<>();
            		tmp.add(0);
            		tmp.add(0);
            		tmp.add(0);
            		list.add(tmp);
            		return list;
        		}
        		
        	}else break;
        	

        }
        
        return list;
    }
}