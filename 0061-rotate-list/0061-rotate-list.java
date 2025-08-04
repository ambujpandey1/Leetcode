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
    public ListNode rotateRight(ListNode head, int k) {
       if(head==null || k==0 ||head.next==null) return head;
       int length=1;
       ListNode tail=head;
       while(tail.next!=null){
        tail=tail.next;
        length++;
       }
       tail.next=head;
       int newTailToList=length-k%length;

       ListNode newTail=head;
       for(int i=1;i<newTailToList;i++){
          newTail=newTail.next;
       }
       
       ListNode newNode=newTail.next;
       newTail.next=null;

       return newNode;
    }
}