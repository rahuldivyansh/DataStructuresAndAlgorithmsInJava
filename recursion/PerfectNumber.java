import java.io.*;
import java.util.*;

class Solution {
    public ArrayList<Integer> perfect(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        findPerfectNumbers(1, n, result);
        return result;
    }

    public void findPerfectNumbers(int start, int end, ArrayList<Integer> result) {
        if (start <= end) {
            if (isPerfect(start, start - 1, 0)) {
                result.add(start);
            }
            findPerfectNumbers(start + 1, end, result);
        }
    }

    public boolean isPerfect(int num, int divisor, int sum) {
        if (divisor == 0) {
            return sum == num;
        }
        if (num % divisor == 0) {
            sum += divisor;
        }
        return isPerfect(num, divisor - 1, sum);
    }
}

public class PerfectNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
 
        // Reading N and K
        String str = bufferedReader.readLine().trim();
        int n = Integer.parseInt(str);
        
        Solution solution = new Solution();
        ArrayList<Integer> result = solution.perfect(n);
        System.out.println(result);
    }
}