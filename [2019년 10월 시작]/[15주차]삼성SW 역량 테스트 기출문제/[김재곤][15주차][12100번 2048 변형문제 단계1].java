package rithm_p;

import java.util.ArrayList;

//import java.util.Scanner;

public class p12100_dir3 {

    static int N = 4;
    static int M = 2;
    static int[][] board = {
        {2,0,2,0},
        {2,2,4,4},
        {2,2,4,4},
        {2,4,8,8}
    };
    static ArrayList<Integer> list;
    static String[] dir = {"D", "D"};

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
        if (a == 2) {
            for (int i = 0; i < board.length; i++) {
                list = new ArrayList<>();
                for (int j = board.length-1; j >= 0; j--) {
                    if (board[j][i] == 0) {
                        continue;
                    }
                    list.add(board[j][i]);
                }
                ch(i);
            }       
        }
    }
    static int k;
    static void ch(int xy) {;
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
        insert(xy);
    }

    static void insert(int xy){
        for (int i = 0; i < board.length; i++) {
            board[board.length-1-i][xy] = list.get(i);
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