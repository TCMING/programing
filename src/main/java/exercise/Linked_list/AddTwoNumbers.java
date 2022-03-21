package exercise.Linked_list;

import exercise.definition.ListNode;

import java.util.Arrays;

public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = ListNode.buildListNode(Arrays.asList(2,4,3));
        ListNode l2 = ListNode.buildListNode(Arrays.asList(5,6,7,9));

        addTwoNumbers.addTwoNumbers(l1,l2);
    }

    /** 模拟 */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        int carry = 0;
        ListNode head=null,tail=null;
        while(l1 != null || l2 != null){
            int l1Val = l1 != null ? l1.val: 0;
            int l2Val = l2 != null ? l2.val: 0;
            int sum = l1Val + l2Val + carry;
            carry = sum/10;
            if(head == null){
                head = new ListNode(sum%10);
                tail = head;
            }else{
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2  = l2.next;
            }
        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

    //在原来字符串上面修改
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //以l1为主
        ListNode head = l1;
        int carray = 0;
        ListNode slowNode = new ListNode(0,head);
        //遍历同等长度链表
        while(l1 != null && l2 != null){
            int newVal = (l1.val + l2.val + carray)%10;
            carray = (l1.val + l2.val + carray)/10;
            l1.val = newVal;
            slowNode = slowNode.next;
            if(l1.next == null){
                l1.next = l2.next;
                l1 = l1.next;
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        //继续遍历未完成链表
        while(l1 != null){
            int newVal = (l1.val + carray)%10;
            carray = (l1.val + carray)/10;
            l1.val = newVal;
            l1 = l1.next;
            slowNode = slowNode.next;
        }
        if(carray != 0){
            slowNode.next = new ListNode(carray);
        }
        return head;
    }

}
