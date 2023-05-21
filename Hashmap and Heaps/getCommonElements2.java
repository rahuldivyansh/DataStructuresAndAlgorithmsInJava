import java.util.*;
//Print the common elements minimum number of times. for eg if 2 appears three times in arr1 and 4 times in arr2 print 2 three times. Basically print intersection.


public class getCommonElements2 {
    public static void main(String[] args) {
        int arr1[] = {1,1,2,2,2,3,5};
        int arr2[] = {1,1,1,2,2,4,5};

        HashMap<Integer, Integer> hm1 = new HashMap<>();

        for(int val: arr1){
            if(hm1.containsKey(val)){
                hm1.put(val, hm1.get(val)+1);
            } else{
                hm1.put(val, 1);
            }
        }

        for(int val: arr2){
            if(hm1.containsKey(val) && hm1.get(val) != 0){
                System.out.println(val);
                hm1.put(val, hm1.get(val)-1);
            }
        }
                

        
    }
}
