package programmers;
// https://programmers.co.kr/learn/courses/30/lessons/64061
// 크레인 인형뽑기 게임

import java.util.*;
public class prgmers_64061 {
	static int solution(int[][] board, int[] moves) {
        int answer = 0, len = board.length;
        int[] topArr = new int[len];
        for(int i = 0; i < len; i++) topArr[i] = -1;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(board[i][j] != 0 && topArr[j] == -1) topArr[j] = i;
            }
        }
        Stack<Integer> stack = new Stack<>();
        for(int i : moves){
            int idx = i - 1;
            if(topArr[idx] != -1 && topArr[idx] < len){
                if(!stack.isEmpty() && stack.peek() == board[topArr[idx]][idx]){
                    stack.pop();
                    answer += 2;
                }else{
                    stack.push(board[topArr[idx]][idx]);
                }
                topArr[idx]++;
            }
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[] {1,5,3,5,1,2,1,4}));

	}

}
/*
 * 1 5 3 5 1 2 1 4
 * ---------
 * 0 0 0 0 0
 * 0 0 1 0 3
 * 0 2 5 0 1
 * 4 2 4 4 2
 * 3 5 1 3 1
 * 
 * 4 3 1 1 3 2 4
 */
