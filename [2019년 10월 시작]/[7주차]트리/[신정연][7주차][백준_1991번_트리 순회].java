package week7;

import java.io.*;

/*
 * 백준_1991_트리 순회
 * 
 * 트리를 입력 받아 전위, 중위, 후위 순회한 결과 출력.
 * 
 * 7		노드 갯수 : N
 * A B C	자신 왼쪽 오른쪽(루트는 항상 A, 연결 노드 없으면 .)
 * B D .
 * C E F
 * E . .
 * F . G
 * D . .
 * G . .
 * --------
 * ABDCEFG		전위(현재 -> 왼쪽 -> 오른쪽)
 * DBAECFG		중위(왼쪽 -> 현재 -> 오른쪽)
 * DBEGFCA		후위(왼쪽 -> 오른쪽 -> 현재)
 */
public class Problem_1991 {
	static String[][] nodes;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		nodes = new String[N][3];
		for(int i=0; i<N; i++) {
			nodes[i] = br.readLine().split(" ");
		}
		preorder(nodes[0][0]);
		System.out.println();
		inorder(nodes[0][0]);
		System.out.println();
		postorder(nodes[0][0]);
	}
	public static void preorder(String current) {
		if(!current.equals(".")) {
			System.out.print(current);
		}
		for(int i=0; i<nodes.length; i++) {
			if(nodes[i][0].equals(current)) {
				preorder(nodes[i][1]);
				preorder(nodes[i][2]);
			}		
		}
	}
	public static void inorder(String current) {
		for(int i=0; i<nodes.length; i++) {
			if(nodes[i][0].equals(current)) {
				inorder(nodes[i][1]);
				if(!current.equals(".")) {
					System.out.print(current);
				}
				inorder(nodes[i][2]);
			}		
		}
	}
	public static void postorder(String current) {
		for(int i=0; i<nodes.length; i++) {
			if(nodes[i][0].equals(current)) {
				postorder(nodes[i][1]);
				postorder(nodes[i][2]);
			}		
		}
		if(!current.equals(".")) {
			System.out.print(current);
		}
	}
}
