//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 1750 👎 0

  
package leetcode.editor.cn;

import leetcode.helper.ListNode;

public class RemoveNthNodeFromEndOfList_19{

   public static void main(String[] args) {
       Solution solution = new RemoveNthNodeFromEndOfList_19().new Solution();
       //输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
       ListNode listNode=new ListNode();
       ListNode head = listNode.createListNode(new int[]{1, 2, 3, 4, 5});
       ListNode listNode1 = solution.removeNthFromEnd(head, 4);
       System.out.println(listNode1.printListNode());
   }
   
   //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre=new ListNode(-1);
        pre.next=head;
        ListNode second=pre;
        int size=0;
        while (second!=null){
            size++;
            second=second.next;
        }
        ListNode first=pre;
        for (int i=0;i<size-1-n;i++){
            first=first.next;
        }
        first.next=first.next.next;
        return pre.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode pre=new ListNode(-1);
        pre.next=head;
        ListNode second=pre;
        for (int i=0;i<=n;i++){
            second=second.next; //
        }
        ListNode first=pre;
        while (second!=null){
            second=second.next;
            first=first.next;
        }
        //删除first的下一个节点就是
        first.next=first.next.next;
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

   
}