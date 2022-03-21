package exercise.Linked_list;

import exercise.definition.ListNode;

import java.util.Arrays;
import java.util.Collections;

public class ReverseList {

    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode(Arrays.asList(1,2,3,4,5,6,7,8,9));
        ReverseList reverseList = new ReverseList();
        ListNode res = reverseList.reverseList(head);
        ListNode.print(res);
    }

    public ListNode reverseList(ListNode head){
        ListNode next = null;
        ListNode pre = null;
        while(head != null){
            //处理前先把下个元素保存起来
            next = head.next;
            //将下个节点连接到上个节点
            head.next = pre;
            //更新节点
            pre = head;
            head = next;
        }
        return pre;
    }

}
