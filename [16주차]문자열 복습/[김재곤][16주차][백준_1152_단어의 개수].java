package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//단어의 개수
public class P1152 {

    static String string;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            string = br.readLine();
            StringTokenizer st = new StringTokenizer(string, " ");
            System.out.println(st.countTokens());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}