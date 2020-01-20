package baekjoon_unionfind;
// https://www.acmicpc.net/problem/4195
// 친구 네트워크
/*
 * 문제
민혁이는 소셜 네트워크 사이트에서 친구를 만드는 것을 좋아하는 친구이다. 
우표를 모으는 취미가 있듯이, 민혁이는 소셜 네트워크 사이트에서 친구를 모으는 것이 취미이다.

어떤 사이트의 친구 관계가 생긴 순서대로 주어졌을 때, 
두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.

친구 네트워크란 친구 관계만으로 이동할 수 있는 사이를 말한다.

입력
첫째 줄에 테스트 케이스의 개수가 주어진다. 
각 테스트 케이스의 첫째 줄에는 친구 관계의 수 F가 주어지며, 이 값은 100,000을 넘지 않는다. 
다음 F개의 줄에는 친구 관계가 생긴 순서대로 주어진다. 
친구 관계는 두 사용자의 아이디로 이루어져 있으며, 알파벳 대문자 또는 소문자로만 이루어진 길이 20 이하의 문자열이다.

출력
친구 관계가 생길 때마다, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.
 */

/*
 * 문제 풀기 전 생각 2020.01.19 20:40
 * -------------
 * 기본적인 유니온 파인드 문제와 동일하지만 인덱스 값이 아니라 특정 string이 들어오므로 map을 써야겠다는 생각이 든다.
 * 친구 관계의 수가 100,000을 넘지 않는다고 하였으니 배열은 넉넉하게 200,001로 배정. (모든 관계가 서로만 이어져있는 경우 200,000)
 * 새로운 이름이 들어오면 배열 인덱스를 배정. 친구 관계에 대한 union-find 진행.
 * 이런식으로 풀면 되지 않을까 싶다.
 * 
 * 문제 풀면서 든 생각 2020.01.19 21:00
 * -------------
 * 합치는건 금방 끝냈는데 친구 관계에 대한 카운트 하는 부분이 조금 막힌다.
 * 간단하게 생각했을땐 배열 모든 곳을 돌면서 세는 게 쉽겠지만
 * 문제는 그게 한 row를 읽을때마다 실행해야하기 때문에 매번 2억번이 걸린다.
 * 그 2억번에서 그치는게 아니라 테스트케이스 만큼 또 돌아야하기 때문에 상당한 시간이 걸릴 것 같은데 감이 좀 안잡힌다.
 * 처음엔 유파를 진행하면서 갱신되는 애들을 count하고, 그 값들을 countMap에 업데이트 쳐주는 걸 생각했는데 막상 하니까 좀 꼬이네.
 * 
 * 문제 풀고 난 후 든 생각 2020.01.19 21:14
 * -------------
 * countMap을 따로 두려고하다보니 좀 꼬인 것 같았다.
 * 그래서 arr와 동일하게 cnt라는 배열을 선언해주고, union이 진행 될 때 마다 업데이트 해주었다.
 */
import java.util.*;
import java.io.*;
public class baekjoon_4195 {
	static int[] arr, cnt;
	static int union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			arr[a] = b;
			cnt[b] += cnt[a];
			cnt[a] = 1;
		}
		return cnt[b];
	}
    
        static int find(int x) {
        	if(x == arr[x]) return x;
        	return arr[x] = find(arr[x]);
        }
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine()), index = 0;
			arr = new int[200001];
			cnt = new int[200001];
			for(int j = 0; j < 200001; j++) {
				arr[j] = j;
				cnt[j] = 1;
			}
			Map<String, Integer> map = new HashMap<>();
			for(int j = 0; j < m; j++) {
				String[] input = br.readLine().split(" ");
				for(String s : input) {
					if(map.getOrDefault(s, -1) == -1) map.put(s, index++);
				}
				int a = map.get(input[0]), b = map.get(input[1]);
				bw.write(union(a, b) + "\n");
			}
		}
		bw.flush();
	}
}
