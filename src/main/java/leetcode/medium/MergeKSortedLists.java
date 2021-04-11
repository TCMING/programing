package leetcode.medium;

import leetcode.definition.ListNode;

import java.util.Arrays;

/**
 * @Author tianchengming
 * @Date 2021年4月3日 18:59
 * @Version 1.0
 */
public class MergeKSortedLists {



    public static void main(String[] args) {
        ListNode[] lists = { ListNode.buildListNode(new int[]{1, 2, 3}),
                ListNode.buildListNode(new int[]{1})};

        Solution23 solution23 = new Solution23();
        solution23.mergeKLists(lists);
    }
}

class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length <= 0){
            return null;
        }
        ListNode init = lists[0];
        ListNode dummy = new ListNode(0,init);
        for(int i=1; i < lists.length; i++){
            ListNode head = dummy;
            ListNode tail = head.next;

            ListNode curNode = lists[i];
            while(tail != null && curNode != null){
                if(tail.val <= curNode.val){
                    tail = tail.next;
                    head = head.next;
                }else{
                    ListNode tmp = curNode.next;
                    head.next = curNode;
                    curNode.next = tail;
                    tail = curNode;
                    tail = tail.next;
                    head = head.next;
                    curNode = tmp;
                }
            }
            if(curNode != null){
                head.next = curNode;
            }
        }

        return dummy.next;
    }
}
