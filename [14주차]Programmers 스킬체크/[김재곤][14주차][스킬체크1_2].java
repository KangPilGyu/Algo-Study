package rithm_p;

import java.util.Scanner;

//행렬의 덧셈
public class skillCheck1_2 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int[][] a = {{1,2,3},{4,5,6}};
        int[][] b = {{1,2,3},{4,5,6}};
        int[][] c = new int[b.length][b[1].length];

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.println(c[i][j]);
            }
        }

        scanner.close();

    }
    
}