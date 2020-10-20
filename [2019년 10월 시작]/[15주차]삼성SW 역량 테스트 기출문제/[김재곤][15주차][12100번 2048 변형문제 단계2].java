package rithm_p;

import java.util.ArrayList;

//import java.util.Scanner;

public class p12100_dir4 {

    static int N = 4;
    static int M = 2;
    static int[][] board = {
        {1,2,2,0},
        {1,2,0,4},
        {2,0,0,4},
        {4,4,2,8}
    };
    static ArrayList<Integer> list;
    static String[] dir = {"R", "D", "L", "U"};

    static void dirCh() {
        for (String is : dir) {
            if (is.equals("R")) {
                rd(0);
            }else if(is.equals("L")){
                rd(1);
            }else if(is.equals("D")){
                rd(2);
            }else if(is.equals("U")){
                rd(3);
            }
        }
    }

    static void rd(int a) {
        for (int i = 0; i < board.length; i++) {
            list = new ArrayList<>();
            for (int j = board.length-1; j >= 0; j--) {
                if (a == 0) {
                    if (board[i][j] == 0) {
                        continue;
                    }
                    list.add(board[i][j]);
                } else if (a == 2) {
                    if (board[j][i] == 0) {
                        continue;
                    }
                    list.add(board[j][i]);
                } else if (a == 1) {
                    if (board[i][board.length -1 -j] == 0) {
                        continue;
                    }
                    list.add(board[i][board.length -1 -j]);
                } else if (a == 3) {
                    if (board[board.length -1 -j][i] == 0) {
                        continue;
                    }
                    list.add(board[board.length -1 -j][i]);
                }
            }
            ch(i ,a);
        }       
    }

    static int k;
    static void ch(int xy, int a) {;
        for (int i = 0; i < list.size()-1; i++) {
            k = list.get(i);
            if (k == list.get(i+1)) {
                list.remove(i);
                list.add(i, k*2);
                list.remove(i+1);
            }
        }
        if (list.size() != board.length) {
            for (int i = list.size(); i < board.length; i++) {
                list.add(0);
            }
        }
        insert(xy, a);
    }

    static void insert(int xy, int a){
        for (int i = 0; i < board.length; i++) {
            if (a == 0) {
                board[xy][board.length-1-i] = list.get(i);
            } else if (a == 1) {
                board[xy][i] = list.get(i);
            } else if (a == 2) {
                board[board.length-1-i][xy] = list.get(i);
            } else if (a == 3) {
                board[i][xy] = list.get(i);
            }
        }
    }

    public static void main(String[] args) {
        /* Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        dir = new String[M];
        for (int i = 0; i < M; i++) {
            dir[i] = scanner.nextLine();
        } */

        long start = System.currentTimeMillis();
        dirCh();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        //scanner.close();
    }

}