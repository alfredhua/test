package leetcode.offer;

import leetcode.editor.cn.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
// 示例 1：
//
// 输入：head = [1,3,2]
//输出：[2,3,1]
//
//
//
// 限制：
//
// 0 <= 链表长度 <= 10000
// Related Topics 栈 递归 链表 双指针 👍 284 👎 0
public class OfferReversePrint_06 {


    List<Integer> tmp=new ArrayList<>();
    public static void main(String[] args) {
        OfferReversePrint_06 offerReversePrint_06 = new OfferReversePrint_06();
        ListNode head=new ListNode(1,new ListNode(3,new ListNode(2)));
        System.out.println(offerReversePrint_06.reversePrint(head));
    }

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        int next=0;
        ListNode first=head;
        while (head!=null){
            head=head.next;
            next++;
        }
        int[] result=new int[next];
        while (first!=null){
            result[next-1]=first.val;
            first=first.next;
            next--;
        }
        return  result;
    }

    /**
     * 递归 70%
     * @param head
     * @return
     */
//    public int[] reversePrint(ListNode head) {
//        recur(head);
//        int[] res = new int[tmp.size()];
//        for(int i = 0; i < res.length; i++)
//            res[i] = tmp.get(i);
//        return res;
//    }
//
//    public void recur(ListNode head){
//        if (head==null){
//            return;
//        }
//        recur(head.next);
//        tmp.add(head.val);
//    }

    /**
     * stack 27%
     * @param head
     * @return
     */
//    public int[] reversePrint(ListNode head) {
//        Stack<Integer> stack=new Stack<>();
//        while (head!=null){
//            stack.push(head.getVal());
//            head=head.getNext();
//        }
//        int[] result=new int[stack.size()];
//        int i=0;
//        while (!stack.isEmpty()){
//          result[i] = stack.pop();
//          i++;
//        }
//        return  result;
//    }
}
