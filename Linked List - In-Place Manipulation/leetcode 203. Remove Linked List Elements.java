// leetcode 203. Remove Linked List Elements ?

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);

        dummyNode.next = head;

        ListNode prev = dummyNode;
        ListNode curr = head;

        while(curr != null){
               
              if(curr.val == val){
                    prev.next = curr.next;
                    curr = curr.next;
                }else{
                    prev = curr;
                    curr = curr.next;
                }
        }
       return dummyNode.next;
    }
}