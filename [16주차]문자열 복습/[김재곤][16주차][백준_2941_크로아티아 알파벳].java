package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//크로아티아 알파벳
public class P2941 {
    static String cro;
    static String[] a = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    static void ch() {
        for (String st : a) {
            cro = cro.replace(st, "*");
        }
        System.out.println(cro.length());
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            cro = br.readLine();
            ch();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}