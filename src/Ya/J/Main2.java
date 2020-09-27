package Ya.J;

import java.util.Scanner;

public class Main2 {
    static long[][] arr;


    /**
     * 旋转数组，顺时针打印变成顺时针赋值
     * @param matrix
     * @param
     */
    public static void spiralOrder(long[][] matrix,long k) {

        boolean spiral = true;
        int rows = matrix.length,
                columns = matrix[0].length;

        //设置最外层左上角和右下角的坐标
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;

        while (left <= right && top <= bottom) {

            if(spiral){//顺时针
                //上边，包含右上角的点
                for (int column = left; column <= right; column++) {
                    matrix[top][column] = k++;
                }
                //右边，包含右下角的点
                for (int row = top + 1; row <= bottom; row++) {
                    matrix[row][right] = k++;
                }
                //先判断有没有下边界 和 左边界
                if (left < right && top < bottom) {
                    //下边，不包含右下角的点
                    for (int column = right - 1; column > left; column--) {
                        matrix[bottom][column] = k++;
                    }
                    //左边，包含左下角的点
                    for (int row = bottom; row > top; row--) {
                        matrix[row][left] = k++;
                    }
                }

            }else {
                //先判断有没有下边界 和 左边界
//                if (left <= right && top <= bottom) {

                    //左边，不包含左下角的点
                    for (int row = top; row < bottom; row++) {
                        matrix[row][left] = k++;
                    }
                    //下边，包含左下角的点，不包含右下角的点
                    for (int column =left ; column < right ; column++) {
                        matrix[bottom][column] = k++;
                    }

//                }

                //右边，包含右下角的点，不包含右上角的点
                for (int row = bottom; row >  top ; row--) {
                    matrix[row][right] = k++;
                }
                //上边，包含右上角的点
                for (int column =right; column > left; column--) {
                    matrix[top][column] = k++;
                }


            }
            spiral = !spiral;
            //向内收缩一层
            left++;
            right--;
            top++;
            bottom--;
        }

        if(rows % 2 == 1){
            int mid = rows /2;
            matrix[mid][mid] = rows * rows;
        }

    }


    public static long fun(long[][] matrix ,int x,int y) {
        if(x >= matrix.length || y >= matrix[0].length){
            return -1L;
        }
        return matrix[x][y];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();


        for (int i = 0; i < c; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            arr = new long[n][n];
            spiralOrder(arr,1);
            //打印数组
//        for(int i =0;i < n;i++){
//            for(int j =0;j < n;j++){
//                System.out.printf("%d%c", arr[i][j], j==n-1 ? '\n' : ' ');
//            }
//        }
            for (int j = 0; j < m ;j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                System.out.println(fun(arr,x,y));
            }
        }
    }
}
