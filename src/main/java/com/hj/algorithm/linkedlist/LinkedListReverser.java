package com.hj.algorithm.linkedlist;


/**
 * @author Administrator
 */
public class LinkedListReverser {

    public <T> Node<T> reverseLinkedList(Node<T> head) {
        Node<T> newHead = null;
        Node<T> curHead = head;
        // Loop invariant:
        // newHead points to the linked list already reversed.
        // curHead points to the linked list not yet reversed.

        // Loop invariant holds.
        while (curHead != null) {
            // Loop invariant holds.
            Node<T> next = curHead.getNext();
            curHead.setNext(newHead);
            newHead = curHead;
            curHead = next;
            // Loop invariant holds.
        }
        // Loop invariant holds.
        return newHead;
    }

    /**
     * Reverses a linked list.
     *
     * @param head the linked list to reverse
     * @return head of the reversed linked list
     */
    public <T> Node<T> reverseLinkedListRecursion(Node<T> head) {
        // size == 0 or size == 1
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<T> newHead = reverseLinkedListRecursion(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }
}
