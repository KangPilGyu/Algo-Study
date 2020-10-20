package rithm_p;

import java.util.Arrays;
import java.util.Scanner;

class P6603 {
    static int k = -1;
    static int bit;
    static int index;
    static int[] S;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (k != 0) {
            
            k = scanner.nextInt();
            S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = scanner.nextInt();
            }
            bit = ((1 << k) -1) & ~((1 << k -6) -1);
            Arrays.sort(S);

            for (int j=bit; j>0; j--) {
                if(Integer.bitCount(j) == 6) {
                    index = k - Integer.toBinaryString(j).length();
                    for (byte bnr : Integer.toBinaryString(j).getBytes()) {
                        if(bnr != 48){
                            System.out.print(S[index] + " ");
                        }
                    index++;
                    }
                System.out.println();
                }
            }
            System.out.println();
            
        }

        scanner.close();
    }
}