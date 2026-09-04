import java.util.*;
// Definition for singly-linked list.
public class lc_234 { 
public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
        {
            return true;
        }
   
        ListNode fastptr=head;
        ListNode slowptr=head;

        while(fastptr!=null && fastptr.next!=null)
        {
            slowptr=slowptr.next;
            fastptr=fastptr.next.next;
        }
        if(fastptr!=null)
        {
            slowptr=slowptr.next;
        }
        ListNode prev=null;
        ListNode curr=slowptr;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode first=head;
        ListNode second=prev;
        
        while(second!=null)
        {
            if(first.val!=second.val)
            {
                return false;
            }

            first=first.next;
            second=second.next;
        
        }
        return true;
    }
}}