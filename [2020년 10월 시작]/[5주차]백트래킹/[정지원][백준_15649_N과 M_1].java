package backtracking;

import java.io.*;
import java.util.*;

public class _15649 {
	static int n, m;
	static boolean[] vst;
	static StringBuilder sb = new StringBuilder();
	
	static void func(int cnt, String str) {
		// 종료조건
		if (cnt == m) {
			sb.append(str + "\n");
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (vst[i] == false) {
				vst[i] = true;
				func(cnt+1, str+i+" ");
				vst[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		vst = new boolean[n+1];		// 사실상 vst[]에서 사용하는 건 vst[1] ~ vst[n]뿐이지만 배열은 0부터 시작하니까 n+1 해줌
		func(0, "");
		System.out.println(sb);
	}
}

//n = 3, m = 2
//출력 (cnt(0<=cnt<=m), str + true가 된 시점의 i)
//
//func(0, "")
//cnt = 0, str = ""
//i = 1) vst[1] = false -> true
//        func(1, 1) 	// func(cnt, str + true가 된 시점의 i)
//	       *func(1, 1)
//	        cnt = 1, str = 1
//	        i = 1) vst[1] = true 건너 뜀
//	        i = 2) vst[2] = false -> true
//		   func(2, 1 2)	// func(cnt, str + true가 된 시점의 i)
//			     * func(2, 1 2) ----- 종료조건 ------
//			       cnt = 2, str = 1 2
//			       출력 (1 2)
//		   vst[2] = false
//	        i = 3) vst[3] = false -> true
//		   func(3, 1 3)	// func(cnt, str + true가 된 시점의 i) 
//			     * func(3, 1 3) ----- 종료조건 ------
//			       cnt = 3, str = 1 3
//			       출력 (1 3)
//		   vst[3] = false
//        vst[1] = false
//i = 2) vst[2] = false -> true
//        func(1, 2)	// func(cnt, str + true가 된 시점의 i)
//	       * func(1, 2)
//	         cnt = 1, str = 2
//	         i = 1) vst[1] = false -> true
//		   func(2, 2 1)	// func(cnt, str + true가 된 시점의 i)
//		 	     * func(2, 2 1) ----- 종료 조건 -----
//			       cnt = 2, str = 2 1
//			       출력 (2 1)
//		    vst[1] = false
//	         i = 2) vst[2] = true 건너 뜀
//	         i = 3) vst[3] = false -> true
//		    func(2, 2 3) 	// func(cnt, str + true가 된 시점의 i)
//			      * func(2, 2 3) ----- 종료 조건 -----
//			        cnt = 2, str = 2 3
//			        출력 (2 3)
//		    vst[3] = false
//        vst[2] = false
//i = 3) vst[3] = false -> true
//        func(1, 3)	// func(cnt, str + true가 된 시점의 i)
//	       * func(1, 3)
//	         cnt = 1, str = 3
//	         i = 1) vst[1] = false -> true
//		    func(2, 3 1)	// func(cnt, str + true가 된 시점의 i)
//			      * func(2, 3 1) ---- 종료 조건 -----
//			        cnt = 2, str = 3 1
//			        출력 (3 1)
//		  vst[1] = false
//	       i = 2) vst[2] = false -> true
//		 func(2, 3 2)	// func(cnt, str + true가 된 시점의 i)
//			   * func(2, 3 2) ----- 종료 조건 -----
//			     cnt = 2, str = 3 2
//			     출력 (3 2)
//		 vst[2] = false
//	      i = 3) vst[3] = true 건너 뜀
//      vst[3] = false