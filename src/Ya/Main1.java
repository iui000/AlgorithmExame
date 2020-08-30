package Ya;

import java.util.Scanner;


public class Main1 {
    static int n,m,r,c;

    static int[][] cost = new int[20][20]  ;
    static int[][] f = new int[20][20]  ;

    static int[] xc = new int[20]  ;
    static int[][] yc = new int[20][20]  ;

    static int[] value = new int[20];
    static int y;

    static int res = 19919191;

    public static void dfs(int x)
    {
        if(y==r)
        {
            dp();
            return;
        }
        for(int i=x+1;i<=n;i++)
        {
            y++;
            value[y]=i;
            dfs(i);
            y--;
        }
    }

    public static void dp()
    {
        f = new int[20][20];
        xc = new int[20];
        yc = new int[20][20];

        value[r+1]= value[r];
        for(int i=1;i<=m;i++)
            for(int j=1;j<=r;j++)
                xc[i]+= Math.abs(cost[value[j]][i]- cost[value[j+1]][i]);


        for(int i=1;i<=m;i++)
            for(int j=i+1;j<=m;j++)
                for(int k=1;k<=r;k++)
                    yc[i][j]+=Math.abs(cost[value[k]][i]- cost[value[k]][j]);

        for(int i=1;i<=m;i++)
            f[1][i]=xc[i];

        for(int i=2;i<=c;i++)
            for(int j=i;j<=m;j++)
            {
                int ans=101001010;
                for(int k=i-1;k<j;k++)
                    ans=Math.min(ans,f[i-1][k]+yc[k][j]);

                f[i][j]=ans+xc[j];
            }

        for(int i=c;i<=m;i++)
            res =Math.min(f[c][i], res);

    }


    /*
4 4  2 2
5 4 2 6
4 10 1 8
1 9 3 10
6 4 8 3
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 主要负责接收数据
         n = scanner.nextInt();
         m = scanner.nextInt();
         r = scanner.nextInt();
         c = scanner.nextInt();


        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= m; j++) {
                cost[i][j] = scanner.nextInt();
            }
        }

        dfs(0);
        System.out.println(res);

    }

}

