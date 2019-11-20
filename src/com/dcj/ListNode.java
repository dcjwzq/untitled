package com.dcj;

public class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
class Generate{
    public static ListNode numsToListNode(int[] nums){

        ListNode l1 = new ListNode(0);//初始化列表
        ListNode l2 = l1;
        for (int item:nums) {//往列表填写数据
            l1.next = new ListNode(item);
            l1 = l1.next;
        }
        return l2.next;//返回第一个0链表后的链表
    }
}
