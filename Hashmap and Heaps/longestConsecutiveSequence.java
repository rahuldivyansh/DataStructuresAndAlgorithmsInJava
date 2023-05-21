import java.util.*;
public class longestConsecutiveSequence {
    public static void main(String[] args) {
        int [] arr = {10,5,9,1,11,8,6,15,3,12,2};

        HashMap<Integer, Boolean> hm = new HashMap<>();
        
        // At first assume every element is start of a sequence
        for(int val: arr){
            hm.put(val, true);
        }

        // Now after this loop below only those element which are start of a sequenece will have true
        for(int val: arr){
            if(hm.containsKey(val-1)){
                hm.put(val, false);
            }
        }


        int maxStartPoint = 0;
        int maxLength = 0;
        for(int val: arr){
            if(hm.get(val) == true){
                int tempStartPoint = val;       // The starting point for this seqeunce is val
                int tempLength = 1;             // The length of this sequence is presently 1 as it contains one element only.

                while(hm.containsKey(tempStartPoint + tempLength)){
                    tempLength++;
                }

                if(tempLength > maxLength){
                    maxStartPoint = tempStartPoint;
                    maxLength = tempLength;
                }
            }
        }

        for(int i = 0; i < maxLength; i++){
            System.out.print(maxStartPoint + i + ", ");
        }
    }
}
