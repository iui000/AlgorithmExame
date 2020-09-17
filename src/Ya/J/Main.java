package Ya.J;

import java.util.Scanner;

public class Main {



    public static int fun(int n,int m) {
        int ans = 0;
        double tar = m*100;

        int left = 1;
        int right = 20;


        while (left < right){
            int mid = (left + right)/2;
            double s = 2*( Math.pow(2,mid) -1);
            double x = s/Math.pow(2,mid);

            if(n * x > tar){
                right = mid-1;
            }

            if(n * x < tar){
                left = mid+1;
            }

            if(n * x == tar){
                return left;
            }
        }


        return left;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();


        System.out.println(fun(n,m));
    }
}
