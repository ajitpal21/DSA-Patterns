// leetcode 1650. Lowest Common Ancestor of a Binary Tree III ? ***But Solved in Neetcode***.

// Brute force Approach using HashSet data structure which is fastest for lookup operations.
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set = new HashSet<>();
         
         while(p != null){
             set.add(p);
             p = p.parent;
         }

         while(q != null){
              if(set.contains(q)){
                  return q;
              }
              q = q.parent;
         }
         return null;
    }
}


//And here is Optimized Approach for this problem without using any extra space.

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
         Node p1 = p;
         Node q1 = q;

         while(p1 != q1){
              p1 = (p1 == null) ? q : p1.parent;
              q1 = (q1 == null) ? p : q1.parent;
         }
         return q1;
    }
}