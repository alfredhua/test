package com.leetcode.test1.chapter00002;

/**
 * 给定两个 非空 链表来表示两个非负整数。位数按照 逆序 方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 *
 * 输入： (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出： 7 -> 0 -> 8
 * 原因： 342 + 465 = 807
 */
public class Solution {


  private static ListNode addNodeNum(ListNode l1, ListNode l2){
    ListNode node=new ListNode(0);
    ListNode currentNode =node;
    int carry=0;
    while (l1!=null || l2!=null){
      int x=0,y=0;
      if (l1!=null) {
        x=l1.getNum();
      }
      if (l2!=null){
        y=l2.getNum();
      }

      int num=x+y+carry;
      if (num>9){
        carry=num/10;
      }else {
        carry=0;
      }
      ListNode listNode = new ListNode(num%10);
      currentNode.next=listNode;
      currentNode=listNode;
      if (l1!=null) {
        l1=l1.next;
      }
      if (l2!=null){
        l2=l2.next;
      }
      if (carry > 0) {
        currentNode.next = new ListNode(carry);
      }
    }
    return node.next;
  }

  private static ListNode getNode(int[] nums){
    ListNode node=new ListNode(0);
    ListNode currentNode=node;
    for (int i=0;i<nums.length;i++) {
      ListNode nextNode= new ListNode(0);
      if (i==nums.length-1){
        nextNode=null;
      }
      currentNode.setNum(nums[i]);
      currentNode.setNext(nextNode);
      currentNode=nextNode;
    }
    return node;
  }

  public static void main(String[] args) {
//    int nums[]={ 2,4,3 },numSecond[]={5,6,4};
//    int nums[]={5},numSecond[]={5};
    int nums[]={0,8},numSecond[]={1};
    ListNode node = Solution.addNodeNum(getNode(nums), getNode(numSecond));

    while (node!=null){
      System.out.print(node.getNum()+",");
      node=node.getNext();
    }

  }


}
