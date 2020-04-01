package programmers;
// https://programmers.co.kr/learn/courses/30/lessons/64063
// 호텔 방 배정
import java.util.*;
class Node{
	long top;
	Node(long top){
		this.top = top;
	}
}
public class prgmers_64063 {
    static long[] solution(long k, long[] room_number) {
    	Map<Long, Node> map = new HashMap<>();
    	int idx = 0;
        long[] answer = new long[room_number.length];
        for(long num : room_number) {
        	Node getNode = map.getOrDefault(num, null);
        	if(getNode == null) {
        		getNode = new Node(num);
        		map.put(num, getNode);
        		answer[idx++] = num;
        	}else {
        		long getTop = getNode.top;
        		Node newNode = map.getOrDefault(getTop + 1, null);
        		while(newNode != null) {
        			System.out.println(newNode.top);
        			getNode = newNode;
        			newNode = map.getOrDefault(newNode.top + 1, null);
        		}
        		getNode.top++;
        		map.put(getNode.top, getNode);
        		answer[idx++] = getNode.top;
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10l, new long[] {1,3,4,1,3,1})));
	}

}
