// leetcode 1721. Swapping Nodes in a Linked List ?

// Approach1
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
          int jumps1 = k - 1;
          int len = 0;

          ListNode curr = head;

          while(curr != null){
              len = len + 1;
              curr = curr.next;
          }

          ListNode n1 = head;
          ListNode n2 = head;
        int counter = 0;

        while(counter < jumps1){
              counter = counter + 1;
            n1 = n1.next;
        }

        counter = 0;
        int jumps2 = len - k;

        while(counter < len - k){
             counter = counter + 1;
             n2 = n2.next;
        }

        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;

        return head;
    }
}

// Approach2
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode n1 = head;

        int startJumps = 0;

        while(startJumps < k - 1){
              startJumps = startJumps + 1;
               n1 = n1.next;
        }

        ListNode nT1 = n1;
        ListNode n2 = head;

        while(nT1.next != null){
              nT1 = nT1.next;
              n2 = n2.next;
        }

        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;

        return head;
    }
}

