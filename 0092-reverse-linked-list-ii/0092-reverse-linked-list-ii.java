/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode reverseLL(ListNode head){
        if(head==null) return null;
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
            
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {

       if(head==null ||left==right) return head;
       ListNode dummy=new ListNode(0);
       dummy.next=head;

       ListNode beforenext=dummy;
       for(int i=1;i<left;i++){
        beforenext=beforenext.next;
       }

       ListNode start=beforenext.next;
       ListNode end=start;

       for(int i=left;i<right;i++){
        end=end.next;
       }
       ListNode afterright=end.next;
       end.next=null;

       ListNode reversed=reverseLL(start);
       beforenext.next=reversed;

       ListNode temp=reversed;
       while(temp.next!=null){
        temp=temp.next;
       }

       temp.next=afterright;

       return dummy.next;
      
    }
}