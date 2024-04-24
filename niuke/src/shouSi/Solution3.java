package shouSi;
import java.util.concurrent.locks.*;

public class Solution3 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode middle = middleNode(head);
        ListNode l2 = reverseList(middle.next);
        middle.next = null;
        mergeList(head,l2);
    }

    /**
     * 合并链表
     * @param l1
     * @param l2
     */
    private void mergeList(ListNode l1, ListNode l2) {
        while (l1!=null&&l2!=null){
            ListNode l1_next = l1.next;
            l1.next = l2;
            l1 = l1_next;
            ListNode l2_next = l2.next;
            l2.next = l1;
            l2 = l2_next;
        }
    }

    /**
     * 找到链表的中间值
     * @param head
     * @return 返回中间节点（奇数中间，偶数靠左）
     */
    public ListNode middleNode(ListNode head) {


        ListNode slow = head, fast = head;

        //中间两个节点的话靠右
//        while (fast!=null&&fast.next!=null){
//            fast = fast.next.next;
//            slow = slow.next;
//        }
        //靠左
        while (fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }

    /**
     * 翻转链表
     * @param head
     * @return 返回新的链表头
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
