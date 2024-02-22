class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode first = reverse(l1);
      ListNode second = reverse(l2);
      ListNode temp = new ListNode(0);
      ListNode temp2 = temp;
      int sum = 0, carry = 0;
      while(first != null || second != null || carry != 0) {
        sum = carry;
        if(first != null) {
            sum += first.val;
            first = first.next;
        }
        if(second != null) {
            sum += second.val;
            second = second.next;
        }
        ListNode node = new ListNode(sum % 10);
        temp2.next = node;
        temp2 = temp2.next;
        carry = sum / 10;
      }
      ListNode ans = reverse(temp.next);
      return ans;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
