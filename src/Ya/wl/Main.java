package Ya.wl;


import java.util.Scanner;


/**
 * aidslcocscoci
 */
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if (!s.toLowerCase().contains("coc")){
            System.out.println(s);
            return;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length();) {
            String x = s.substring(i,i+3>s.length() ? s.length():i+3);
            if(x.toLowerCase().equals("coc")){
                i = i+3;
            }else {
                ans.append(s.charAt(i));
                i++;
            }
        }
        System.out.println(ans.toString());
    }
}

