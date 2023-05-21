public class max {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int [] a = {1,2,34,4,5};
        System.out.println(maxi(a, 5));;
    }

    static int maxi(int []a,int n){
        if(n==0)
        return 0;

        maxi(a, n-1);
        if(a[n-1]>max){
            max = a[n-1];
        }
        return max;
    }
}
