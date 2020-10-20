package rithm_p;
//N과 M (2)
import java.util.Scanner;

public class P15650_str {

    static int N;
    static int M;
    static int c[];
    static StringBuilder sb = new StringBuilder();
    static void out(int cnt, int j, String s) { 

        if (cnt == M) {
            sb.append(s + "\n");
            return;
        }
        for (int i = 1+j; i <= N; i++) {
            if(c[i] == 1){
                continue;
            }
            c[i] = 1;
            out(cnt + 1, i, s+i+" ");
            c[i] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        c = new int[N+1];

        out(0, 0, "");
        System.out.println(sb);

        scanner.close();
    }

}