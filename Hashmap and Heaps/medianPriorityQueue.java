import java.util.*;

public class medianPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue <Integer> pq = new PriorityQueue<>();

        int arr[] = {1,2,34,4,5,6,32};
        for (int elem : arr) {
            pq.add(elem);
        }
        int halfSize = pq.size()/2;
        int elem = 0;

        for(int i = 0; i < halfSize; i++){
            elem = pq.peek();
            pq.remove();
        }

        if(halfSize % 2 == 0){
            System.out.println(elem);
        } else {
            System.out.println(elem);
        }
    }
}
