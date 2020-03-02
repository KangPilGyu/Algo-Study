package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//막대기
public class P1094 {
    static int x, num = 0, sum = 0;
    static void stick(int h) {
        int chX = x;
        while (true) {
            if(64 == x) {
                num++;
                break;
            }
            h /= 2;
            if(chX >= h) {
                sum += h;
                num++;
                if(sum == x) {
                    break;
                }
                chX = chX - h;
            }
        }
    }
    static void stick2() {
        while (true) {
            int a = 1;
            while (true) {
                if(a * 2 > x) {
                    break;
                }
                a *= 2;
            }
            x -= a;
            if(x == 0) {
                break;
            } else {
                num++;
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //x = Integer.parseInt(br.readLine());
            //stick(64);
            System.out.println(Integer.bitCount(Integer.parseInt(br.readLine())));
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}