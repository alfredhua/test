class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if not head:
            return head
        
        currentNode = head

        while currentNode.next:
            if currentNode.val == currentNode.next.val:
                currentNode.next=currentNode.next.next
            else:
                currentNode = currentNode.next

        return head

         