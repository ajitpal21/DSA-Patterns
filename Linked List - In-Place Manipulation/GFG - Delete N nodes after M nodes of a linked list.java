// GFG - Delete N nodes after M nodes of a linked list ?

class Solution {
    static void linkdelete(Node head, int n, int m) {
        // your code here
        Node curr = head;
        
        while(curr != null){
              int counter = 0;
              Node prev = null;
              
              while(counter < m && curr != null){
                     counter = counter + 1;
                     
                     prev = curr;
                     curr = curr.next;
              }
              
              counter = 0;
              while(counter < n && curr != null){
                    counter = counter + 1;
                    
                    curr = curr.next;
              }
              
              prev.next = curr;
        }
    }
}