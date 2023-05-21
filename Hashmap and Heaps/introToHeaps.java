import java.util.Collections;
import java.util.PriorityQueue;

public class introToHeaps {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int [] ranks = {2,1,3,6,4,7,5};
        for(int val: ranks){
            pq.add(val);
        }

        // This will remove elements from queue and will be printed in ascending order because priority queue prioritizes smaller elemens by default so elements are removed as smaller, next smaller and so on.
        System.out.println("In ascending order : ");
        while(pq.size() > 0){
            System.out.print(pq.peek() + "  ");
            pq.remove();
        }
        System.out.println();

        pq = new PriorityQueue<>(Collections.reverseOrder());   // This will prioritze greater elements first.
        for(int val: ranks){
            pq.add(val);
        }
        // This prints in descending order
        System.out.println("In descending order : ");
        while(pq.size() > 0){
            System.out.print(pq.peek() + "  ");
            pq.remove();
        }
        
    }
}
