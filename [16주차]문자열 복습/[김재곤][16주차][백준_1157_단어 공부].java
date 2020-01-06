package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//단어 공부
public class P1157 {

    static String str;
    static int[] arr = new int[26];
    static int mx = 0;
    static int idx = 0; // 0으로 하면 공백 입력시 A출력 -2로 수정 공백 입력시 ?출력

    static void count() {
        for (Byte bt : str.toUpperCase().getBytes()) {
            arr[bt-65]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if(mx == arr[i]) { 
                idx = -2;
                // break;  1.ggyyzzz하면 ?가 나온다. 2.하나의 문자만 입력시 앞에서 0이 있으면 ?출력. 모든 원소를 확인할 필요가 있다.
            } else if(arr[i] > mx) {
                mx = arr[i];
                idx = i;
            }
        }
        System.out.println((char)(idx+65));
    }
    public static void main(String[] args){
        //String str = "AbcDefGaAzzZZZrtRTrtrtrtRTt";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            str = br.readLine();
            count();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
방법2
public class P1157_2 {

    static int byt;
    static int mx = 0;
    static int[] arr = new int[26];

    public static void main(String[] args){
        //String str = "AbcDefGaAzzZZZrtRTrtrtrtRTt";
        try {
            while ((byt = System.in.read() - (int)'A') > -1) {
                if (byt > 31) {
                    byt -= 32;
                }
                arr[byt]++;
            }

            for (int i = 0; i < arr.length; i++) {
                if (mx < arr[i]) {
                    mx = arr[i];
                    byt = i;
                } else if (mx == arr[i]) {
                    byt = -2;
                }
            }
            System.out.println((char)(byt+'A'));  
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 
*/