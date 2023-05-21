import java.util.*;
// This return all possible paths from (1,1) to (n,m) in n*m matrix when any number of horizontal,vertical and diagonal jumps are allowed.
// h - horizontal, v - vertical , d - diagonal.
// Majority code self written.. :)

public class getMazePathsWithJump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n and m respectively: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<String> paths = gmpwj(1, 1, n, m);
        System.out.println("The final result is : " + paths);
    }

    public static ArrayList<String> gmpwj(int sr, int sc, int dr, int dc) {

        if (sr == dr && sc == dc) {
            ArrayList<String> r = new ArrayList<>();
            r.add("");
            return r;
        }

        ArrayList<String> hpaths = new ArrayList<>();
        ArrayList<String> vpaths = new ArrayList<>();
        ArrayList<String> dpaths = new ArrayList<>();
        ArrayList<String> fres = new ArrayList<>();

        for (int i = 1; i <= dc - sc; i++) {
            hpaths = gmpwj(sr, sc + i, dr, dc);
            for (String str : hpaths) {
                fres.add("h" + i + str);
            }
        }
        for (int i = 1; i <= dr - sr; i++) {
            vpaths = gmpwj(sr + i, sc, dr, dc);
            for (String str : vpaths) {
                fres.add("v" + i + str);
            }
        }
        for (int i = 1; (i <= dr - sr) && (i <= dc - sc); i++) {
            dpaths = gmpwj(sr + i, sc + i, dr, dc);
            for (String str : dpaths) {
                fres.add("d" + i + str);
            }
        }

        return fres;
    }
}
