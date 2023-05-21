// This is the queue which uses array to implement itself.
class Queue{

    static int front, rear, capacity;
    private static int queue[];

    Queue(int size){
        front = rear = 0;
        capacity = size;
        queue = new int[capacity];
    }

    
    // To insert element inside the queue.
    
    static void Enqueue(int item){
        // check if size is full.
        if(capacity == rear){
            System.out.println("Queue is full\n");
            return;
        }

        queue[rear] = item;
        rear++;

        return;
    }

    //remove an element from the queue.
    static void Dequeue(){
        // check if queue is empty.
        if(front == rear){
            System.out.println("Queue is already empty\n");
            return;
        }

        //if the queue is not empty, then shift the elements to the front side by one as we delete from the front.
        else{
            for(int i = 0; i<rear-1; i++){
                queue[i] = queue[i+1];
            }
            if(rear<capacity)
                queue[rear] = 0;
        
            rear--;
        }
        return;
    }

    // print the elements.
    static void Display(){
        // if the queue is empty.
        if(front == rear){
            System.out.println("Queue is empty \n");
            return;
        }

        // otherwise traverse the queue from front to rear and display each element.
        for(int i = front; i<rear; i++){
            System.out.print(queue[i]+" ");
        }
        System.out.println();
        return;
    }

    //print the front of queue. also known as peek()
    static void Front(){
        if(front == rear){
            System.out.println("Queue is empty");
            return;
        }

        System.out.println(queue[front]);
        return;
    }

}

public class basicQueue{
    public static void main(String[] args) {
        // Creating new queue of size 5 elements.
        Queue q1 = new Queue(5);

        System.out.println("Initial elements");
        q1.Display();

        //inserting elements.
        q1.Enqueue(1);
        q1.Enqueue(2);
        q1.Enqueue(3);
        q1.Enqueue(4);
        q1.Enqueue(5);

        System.out.println("Queue after insertion of elements");
        q1.Display();

        System.out.println("Front of the queue");
        q1.Front();

        System.out.println("Trying to add element when the queue is full");
        q1.Enqueue(6);

        System.out.println("Removing 2 elements");
        q1.Dequeue();
        q1.Dequeue();

        q1.Display();

        System.out.println("Size of queue is: "+q1.capacity);

    }
}