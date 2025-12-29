// GFG - Find length of Loop ? (solved in GFG)

// find meeting point of slow and fast in the list then fixed one pointer to there and 
// onther move until again meeting point meet 
class Solution {
    public int lengthOfLoop(Node head) {
        // code here
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
             
             if(slow == fast){  // cycle detected
                  return countNumberOfNodes(slow); 
             }
        }
        return 0;
    }
    public int countNumberOfNodes(Node meetingPoint){ // find the no of Nodes
          int count = 1;
          Node temp = meetingPoint.next;
          while(temp != meetingPoint){
               count++;
               temp = temp.next;
          }
          return count;
    }
}