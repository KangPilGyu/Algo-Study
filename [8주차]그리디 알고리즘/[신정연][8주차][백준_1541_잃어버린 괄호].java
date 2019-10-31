package week8;

import java.io.*;

/*
 * 백준_1541_잃어버린 괄호
 * 
 * +과 -로만 주어진 식에서 괄호를 쳐서 최소 결과 출력.
 * 
 * 55-50+40
 * --------
 * -35
 */
public class Problem_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String mathEx = br.readLine();
		String[] minusNums = mathEx.split("-");  // "-"를 기준으로 수식을 나눔. "-" 뒤의 "+"수식이 있으면 먼저 계산해서 빼주면 값이 제일 작아질 것이라고 생각.
		int result = 0;
		
		for(int i=0; i<minusNums.length; i++) {
			if(i==0) {  // 맨 앞에 숫자만 있음 그냥 더해주고 "+"수식이 있으면 계산 후 결과값에 더함.
				if(minusNums[i].contains("+")) {
					String[] plusNums = minusNums[i].split("\\+");
					for(int j=0; j<plusNums.length; j++) {
						result += Integer.parseInt(plusNums[j]);
					}
				} else {
					result += Integer.parseInt(minusNums[i]);					
				}
			} else {  // "-"뒤의 "+"수식. 계산 후 결과값에서 뺌.
				if(minusNums[i].contains("+")) {
					int plus = 0;
					String[] plusNums = minusNums[i].split("\\+");
					for(int j=0; j<plusNums.length; j++) {
						plus += Integer.parseInt(plusNums[j]);
					}
					result -= plus;
				} else {
					result -= Integer.parseInt(minusNums[i]);
				}
			}
		}
		System.out.println(result);
	}
}
