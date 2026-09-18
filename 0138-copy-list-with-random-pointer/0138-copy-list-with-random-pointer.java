/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        // add clone node
        Node temp = head;
        while(temp != null){
            Node clonedNode = new Node(temp.val);
            clonedNode.next = temp.next;
            temp.next = clonedNode;
            temp = clonedNode.next;
        }
        
        // copy random pointers
        temp = head;
        while(temp != null){
            Node oldNode = temp;
            Node newNode = temp.next;
            if(oldNode.random != null){
                newNode.random = oldNode.random.next;
            }
            temp = newNode.next;
        }

        // now detach new list and old list
        temp = head;
        Node ansNodeList = head.next;
        while(temp != null){
            Node oldNode = temp;
            Node cloneNode = temp.next;
            oldNode.next = cloneNode.next;
            if(cloneNode.next != null){
                cloneNode.next = cloneNode.next.next;
            }
            temp = temp.next;
        }
        return ansNodeList; 
    }

}