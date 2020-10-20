package rithm_p;

import java.util.LinkedList;
import java.util.Queue;

//섬연결하기 프림
public class Pms42861_p {
    static int n = 4;
    static int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
    static boolean[] A = new boolean[n];
    static int total = 0;
    static Queue<Integer> queue = new LinkedList<>();
    static int min; 
    static int[] arrmin = new int[costs[0].length];
    static void bfs() {
        queue.add(0);
        while (queue.size() != n) {
            min = 2147483647;// int 최대값
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int x = queue.poll();
                for (int[] cs : costs) {
                    if((cs[0] == x || cs [1] == x) && !(A[cs[0]] && A[cs[1]])) {
                        if(cs[2] < min) {
                            min = cs[2];
                            arrmin = cs;   
                        }
                    }
                }
            }
            A[arrmin[0]] = true;
            A[arrmin[1]] = true;
            for (int i = 0; i < A.length; i++) {
                if(A[i] == true) {
                    queue.add(i);
                }
            }
            total += arrmin[2];
        }
    }
    public static void main(String[] args) {
        bfs();
        System.out.println(total);
    }
}
/* 
class Solution {
    static boolean[] A;
    static Queue<Integer> queue = new LinkedList<>();
    static int min; 
    static int total = 0;
    static int[] arrmin;
    static int bfs(int n, int[][] costs) {
        queue.add(0);
        while (queue.size() != n) {
            min = 2147483647;
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int x = queue.poll();
                for (int[] cs : costs) {
                    if((cs[0] == x || cs [1] == x) && !(A[cs[0]] && A[cs[1]])) {
                        if(cs[2] < min) {
                            min = cs[2];
                            arrmin = cs;   
                        }
                    }
                }
            }
            A[arrmin[0]] = true;
            A[arrmin[1]] = true;
            for (int i = 0; i < A.length; i++) {
                if(A[i] == true) {
                    queue.add(i);
                }
            }
            total += arrmin[2];
        }
        return total;
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        A = new boolean[n];
        arrmin = new int[costs[0].length];
        answer = bfs(n, costs);
        return answer;
    }
}
 */