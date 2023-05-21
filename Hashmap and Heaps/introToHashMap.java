import java.util.*;

public class introToHashMap{
    public static void main(String[] args) {
        HashMap <String, Integer> hm = new HashMap<>();

        hm.put("India", 125);
        hm.put("China", 762);
        hm.put("Pakistan", 34);
        hm.put("Indonesia", 56);

        System.out.println();
        System.out.println(hm);
        System.out.println(hm.get("india"));
        System.out.println(hm.containsKey("India"));

        Set<String> keys = hm.keySet();
        System.out.println("The keys are: " + keys);
        for(String key : keys){
            Integer val = hm.get(key);
            System.out.println(key+ " " +val);
        }


    }
}