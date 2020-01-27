package rithm_p;

//섬연결하기 크루스칼
public class Pms42861_k {
    static int n = 4;
    static int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
    static int[] A = new int[n];
    static int total = 0;
    static int find(int x) {
        if(x == A[x]) {
            return x;
        }
        return A[x] = find(A[x]);
    }
    static int union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) {
            A[y] = A[x];
            return 1;
        }
        return 0;
    }
    static void costSort() {
        int[] sw = new int[costs[1].length];
        for (int i = 0; i < costs.length-1; i++) {
            for (int j = i+1; j < costs.length; j++) {
                if(costs[i][2] > costs[j][2]) {
                    sw = costs[i];
                    costs[i] = costs[j];
                    costs[j] = sw;
                }
            }
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }
        // Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2])); 느림
        costSort();
        for (int i = 0; i < costs.length; i++) {
            if(union(costs[i][0], costs[i][1]) == 1) {
                total += costs[i][2];
            }
        }
        System.out.println(total);
    }
}
/* 
class Solution {
    static int[] A;
    static int find(int x) {
        if(x == A[x]) {
            return x;
        }
        return A[x] = find(A[x]);
    }
    static int union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) {
            A[y] = A[x];
            return 1;
        }
        return 0;
    }
    static void costSort(int[][] costs) {
        int[] sw = new int[costs[1].length];
        for (int i = 0; i < costs.length-1; i++) {
            for (int j = i+1; j < costs.length; j++) {
                if(costs[i][2] > costs[j][2]) {
                    sw = costs[i];
                    costs[i] = costs[j];
                    costs[j] = sw;
                }
              }
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        A = new int[n];
        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }
        costSort(costs);
        for (int i = 0; i < costs.length; i++) {
            if(union(costs[i][0], costs[i][1]) == 1) {
                answer += costs[i][2];
            }
        }
        return answer;
    }
}
 */