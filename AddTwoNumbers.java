//add two nos
class ListNode {
    int val; ListNode next;
    ListNode() {}
    ListNode(int val){ this.val = val; }
}

class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0), curr=dummy;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int sum=carry;
            if(l1!=null){ sum+=l1.val; l1=l1.next; }
            if(l2!=null){ sum+=l2.val; l2=l2.next; }

            curr.next = new ListNode(sum%10);
            carry = sum/10;
            curr=curr.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);

        ListNode result = addTwoNumbers(l1, l2);
        printList(result);
    }
}
