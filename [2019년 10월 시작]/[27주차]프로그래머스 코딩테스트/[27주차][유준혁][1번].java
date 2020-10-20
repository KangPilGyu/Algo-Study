class Solution{
	int Greedy(byte a, byte b){
		int rst = Math.abs(a - b);
		return rst > 5 ? 10 - rst : rst;
	}
	int solution(String P, String s){
		int answer = 0;
		byte[] p = P.getBytes();
		byte[] s = S.getBytes();
		for(int i = 0; i < p.length; i++){
			answer += Greedy(p[i], s[i]);
		}
		return answer;
	}
}
