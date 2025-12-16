// leetcode 234. Palindrome Linked List ?

class Solution {
    public boolean isPalindrome(ListNode head) {
            List<Integer> list = new ArrayList<>();

            while(head != null){
                  list.add(head.val);  // adding all the value of nodes in the list
                   head = head.next;
            }  

            int i = 0;
            int j = list.size() - 1;

            while(i < j){
                 if(list.get(i) != list.get(j)){// we are comparing fisrt and last value in the list
                     return false; 
                 }
                 i++;
                 j--;
            }
            return true;
    }
}

// And here is Second Approach by Slow and Fast Pointer

class Solution {
    public ListNode reverseLL(ListNode curr){
          ListNode prev = null;

          while(curr != null){
             ListNode next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
          }
          return prev;
    }
    public boolean isPalindrome(ListNode head) {
         ListNode slow = head;
         ListNode fast = head;

         while(fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
            }
            ListNode p2 = reverseLL(slow);; // find middle and reverse the linked list from here
            ListNode p1 = head;

            while(p1 != null && p2 != null){
                  if(p1.val != p2.val){
                     return false;
                  }
                  p1 = p1.next;
                  p2 = p2.next;
            }
         return true;
    }
}