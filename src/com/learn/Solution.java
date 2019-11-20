package com.learn;

import com.dcj.ListNode;

import java.awt.image.BandedSampleModel;
import java.lang.reflect.Array;
import java.util.*;


class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int sum = 0;
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    set.add(board[i][j]);
                    sum++;
                }
                if (sum != set.size()) return false;
            }
        }
        return true;
    }
    public static ListNode numsToListNode(int[] nums){

        ListNode l1 = new ListNode(0);//初始化列表
        ListNode l2 = l1;
        for (int item:nums) {//往列表填写数据
            l1.next = new ListNode(item);
            l1 = l1.next;
        }
        return l2.next;//返回第一个0链表后的链表
    }
    public static void showListNode(ListNode l1){
        while (l1 != null){
            System.out.printf("%d\t",l1.val);
            l1 = l1.next;
        }
    }
}