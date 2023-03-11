import java.util.*;

public class LoonlyLinkedLists {

    public static void main(String[] args) {
        // Test your LinkedList class here
        testLinkedList();

        // The rest of this assignment will just use a
        // series of nodes and not your LinkedList class
//        Node<Integer> head = generateRandomLinkedList(10);
//        System.out.print("orginal: ");
//        printList(head);
//
//        System.out.println("middle: " + findMiddleElement(head).value);
//
//        int n = 4;
//        Node<Integer> res = getNthFromLastElement(head, n);
//        System.out.println(n + "th last element: " +
//                (res == null ? "null" : res.value));
//
//        System.out.print("reversed: ");
//        printList(reverseList(head));
//
//        System.out.println("contins cycle: " + containsCycle(head));
    }

    public static void testLinkedList() {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        l.add(6);
        l.add(1,6);
        l.set(4,5);
        l.remove(1);
        System.out.println(l.get(2));
        System.out.println(l.indexOf(5));
        System.out.println(l);
        // Test the rest of your LinkedList methods here
    }

    public static Node<Integer> generateRandomLinkedList(int numItems) {
        Node<Integer> head = new Node<Integer>();
        Node<Integer> n = head;
        for (int i = 0; i < numItems; i++) {
            int randInt = (int) (Math.random() * 50);
            Node<Integer> n1 = new Node<Integer>(randInt);
            n.next = n1;
            n = n.next;
        }
        return head.next;
    }

    public static void printList(Node<Integer> head) {
        String s = "[";
        while (head != null) {
            s += (head.value + ", ");
            head = head.next;
        }
        System.out.println(s.substring(0, s.length() - 2) + "]");
    }

    public static Node<Integer> findMiddleElement(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while(fast!=null && fast.next!=null){
            fast=fast.next;
            fast=fast.next;
            slow=slow.next;

        }
        return slow;

    }

    public static Node<Integer> getNthFromLastElement(Node<Integer> head, int n) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    public static Node<Integer> reverseList(Node<Integer> head){
        Node<Integer> previous = null;
        Node<Integer> curent = head;
        Node<Integer> next;
        while(curent.next!=null){
            next=curent.next;
            curent.next=previous;

            previous=curent;
            curent=next;
        }
        return previous;
    }

    public static boolean containsCycle(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

}

// Impliment a singly Linked List
// Method names taken from Java implimentation
// Java Docs: https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html

// Feel free to add any attributes and methods, but you must impliment the following:
class LinkedList<E> {

    private Node<E> head;

    public LinkedList() {
        head = null;
    }

    // Appends the specified element to the end of this list.
    public void add(E element) {
        Node<E> thing = head;
        if(thing==null){
            head=new Node<E>(element);
        }else {
            while (thing != null && thing.next != null) {
                thing = thing.next;
            }
            thing.next = new Node<E>(element);
        }
    }

    // Inserts the specified element at the specified position in this list.
    public void add(int index, E element) {
        Node<E> previous = head;
        Node<E> curent = head;
        Node<E> temp;
        int count = 0;
        while(count < index&&curent!=null){
            if(count>0){
                previous=previous.next;
            }
            curent=curent.next;
            count++;
        }
        temp=curent;
        previous.next = new Node<E>(element);
        previous.next.next=temp;
    }

    // Removes the element at the specified position in this list.
    public void remove(int index) {
        Node<E> temp;
        Node<E> previous = head;
        Node<E> current = head;
        int count = 0;
        while(count < index&&current!=null){
            if(count>0){
                previous=previous.next;
            }
            current=current.next;
            count++;
        }
        if(index == 0){
            head=head.next;
        } else{
            temp=current.next;
            previous.next=temp;
        }

    }

    // Returns the element at the specified position in this list.
    public E get(int index) {
        Node<E> thing=head;
        int count=0;
        while(count<index){
            thing=thing.next;
            count++;
        }
        return thing.value;
    }

    // Replaces the element at the specified position in this list with the
    // specified element.
    public E set(int index, E element) {
        Node<E> current = head;
        Node<E> previous = head;
        Node<E> temp;
        int count=0;
        while(count<index){
            if(count>0){
                previous=previous.next;
            }
            current=current.next;
            count++;
        }
        temp=current.next;
        previous.next=new Node<E>(element);
        current.next=temp;
        return null;
    }

    // Returns the index of the first occurrence of the specified element in this
    // list, or -1 if this list does not contain the element.
    public int indexOf(Object o) {
        Node<E> thing = head;
        for(int i=0;thing!=null;i++){
            if(thing.value == o){
                return i;
            }
            thing=thing.next;
        }
        return -1;
    }

    // Print the LinkedList in a user-friendly way
    public String toString() {
        String s = "[";
        while (head != null) {
            s += (head.value + ", ");
            head = head.next;
        }
        return s.substring(0, s.length() - 2) + "]";
    }

}

class Node<T> {
    public T value;
    public Node<T> next;

    public Node() {
        value = null;
        next = null;
    }

    public Node(T data) {
        value = data;
        next = null;
    }
}