package programmers;
// https://programmers.co.kr/learn/courses/30/lessons/64062
// 징검다리 건너기
public class prgmers_64062 {
	static int solution(int[] stones, int k) {
        int left = 1, right = 1 << 30, max = 0;
        while(left <= right){
            int mid = (left / 2) + (right / 2), cnt = 0;
            for(int i : stones) {
                cnt = (i - mid) < 0 ? cnt + 1 : 0;
                if(cnt == k) break;
            }
            System.out.println(left+", "+right+", mid:"+mid+", cross:"+(cnt < k));
            if(cnt < k) {
            	left = mid + 1;
            	max = Math.max(max, mid);
            }
            else right = mid - 1;
        }
        return max;
    }
	public static void main(String[] args) {
		int[] arr = new int[10];
		for(int i = 0; i < 10; i++) arr[i] = 200000000;
		System.out.println(solution(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
		System.out.println(solution(arr, 3));

	}

}
