// leetcode 725. Split Linked List in Parts ?

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
         int len = 0;
         ListNode curr = head;

         while(curr != null){
              len = len + 1;
              curr = curr.next;
         }

         int uniformNumber = len / k;
         int remainingNumber = len % k;

         ListNode[] res = new ListNode[k];
         curr = head;

         for(int i = 0; i < k; i++){
              int count = uniformNumber;

              if(remainingNumber > 0){
                  count = count + 1;
                  remainingNumber = remainingNumber - 1;
              }

              ListNode temp1 = curr;
              int counter = 0;
              ListNode prev = null;

              while(counter < count){
                  prev = curr;
                  curr = curr.next;
                  counter = counter + 1;
              }

              if(prev != null){
                  prev.next = null;
              }

              res[i] = temp1;
         }

         return res;
    }
}