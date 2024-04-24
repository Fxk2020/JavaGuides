package shouSi;

import java.util.concurrent.*;


public class Solution {

    //  Definition for singly-linked list.
     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public void reorderList(ListNode head) {
         ListNode index = head;
         int n = 0;
         while (index!=null){
             index = index.next;
             n++;
         }

         ListNode middle = getMiddle(head, n);
         ListNode l2 = middle.next;
         middle.next = null;
         ListNode l1 = head;
         l2 = reverseList(l2);
         mergeList(l1, l2);

    }

    private ListNode getMiddle(ListNode head, int n) {

         ListNode res = head;
        for (int i = 0; i < n / 2; i++) {
            res = res.next;
        }
         return res;

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }

}
