package week17;

import java.util.*;

/*
 * 백준_1068_트리
 * 
 * 5
 * -1 0 0 1 1
 * 2
 */
public class Problem_1068 {
	static int N;
	static int delNode;
	
	public static int findLeaf(int[][] tree, int parent) {
		if(parent == delNode) return 0;
		
		int leaf = 0;
		for(int i=0; i<N; i++) {
			if(tree[i][0] == parent) {
				leaf += findLeaf(tree, tree[i][1]);
			}
		}
		
		if(leaf == 0) return 1;
		return leaf;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] tree = new int[N][2];
		for(int i=0; i<N; i++) {
			tree[i][0] = sc.nextInt();
			tree[i][1] = i;
		}
		delNode = sc.nextInt();
		
		int leaf = 0;
		
		for(int i=0; i<N; i++) {
			int parent = tree[i][0];
			if(parent != delNode && parent == -1) {
				leaf += findLeaf(tree, tree[i][1]);
			}
		}
		
		System.out.println(leaf);
	}
}
