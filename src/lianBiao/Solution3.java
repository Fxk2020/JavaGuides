package lianBiao;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class Solution3 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0, head);//哑巴节点
        ListNode cur = dummy;
        ListNode tail = cur;
        for (int i = 0; i < n; i++) {
            tail = tail.next;
        }

        while (tail.next!=null){
            tail = tail.next;
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return dummy.next;
    }



}
