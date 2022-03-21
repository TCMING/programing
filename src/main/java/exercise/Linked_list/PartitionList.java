package exercise.Linked_list;

import exercise.definition.ListNode;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class PartitionList {
    public static void main(String[] args) {
        PartitionList partitionList = new PartitionList();
        ListNode head = ListNode.buildListNode(Arrays.asList(1,4,3,2,5,2));
        ListNode result = partitionList.partition(head,3);
        ListNode.print(result);

    }

    //快慢指针
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0,head);
        ListNode last = dummy;
        ListNode fast = dummy;
        while(last.next != null){
            if(last.next.val < x){
                last = last.next;
                fast = fast.next;
            }else{
                break;
            }
        }
        while(fast.next != null){
            if(fast.next.val >= x){
                fast = fast.next;
            }else{
                ListNode move = fast.next;
                fast.next = move.next;
                ListNode lastNext = last.next;
                last.next = move;
                move.next = lastNext;
                last = last.next;
            }
        }
        return dummy.next;

    }
}
