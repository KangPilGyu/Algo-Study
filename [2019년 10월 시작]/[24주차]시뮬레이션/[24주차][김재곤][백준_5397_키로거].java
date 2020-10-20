package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//키로거/
public class P5397 {
    /* static StringBuilder sb = new StringBuilder();
    static void key(String str) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stackBuff = new Stack<>();
        byte[] ch = str.getBytes();
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == '<') {
                if (!stack.isEmpty()) {
                    stackBuff.push(stack.pop());
                }
            } else if(ch[i] == '>') {
                if(!stackBuff.isEmpty()) {
                    stack.push(stackBuff.pop());
                }
            } else if(ch[i] == '-') {
                stack.pop();
            } else {
                stack.push((char)ch[i]);
            }
        }
        stack.stream().forEach(x -> {
            sb.append(x);
        });
        sb.append('\n');
    } */
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int tc = Integer.parseInt(br.readLine());
            for (int j = 0; j < tc; j++) {
                Stack<Character> stack = new Stack<>();
                Stack<Character> stackBuff = new Stack<>();
                byte[] ch = br.readLine().getBytes();
                for (int i = 0; i < ch.length; i++) {
                    if(ch[i] == '<') {
                        if (stack.size() != 0) {
                            stackBuff.push(stack.pop());
                        }
                    } else if(ch[i] == '>') {
                        if(stackBuff.size() != 0) {
                            stack.push(stackBuff.pop());
                        }
                    } else if(ch[i] == '-') {
                        if (stack.size() != 0) {
                            stack.pop();
                        }
                    } else {
                        stack.push((char)ch[i]);
                    }
                }
                if(stack.size() != 0) {
                    stack.stream().forEach(x -> {
                        sb.append(x);
                    });
                }
                if(stackBuff.size() != 0) {
                    while (stackBuff.size() != 0) {
                        sb.append(stackBuff.pop());
                    }
                }
                sb.append('\n');
            }
            System.out.println(sb.toString());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//방법2
/* import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int T;

    static char[] left = new char[1000001], right = new char[1000001];

    public static void main(String args[]) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        while(T-- != 0) {

            String input = br.readLine();

            int leftCur = 0, rightCur = 0;

            int len = input.length();

            for(int i = 0; i < len; ++i) {

                if(input.charAt(i) == '<') {
                    if(leftCur == 0) continue;
                    right[rightCur++] = left[--leftCur];
                } else if(input.charAt(i) == '>') {
                    if(rightCur == 0) continue;
                    left[leftCur++] = right[--rightCur];
                } else if(input.charAt(i) == '-') {
                    if(leftCur == 0) continue;
                    leftCur--;
                } else {
                    left[leftCur++] = input.charAt(i);
                }
            }

            for(int i = 0; i < leftCur; ++i)
                bw.write(left[i]);
            for(int i = rightCur - 1; i >= 0; --i)
                bw.write(right[i]);
            bw.write("\n");
            bw.flush();
        }
    }
}
 */

