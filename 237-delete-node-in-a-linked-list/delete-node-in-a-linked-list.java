class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;      // Copy next value
        node.next = node.next.next;    // Skip next node
    }
}
