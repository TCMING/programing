package exercise.easy;

import exercise.definition.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chengming.tcm
 * @version 1.0
 * @date 2020/6/26 9:47
 */
public class RemoveDupNodes {
    public static void main(String[] args) {
        RemoveDupNodes solution = new RemoveDupNodes();
        int[] nums = {1,2,2,3};
        ListNode test = solution.buildListNode(nums);
        ListNode result = solution.removeDuplicateNodes(test);
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public ListNode removeDuplicateNodes (ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> sets = new HashSet();
        sets.add(head.val);
        ListNode current = head;
        while (current.next != null) {
            if (sets.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                sets.add(current.next.val);
                current = current.next;
            }
        }
        return head;
    }

    public ListNode buildListNode(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        ListNode listNode = new ListNode(nums[0]);
        for(int i=1; i < nums.length; i++){
            listNode.next = new ListNode(nums[i]);
        }
        return listNode;
    }
}


