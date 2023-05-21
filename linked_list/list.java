import java.util.Scanner;

// This program contains all basic operations to be performed on a linked list.

class Node {
    int data;
    Node next;

    public Node() {
        data = 0;
        next = null;
    }

    public Node(int d, Node n) {
        data = d;
        next = n;
    }

}

class linkedList {
    Node start;
    int size;

    public boolean isEmpty() {
        if (start == null)
            return true;
        else
            return false;
    }

    public int getListSize() {
        return size;
    }

    public void viewList() {
        Node temp = new Node();
        temp = start;
        if (temp == null) {
            System.out.println("List is empty");
            return;
        }
        for (int i = 1; i <= size; i++) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void insertAtStart(int val) {
        Node temp = new Node(val, start);
        start = temp;
        size++;
    }

    public void insertAtLast(int val) {
        Node temp = new Node(val, null);

        if (start == null) {
            start = temp;
        } else {
            Node temp1 = new Node();
            temp1 = start;
            for (int i = 1; i < size; i++) {
                temp1 = temp1.next;
            }
            temp1.next = temp;
        }
        size++;
    }

    public void insertAtPos(int val, int position) {
        Node node = new Node(val, null);
        Node temp = new Node();
        temp = start;
        if (position == 1) {
            node.next = start;
            start = node;
            return;
        }
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public void deleteAtLast() {
        if (size == 1) {
            start = null;
            size = 0;
            return;
        }
        Node temp = new Node();
        temp = start;
        for (int i = 1; i < size-1; i++) {
            temp = temp.next;
        }
        temp.next = null;
        size--; 
        return;
    }

    public void deleteAtStart(){
        if(size == 0){
            System.out.println("List is already empty");
            return;
        }
        start = start.next;
        size--;
    }

    public void deleteAtPos(int position){
        Node temp = new Node();
        temp = start;
        if(position == 1){
            start = null;
            size --;
            return;
        }
        for(int i =1;i<position-1;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }


}

public class list {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of values");
        int n = sc.nextInt();
        System.out.println("Enter your values: ");
        linkedList obj = new linkedList();

        while (n-- > 0) {
            int val = sc.nextInt();
            obj.insertAtLast(val);
        }

        System.out.println("What do you want: ");
        System.out.println("1. Insert at beginning ");
        System.out.println("2. Insert at last of list ");
        System.out.println("3. Insert at specific position of list ");
        System.out.println("4. Delete from start of list ");
        System.out.println("5. Delete from last of list ");
        System.out.println("6. Delete from specific position of list ");
        System.out.println("7. Display the list elements ");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the value to insert at beginning: ");
                int val1 = sc.nextInt();
                obj.insertAtStart(val1);

                break;
            case 2:
                System.out.println("Enter the value to insert at last: ");
                int val2 = sc.nextInt();
                obj.insertAtLast(val2);
                break;
            case 3:
                System.out.println("Enter the value and the position : ");
                int val3 = sc.nextInt();
                int pos = sc.nextInt();
                obj.insertAtPos(val3, pos);
                break;
            case 4:
                obj.deleteAtStart();
                break;
            case 5:
                obj.deleteAtLast();
                break;
            case 6:
                System.out.println("Enter the position you want to delete the element from: ");
                int position = sc.nextInt();
                obj.deleteAtPos(position);
                break;
            case 7:
                break;
            default:
                System.out.println("Invalid choice. Try next time again. ");
                break;
        }
        System.out.println("Your final list is: ");
        obj.viewList();
    }
}
