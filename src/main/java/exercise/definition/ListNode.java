package exercise.definition;

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

    public static void print(ListNode nodes){
        if(nodes == null){
            System.out.println("null");
        }
        while(nodes != null){
            if(nodes.next == null){
                System.out.print(nodes.val);
                break;
            }
            System.out.print(nodes.val+",");
            nodes = nodes.next;
        }
    }

}
