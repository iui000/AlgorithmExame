package Ya.J;

import java.util.Scanner;

public class Main {

//    public static int fun(String[] args) {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int ans = 0;
        double tar = m*100;
        double tmp = 0.0;
        int i = 1;
        while (tar > 0.0){
            tmp += Math.pow(2,i);
            double x = n - n/tmp;
            tar -= x;
            ans++;
            i++;
        }
        System.out.println(ans);
    }
}
