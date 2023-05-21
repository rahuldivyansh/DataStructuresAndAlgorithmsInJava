import java.util.*;

public class highestFrequencyCharacter {
    public static void main(String[] args) {
         int [] arr = {1,2,2,2,2,5,1,9,4,4,7,7,7,7,7,7};

         HashMap <Integer, Integer> hm = new HashMap<>();

         for(int idx: arr){
            if(hm.containsKey(idx)){
                hm.put(idx, hm.get(idx)+1);
            } else{
                hm.put(idx, 1);
            }
         }

         Integer maxKey = arr[0];
         for(Integer key: hm.keySet()){
            if(hm.get(key) > hm.get(maxKey)){
                maxKey = key;
            }
         }

         System.out.println(maxKey);
    }
}
