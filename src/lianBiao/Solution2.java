package lianBiao;

import java.util.Stack;

/**
 * 反转链表
 */
public class Solution2 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 使用栈
     * @param head
     * @return
     */
//    public ListNode reverseList(ListNode head){
//        Stack<ListNode> res = new Stack<>();
//        if (head==null) return head;
//
//        while (head!=null){
//            res.add(head);
//            head = head.next;
//        }
//
//        ListNode tail = res.pop();
//        ListNode tmp = tail;
//        while (!res.isEmpty()){
//            tmp.next = res.pop();
//            tmp = tmp.next;
//        }
//        tmp.next = null;
//        return tail;
//    }

    /**
     * 使用三个指针
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
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
