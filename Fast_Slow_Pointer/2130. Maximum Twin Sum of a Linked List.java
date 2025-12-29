// leetcode 2130. Maximum Twin Sum of a Linked List ?

// Brute force Approach Using extra Space (ArrayList)
class Solution {
    public int pairSum(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

          while(head != null){  
              list.add(head.val); // covert linked list to ArrayList
              head = head.next;
          }

          int i = 0;
          int j = list.size() - 1;
          
          int max = Integer.MIN_VALUE;
          while(i  < j){
             int twinSum = list.get(i) + list.get(j);  // calculate twinSum
             max = Math.max(twinSum, max);
             i++;
             j--;
          }
          return max;
    }
}


// And Here is the another Approach to solve this problem without Using extra Space
class Solution {
    public ListNode reverseLL(ListNode node){  // reverse a linked list from the middle of list
         ListNode curr = node;
         ListNode prev = null;
         while(curr != null){
             ListNode next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
         }
         return prev;
    }

    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast !=  null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
        }
           ListNode p2 = reverseLL(slow); // find middle and reverse the linked from there
           ListNode p1 = head;

           int max = Integer.MIN_VALUE;

           while(p1 != null && p2 != null){
               int twinSum = p1.val + p2.val;  // calculate twinSum
               max = Math.max(twinSum, max);

               p1 = p1.next;
               p2 = p2.next;
           }
           return max;
    }
}