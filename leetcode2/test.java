package leetcode;

import java.util.List;

public class test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		//l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		//l2.next.next = new ListNode(4);
		
		ListNode  list = s.addTwoNumbers(l1, l2);
		while (list !=null){
			System.out.println(list.val);
			list = list.next;
		}
		
	}

}
