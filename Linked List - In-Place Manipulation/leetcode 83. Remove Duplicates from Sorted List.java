// leetcode 83. Remove Duplicates from Sorted List ?

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;

         while(prev != null){
              ListNode curr = prev.next;
              int val = prev.val;

              while(curr != null && val == curr.val){
                  curr = curr.next;
              }

              prev.next = curr;
              prev = curr;
         }

         return head;
    }
}