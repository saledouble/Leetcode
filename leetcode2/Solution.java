package leetcode;


public class Solution {
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	// List is the pointer 
    	// header is the first node of ListNode
        ListNode list = new ListNode(0);
        ListNode header = list;
        
        while(l1 !=null && l2 != null){
        	
        	list.next = new ListNode(l1.val + l2.val);
        	l1 = l1.next;
        	l2 = l2.next;
        	list = list.next;
        	
        }
        
        while(l1 != null && l2 == null){
        	list.next = new ListNode(l1.val);
        	list = list.next;
        	l1 = l1.next;
        }
        
        while(l2 !=null && l1 == null){
        	list.next = new ListNode(l2.val);
        	list = list.next;
        	l2 = l2.next;
        }
        
        // carry bit
        list = header.next;
        while(list != null){
        	if (list.val >= 10 ){
        		
        		list.val -= 10;
        		
        		if(list.next!=null){
        			list.next.val +=1;
        		}else list.next = new ListNode(1);
        		
        	}
        	list = list.next;
        }
        return header.next;
    }
}