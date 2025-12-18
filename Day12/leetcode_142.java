// leetcode 142. Linked List Cycle II ?

public class Solution {
    public ListNode detectCycle(ListNode head) {
         ListNode slow = head;
         ListNode fast = head;

        while(fast != null && fast.next != null){
              slow = slow.next;
              fast = fast.next.next;

              if(slow == fast){
                  break;
              }
        }

         if(fast == null || fast.next == null){
              return null;
         }

        ListNode p1 = head;
        ListNode p2 = slow;

        while(p1 != p2){
             p1 = p1.next;
             p2 = p2.next;
        }
         return p1;
    }
}

//Another method
public class Solution {
    public ListNode detectCycle(ListNode head) {
         ListNode slow = head;
         ListNode fast = head;

        while(fast != null && fast.next != null){
              slow = slow.next;
              fast = fast.next.next;

              if(slow == fast){
                  ListNode p1 = head;
                  ListNode p2 = slow;

                  while(p1 != p2){
                     p1 = p1.next;
                     p2 = p2.next;
                  }
                  return p1;
              }
        }
        return null;
    }
}