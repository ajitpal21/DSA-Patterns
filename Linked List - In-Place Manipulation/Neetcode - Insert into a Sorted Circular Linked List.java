// Neetcode - Insert into a Sorted Circular Linked List ?

class Solution {
    public Node insert(Node head, int insertVal) {

        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node node = head;

        do {
            if (node.val <= node.next.val) {
                if (insertVal >= node.val && insertVal <= node.next.val) {
                    Node newNode = new Node(insertVal);
                    newNode.next = node.next;
                    node.next = newNode;
                    return newNode;
                }
            } else {
                if (insertVal >= node.val || insertVal <= node.next.val) {
                    Node newNode = new Node(insertVal);
                    newNode.next = node.next;
                    node.next = newNode;
                    return newNode;
                }
            }

            node = node.next;

        } while (node != head);

        Node newNode = new Node(insertVal);
        newNode.next = node.next;
        node.next = newNode;
        return newNode;
    }
}

