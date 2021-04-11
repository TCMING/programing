package leetcode.definition;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildListNode(int[] nums){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for(int i: nums){
            head.next = new ListNode(i);
            head = head.next;
        }
        return dummy.next;
    }

}
