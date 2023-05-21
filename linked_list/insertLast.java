import java.util.*;

class Node{
    int data;
    Node next;
}
class linkedList{
    Node head = null;
    Node tail = null;
    int size = 0;

    public void insertLast(int d){
        Node temp = new Node();
        temp.data = d;
        temp.next = null;
        if(size==0){
            head = tail = temp;
        } else{
            tail.next = temp;
            tail = temp;
        }
        size++;
    }
}


public class insertLast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of values to insert : ");
        int n = sc.nextInt();
        int copy = n;
        System.out.println("Enter your values: ");
        linkedList obj = new linkedList();
        while(n-->0){
            int value = sc.nextInt();
            obj.insertLast(value);
            System.out.println(obj.size+" ");
        }
        Node temp = new Node();
        temp = obj.head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println("Thank you!!");
    }
    
}
