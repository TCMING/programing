package exercise.Linked_list;

import exercise.definition.ListNode;

public class OddEvenList {

    //分离节点后合并
    public ListNode oddEvenList1(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode evenHead = head.next;
        ListNode oddCur = head, evenCur = evenHead;
        while(evenCur != null && evenCur.next != null){
            oddCur.next = evenCur.next;
            oddCur = oddCur.next;
            evenCur.next = oddCur.next;
            evenCur = evenCur.next;
        }
        //奇偶链表 连起来
        oddCur.next = evenHead;
        return head;
    }


    //模拟，把奇数位和偶数位分开
    public ListNode oddEvenList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //处理奇偶链表的头
        ListNode oddDummy = new ListNode();
        ListNode evenDummy = new ListNode();
        ListNode oddCur = oddDummy;
        ListNode evenCur = evenDummy;
        boolean addrFlag = true;
        //奇偶链表分别处理
        while(head != null){
            if(addrFlag){
                oddCur.next = head;
                oddCur = oddCur.next;
                addrFlag = false;
            }else{
                evenCur.next = head;
                evenCur = evenCur.next;
                addrFlag = true;
            }
            head = head.next;
        }
        //奇偶链表合并
        evenCur.next = null;
        oddCur.next = evenDummy.next;
        return oddDummy.next;
    }

}
