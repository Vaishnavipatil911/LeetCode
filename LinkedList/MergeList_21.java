package LinkedList;

import java.lang.classfile.components.ClassPrinter.ListNode;

public class MergeList_21 {
    
  //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1==null) return list2;
        if(list2==null) return list1;
        
        
        ListNode dummy =new ListNode(0);
        ListNode A=list1;
        ListNode B=list2;
        ListNode tail=dummy;

        while(A!=null && B!=null)
        {
            if(A.val<=B.val)
            {
                tail.next=A;
                A=A.next;

            }
            else
            {
                tail.next=B;
                B=B.next;
            }
            tail=tail.next;
        }

        if(A!=null)
        {
            tail.next=A;
        }
        else
        {
            tail.next=B;
        }
    return dummy.next;

        
    }
}
}
