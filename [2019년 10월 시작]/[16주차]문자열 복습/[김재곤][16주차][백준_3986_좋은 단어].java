package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//좋은 단어
public class P3986 {
    static int N;
    static String word;
    static String[] a;
    static int cnt = 0;
    static Stack<String> stack = new Stack<>();
    static void check() {
        for (int i = 0; i < word.length(); i++) {
            if(stack.empty()) {
                stack.push(a[i]);
            } else if (!stack.peek().equals(a[i])) {
                stack.push(a[i]);
            } else {
                stack.pop();
            }
        }
        if (stack.empty()) {
            cnt++;
        }
        stack.removeAllElements();
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                word = br.readLine();
                a = word.split("");
                check();
            }
            System.out.println(cnt);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/* 
방법2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final char blank = '\0';
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String line = null;
        char[] word = null;
        char[] result =null;

        int cnt = 0;
        for (int i = 0; i <n; i++) {
            line = br.readLine();
            word = line.toCharArray();
            result = new char[100000];
            int length = word.length;
            int index = 0;
            for (int j = 0; j < length; j++) {
                result[index++] = word[j];
                if (index >= 2) {
                    char currentChar = result[index - 1];
                    char prevChar = result[index - 2];
                    if (((currentChar == 'A') && (prevChar == 'A')) || ((currentChar == 'B') && (prevChar == 'B'))) {
                        result[index] = blank;
                        index = index - 2;
                    }
                }
            }
            if(index == 0){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
*/