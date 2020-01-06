package rithm_p;

//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Arrays;

//알파벳 찾기
public class P10809 {
    static int S;
    static int i = 0;
    static int[] apb = new int[26];
    public static void main(String[] args) {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            Arrays.fill(apb, -1);
            while ((S = System.in.read()) -14 > -1) {
                System.out.println(S);
                if (apb[S-(int)'a'] == -1) {
                    apb[S-(int)'a'] = i;
                }
                i++;
            }
            for (int a : apb) {
                System.out.print(a+" ");
            }
            //br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}