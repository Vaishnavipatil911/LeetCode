public class lc_2130 {

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public int pairSum(ListNode head) {
        ListNode first=head;
        ListNode fast=head.next;
        ListNode slow=head;
        int max=0;


        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode prevNode=null;
        ListNode currNode=slow.next;

        while(currNode!=null)
        {
            ListNode nextNode=currNode.next;
            currNode.next=prevNode;
            prevNode=currNode;
            currNode=nextNode;            
        }

        ListNode second=prevNode;

        while(first!=null && second!=null)
        {
            int sum=first.val + second.val;
            max=Math.max(sum,max);
            first=first.next;
            second=second.next;
        }
        return max;
    }
}
}
