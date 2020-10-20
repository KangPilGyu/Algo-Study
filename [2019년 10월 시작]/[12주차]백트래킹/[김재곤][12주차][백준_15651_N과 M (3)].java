package rithm_p;
//N과 M (3)
import java.util.Scanner;

public class P15651_str {

    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static void out(int cnt, String s) {
        if (cnt == M) {
            sb.append(s + "\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            out(cnt + 1, s+i+" ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        out(0, "");
        System.out.println(sb);

        scanner.close();
    }

}