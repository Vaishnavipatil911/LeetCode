package LinkedList;

public class lc_141 {
    
 //Definition for singly-linked list.
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
 
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode slowptr=head;
        ListNode fastptr=head;

        while(fastptr!=null && slowptr!=null && fastptr.next!=null)
        {
            slowptr=slowptr.next;
            fastptr=fastptr.next.next;

            if(fastptr==slowptr)
            {
            return true;
            }
        }
        return false;
    }
}
}
