package rithm_p;

import java.io.IOException;

//방번호
public class P1475 {
    static int N;
    static int set = 0;
    static int[] rn = new int[9];
    public static void main(String[] args) {
        try {
            while ((N = System.in.read()) -14 > -1) {
                if (N == (int)'9') {
                    rn[6]++;
                } else {
                    rn[N-(int)'0']++;
                }
            }
            rn[6] = Math.round((float)rn[6]/2);
            for (int s : rn) {
                if(s > set){
                    set = s;
                }
            }
            System.out.println(set);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}