package rithm_p;

import java.util.ArrayList;
import java.util.Scanner;

public class P14501 {
    static int Ti;
    static int Pi;
    static int[] t;
    static int sumPi;
    static void mn(int j, ArrayList<int[]> week, int day, int sum) {
        t = week.get(j);
        if(j+t[0] <= day) {
            sum += t[1];
            //System.out.println("sum: " + sum+","+j);
            for (int k = j+t[0]; k < day; k++) {
                //System.out.println(k);
                mn(k, week, day, sum);
            }
        }
        if(sum > sumPi) {
            sumPi = sum;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<int[]> week = new ArrayList<>();
        int today[];
        
        int day = scanner.nextInt();
        for (int i = 0; i < day; i++) {
            today = new int[2];
            Ti = scanner.nextInt();
            Pi = scanner.nextInt();
            today[0] = Ti;
            today[1] = Pi;
            week.add(today);
        }
        int sum = 0;
        for (int i = 0; i < day; i++) {
            mn(i, week, day, sum);
        }
        System.out.println(sumPi);
        scanner.close();
    }  
}
/* 
        class P2 {
            int Ti;
            int Pi;
    
            public P2(int Ti, int Pi) {
                this.Ti = Ti;
                this.Pi = Pi;
            }
    
            public int getTi() {
                return Ti;
            }  
            public int getPi() {
                return Pi;
            }
            
        } */