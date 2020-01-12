package baekjoon_tree;
import java.util.*;
public class baekjoon_1068 {
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static void treeSet(int[] arr) {
		for(int i = 0; i < arr.length; i++) tree.add(new ArrayList<Integer>());
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == -1) continue;
			tree.get(arr[i]).add(i);
		}
	}
	static int dfs(int target, int cnt) {
		int size = tree.get(target).size();
		if(size == 0) return cnt + 1;
		for(int i = 0; i < size; i++) {
			cnt = dfs(tree.get(target).get(i), cnt);
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), root = -1;
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			root = arr[i] == -1 ? i : root;
		}
		int target = sc.nextInt();
		if(target == root) {
			System.out.println(0);
			return;
		}
		arr[target] = -1;
		treeSet(arr);

		System.out.println(dfs(root, 0));
	}
}
