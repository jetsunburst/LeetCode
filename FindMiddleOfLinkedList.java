import java.util.*;

public class FindMiddleOfLinkedList {

    // Definition for singly-linked list
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Function to find the middle node of the linked list
    public LinkedList middleNode(LinkedList head) {
        LinkedList slowNode = head;
        LinkedList fastNode = head;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        return slowNode;
    }

    // Helper function to print the linked list from a given node
    public void printList(LinkedList node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        LinkedList head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(3);
        head.next.next.next = new LinkedList(4);
        head.next.next.next.next = new LinkedList(5);

        FindMiddleOfLinkedList program = new FindMiddleOfLinkedList();
        LinkedList middle = program.middleNode(head);

        System.out.println("Middle Node Value: " + middle.value);
        System.out.print("List from Middle Node: ");
        program.printList(middle);
    }
}
