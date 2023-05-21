import java.util.*;


class Node{
    Node prev;
    int data;
    Node next;

    Node(int data){
        this.data = data;
        prev = null;
        next = null;
    }
}


public class doublyLL {

    static Node head = new Node(0);
    static Node tail = new Node(0);
    public static void main(String[] args) {
        
        int i =1;
        while(i<=3){
            tail = insertAtLast(i*13, tail);
            i++;
        }

        printFromHead(head);
    }
     public static void printFromHead(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printFromTail(Node tail){
        while(tail!=null){
            System.out.print(tail.data+" ");
            tail = tail.prev;
        }
        System.out.println();
    }

    public static Node insertAtLast(int d,Node tail){
        Node temp = new Node(d);
        if(head == null){
            head = tail = temp;
        } else{
            temp.prev = tail;
            tail.next = temp;
            tail = temp;
        }
        return tail;
    }
}