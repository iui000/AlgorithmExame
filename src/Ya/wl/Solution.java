package Ya.wl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {

//        char[][] matrix =
//                {
//                        {'A', 'B', 'C', 'E'},
//                        {'S', 'F', 'C', 'S'},
//                        {'A', 'D', 'E', 'E'}
//                };

        Scanner scanner = new Scanner(System.in);
        List<List<Character>> arr = new ArrayList<>();
        String word = "";

        while (scanner.hasNext()){
            String tmp = scanner.nextLine();
            if(tmp.contains(",")){
                ArrayList<Character> list = new ArrayList<>();
                String[] row = tmp.split(",");
                for(String s : row){
                    list.add(s.charAt(0));
                }
                arr.add(list);
            }else {
                word = tmp;
                break;
            }
        }
        scanner.close();

        /*
        A,B,C,E
        S,F,C,S
        A,D,E,E
        ABCCED
         */
        char[][] matrix = new char[arr.size()][arr.get(0).size()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = arr.get(i).get(j);
            }
        }

        if(word.length() == 0){
            System.out.println(true);
            return;
        }

        System.out.println(exist(matrix,word));
    }

}

