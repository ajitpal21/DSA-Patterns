// leetcode 19. Remove Nth Node From End of List?

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode dummyNode = new ListNode(0);   // to create a dummy node 
         dummyNode.next = head;

         int size = 0;
         ListNode curr = head;
         while(curr != null){
             curr = curr.next;
             size++;  // to find the size of the list
         }
            ListNode prev = dummyNode;
                     curr = head;
            int i = 1;
           while(i < size-n+1){
                curr = curr.next;
                 prev = prev.next;
                 i++;
           }
           prev.next = prev.next.next;

           return dummyNode.next; // return dummyNode.next
    }
}
