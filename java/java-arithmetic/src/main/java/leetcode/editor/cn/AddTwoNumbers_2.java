//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 7337 👎 0

  
package leetcode.editor.cn;

public class AddTwoNumbers_2{

   public static void main(String[] args) {
       Solution solution = new AddTwoNumbers_2().new Solution();
       solution.addTwoNumbers(new ListNode(2,new ListNode(4,new ListNode(3))),new ListNode(5,new ListNode(6,new ListNode(4))));
       System.out.println("---------------");
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode();
        int c=0;
        while (l1.getVal()!=null && l2.getVal()!=null){
            int a= l1.getVal()==null?0:l1.getVal();
            int b= l2.getVal()==null?0:l2.getVal();
            int val=0;
            if (a + b + c>=10){
                val =(a+b+c)%10;
                c=(a+b+c)/10;
            }else{
                val = a+b;
                c=0;
            }
            if (l1.getNext()!=null){
                l1=l1.getNext();
            }
            if (l1.getNext()!=null){
                l2=l2.getNext();
            }
            result=result.next;
            result.next=new ListNode(val);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

   
}