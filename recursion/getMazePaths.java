import java.util.*;

// This program returns all possible paths from (1,1) to (n,m) in n*m matrix. 
// h - horizontal, v - vertical.
// self written code :)

public class getMazePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n and m respectively: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<String> paths = gmp(1,1,n,m);
        System.out.println("The final result is : "+paths);
    }
    static ArrayList<String> gmp(int sr,int sc, int dr,int dc){

        if(dr==sr&&dc==sc){
                ArrayList<String> r = new ArrayList<>();
                r.add("");
                return r;
        }

        ArrayList<String> paths1 = new ArrayList<>();
        ArrayList<String> paths2 = new ArrayList<>();
        if(dr>sr){
            paths1 = gmp(sr, sc, dr-1, dc);
        }
        if(dc>sc){
            paths2 = gmp(sr, sc, dr, dc-1);
        }
        ArrayList<String> fres = new ArrayList<>();

        for(String str: paths1){
            fres.add("v"+str);
        }
        for(String str: paths2){
            fres.add("h"+str);
        }
        return fres;
    }
}

// Pep coding code.
// import java.util.*;

// public class getMazePaths {
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter n and m respectively: ");
    //     int n = sc.nextInt();
    //     int m = sc.nextInt();

    //     ArrayList<String> paths = gmp(1, 1, n, m);
    //     System.out.println("The final result is : " + paths);
//     }

    // public static ArrayList<String> gmp(int sr, int sc, int dr, int dc) {

    //     if (sr == dr && sc == dc) {
    //         ArrayList<String> r = new ArrayList<>();
    //         r.add("");
    //         return r;
    //     }

    //     ArrayList<String> hpaths = new ArrayList<>();
    //     ArrayList<String> vpaths = new ArrayList<>();
    //     if (sc<dc) {
    //         hpaths = gmp(sr, sc + 1, dr, dc);
    //     }
    //     if (sr<dr) {
    //         vpaths = gmp(sr + 1, sc, dr, dc);
    //     }
    //     ArrayList<String> fres = new ArrayList<>();
    //     // System.out.println("Hello " + hpaths + " " + vpaths);
    //     for (String str : hpaths) {
    //         fres.add("h" + str);
    //     }
    //     for (String str : vpaths) {
    //         fres.add("v" + str);
    //     }
    //     return fres;
    // }
// }

