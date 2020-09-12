package Ya.wl;


import java.util.Scanner;


/**
 * aidslcocsi
 */
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String tmp = s.toLowerCase();
        StringBuilder ans = new StringBuilder();

        if (!tmp.contains("coc")){
            System.out.println(s);
            return;
        }

        int begin = 0;
        while (begin <= s.length() && tmp.indexOf("coc") >= 0){

            int i = tmp.indexOf("coc");
            String x = s.substring(begin,begin + i);
            ans.append(x);

            begin = begin + i + 3;

            tmp = s.substring(i+3);
        }

        if(begin < s.length()){
            ans.append(s.substring(begin));
        }


        System.out.println(ans.toString());
    }
}

