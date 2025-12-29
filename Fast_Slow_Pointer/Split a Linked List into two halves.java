// GFG. Split a Linked List into two halves ? (solved in GFG)

class Solution {
    public Pair<Node, Node> splitList(Node head) {
        // Code here
        Node slow = head;
        Node fast = head.next;
        
        while(fast != head && fast.next != head){
              slow = slow.next;
              fast = fast.next;
              
              if(fast.next != head){ // if fast is not equal to head
                   fast = fast.next;
              }
        }
         fast.next = slow.next;
         slow.next = head;
         
         return new Pair<Node, Node> (head, fast.next);
    }
}