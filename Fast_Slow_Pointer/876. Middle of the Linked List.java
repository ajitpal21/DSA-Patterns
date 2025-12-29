// leetcode 876. Middle of the Linked List ?

class Solution {
    public ListNode middleNode(ListNode head) {
           ListNode slow = head;
           ListNode fast = head;

           if(head == null) return null;
           if(head.next == null) return head;
          
          while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
          }
          return slow;

    }
}