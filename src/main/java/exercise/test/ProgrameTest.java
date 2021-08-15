package exercise.test;

public class ProgrameTest {

    public static void main(String[] args) {
        int[] nums = {2};
        Node head = build(nums);
        Node res= sort(head);
        while(res != null){
            System.out.print(res.val + ",");
            res = res.next;
        }
    }


    public static Node build(int[] nums){
        if(nums == null || nums.length < 1){
            return null;
        }
        Node dummy = new Node(0);
        Node cur = dummy;
        for(int i : nums){
            Node temp = new Node(i);
            cur.next = temp;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static Node sort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node dummy = new Node(0);
        Node cur = head;
        while(cur != null){
            Node tmp = cur.next;
            cur.next = null;
            Node lastNext = dummy.next;
            Node last = dummy;
            boolean flag = false;
            while(!flag && lastNext != null && lastNext != cur){
                if(lastNext.val > cur.val){
                    last.next = cur;
                    cur.next = lastNext;
                    flag = true;
                }else{
                    lastNext = lastNext.next;
                    last = last.next;
                }
            }
            if(!flag){
                last.next = cur;
            }

            cur = tmp;
        }
        return dummy.next;
    }

}

class Node{
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }
}
