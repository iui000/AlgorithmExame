package Ya.J;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {

    static Map<String,Integer> fileTofd = new HashMap<>();
    static Map<Integer,String> fdToFile = new HashMap<>();
    static int fd = 0;


    private static int open(String file_name){
        if(!file_name.contains(file_name)){

            fdToFile.put(fd,file_name);
            fileTofd.put(file_name,fd++);
            return fileTofd.get(file_name);
        }else {
            return fileTofd.get(file_name);
        }
    }

    private static int dup(Integer f){
        String fi = fdToFile.get(f);
        fdToFile.remove(f);
        int tmp = fd;
        fdToFile.put(tmp,fi);
        fileTofd.put(fi,tmp);
        fd++;
        return tmp;
    }

    private static void dup2(Integer f,Integer newf){
        String fi = fdToFile.get(f);
        fdToFile.put(newf,fi);
    }

    private static void close(Integer f){
        String fi = fdToFile.get(f);
        fdToFile.put(f,null);
        fileTofd.put(fi,null);
    }

    private static String query(Integer f){
        return fdToFile.get(f) == null ? "":fdToFile.get(f);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();

        for (int i = 0; i < c; i++) {
            int n = sc.nextInt();
            for (int j = 0; j < n ;j++) {
                String tmp =  sc.nextLine();
                String[] a = tmp.split(" ");
                if(a[0].equals("open")){
                    System.out.println(open(a[1]));
                }
                if(a[0].equals("dup")){
                    Integer fd = Integer.parseInt(a[1]);
                    System.out.println(dup(fd));
                }
                if(a[0].equals("dup2")){
                    Integer fd = Integer.parseInt(a[1]);
                    Integer newfd = Integer.parseInt(a[2]);
                    dup2(fd,newfd);
                }
                if(a[0].equals("close")){
                    Integer fd = Integer.parseInt(a[1]);
                    close(fd);
                }
                if(a[0].equals("query")){
                    Integer fd = Integer.parseInt(a[1]);
                    System.out.println(query(fd));
                }
            }
        }
    }

}
