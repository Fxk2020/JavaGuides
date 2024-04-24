package lianBiao;

import java.util.HashSet;
import java.util.List;

/**
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 * 双指针的方法
 */
public class Solution {
    //Definition for singly-linked list.
      class ListNode {
         int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
     }

    /**
     * 方法1，利用HashSet
     * @param head
     * @return
     */
//    public boolean hasCycle(ListNode head) {
//
//        HashSet<ListNode> table = new HashSet<>();
//        if (head!=null)
//            table.add(head);
//        else return false;
//
//        while (head.next!=null){
//            if (table.contains(head.next)){
//                return true;
//            }else {
//                table.add(head.next);
//            }
//            head = head.next;
//        }
//
//        return false;
//
//    }

    /**
     * 使用快慢指针的方法--Floyd判圈算法
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        if (head==null||head.next==null){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast!=slow){
            if (fast.next!=null&&fast.next.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            }else {
                return false;
            }
        }

        return true;
    }
}
