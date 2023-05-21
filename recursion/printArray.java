public class printArray {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        print(a,5);
    }

    static void print(int [] arr, int n){
        if(n==0)
        return ;
        print(arr, n-1);
        System.out.println(arr[n-1]);
    }
}
