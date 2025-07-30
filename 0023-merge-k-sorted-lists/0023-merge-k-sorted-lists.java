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
    public ListNode mergeKLists(ListNode[] lists) {
        
         Queue<Integer> pq= new PriorityQueue<>();
        ListNode dummy= new ListNode(0);
        ListNode current=dummy;

       for(ListNode node:lists){
        while(node!=null){
            pq.add(node.val);
            node=node.next;
        }
       }
         while(!pq.isEmpty()){
            current.next=new ListNode(pq.poll());
            current=current.next;
         }

         return dummy.next;
    }
}