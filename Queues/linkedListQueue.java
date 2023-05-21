// This program is the example of linked list implementation of queue.

class queue{
    private Node front, rear;
    int size;

    // Linked list node.
    private class Node{
        int data;
        Node next;
    } 

    // Default constructor assigns front, rear to null and size to 0 initially.
    public queue(){
        front = null;
        rear = null;
        size = 0;
    }

    //check if queue is empty
    public boolean isEmpty(){
        return (size==0);
    }

    // remove item from front of the queue.
    public int dequeue(){
        int data = front.data;
        front = front.next;

        if(isEmpty()){
            rear = null;
        }
        size--;
        System.out.println("removed data is : "+data);
        return data;
    }

    public void enqueue(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        
        if(isEmpty()){
            rear = newNode;
            front = rear;
        } else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("data added is : "+rear.data);
    }

    public void printFront(){
        System.out.println("The element on the front side is : "+front.data);
    }

    public void display(){

        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        } 

        Node temp = front;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

}



public class linkedListQueue {
    public static void main(String[] args) {
        queue q1 = new queue();

        //Initial queue.
        q1.display();

        // insert some elements in queue.
        q1.enqueue(1); 
        q1.enqueue(2); 
        q1.enqueue(3); 
        q1.enqueue(4); 
        q1.enqueue(5);
        
        System.out.println("the elements in queue after insertion are: ");
        q1.display();

        // front of the queue
        q1.printFront();
        //delete element at front
        q1.dequeue();
        // remaining queue
        q1.display();
        // front of the queue
        q1.printFront();
        q1.dequeue();
        q1.display();
        q1.isEmpty();
    }
}
