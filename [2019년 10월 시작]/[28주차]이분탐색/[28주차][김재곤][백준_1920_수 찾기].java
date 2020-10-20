package rithm_p;
/* 
문제
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1≤N≤100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1≤M≤100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

출력
M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.

예제 입력 1 
5
4 1 5 2 3
5
1 3 7 9 5
예제 출력 1 
1
1
0
0
1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BinarySearch_P1920 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new  StringTokenizer(br.readLine());            
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            Integer.parseInt(br.readLine());
            st = new  StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int c = 0;
                int start = 0;
                int end = arr.length-1;
                int mid = (start + end)/2;
                int t = Integer.parseInt(st.nextToken());
                while (end - start >= 0) {
                    if(arr[mid] == t) {
                        c = 1;
                        break;
                    } else if(arr[mid] > t) {
                        end = mid-1;
                    } else {
                        start = mid+1;
                    }
                    mid = (start + end)/2;
                }
                System.out.println(c);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/* 
public class BinarySearch_P1920 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb  = new StringBuilder();
            Integer.parseInt(br.readLine());
            StringTokenizer st = new  StringTokenizer(br.readLine());            
            Set<Integer> set = new HashSet<>();
            while (st.hasMoreTokens()) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            Integer.parseInt(br.readLine());
            st = new  StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                if(set.contains(Integer.parseInt(st.nextToken()))) {
                    sb.append("1"+'\n');
                    //System.out.println(1);
                } else {
                    sb.append("0"+'\n');
                    //System.out.println(0);
                }
            }
            System.out.println(sb.toString());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 */