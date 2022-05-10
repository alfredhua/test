package leetcode.codetop;

import leetcode.editor.helper.ListNode;

public class Top_03 {

    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5,7,8,9,10});
//        System.out.println(new Top_03().recur(listNode).printListNode());  //递归
//        System.out.println(new Top_03().reverse(listNode).printListNode()); // 最后插入
        System.out.println(new Top_03().reverseKGroup(listNode,3));
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode reverseNode=head;
        int i=0;
        ListNode temp;
        ListNode result=new ListNode();
        while (head!=null){
            if(i % k ==0){
                temp=head.next;
                head.next=null;
                result.next=result;
                head=temp;
            }
            i++;
        }
        return result;
    }

    /**
     * 递归反转链表
     * @param head
     * @return
     */
    public ListNode recur(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = recur(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }


    /**
     * 反转链表 循环
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode currentNode=head;
        ListNode temp;
        while (currentNode!=null){
            temp = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode=temp;
        }
        return pre;
    }


}
