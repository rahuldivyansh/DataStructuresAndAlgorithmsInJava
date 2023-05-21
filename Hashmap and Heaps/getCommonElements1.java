import java.util.*;

public class getCommonElements1 {

    public static void main(String[] args) {
        int arr1[] = {1,1,2,2,2,3,5};
        int arr2[] = {1,1,1,2,2,4,5};

        HashMap <Integer, Boolean> hm = new HashMap<>();

        for(int val: arr1){
            hm.put(val, false);
        }

        for(int val: arr2){
            if(hm.containsKey(val) && hm.get(val) == false){
                System.out.println(val);
                hm.put(val, true);
            }
        }
    }
}
