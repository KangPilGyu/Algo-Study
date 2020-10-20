class Solution{
	int[][] WH = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	int solution(String office, int r, int c, String[] move){
		int answer = office[r][c], dis = 0;
		office[r][c] = 0;
		for(String s : move){
			switch(s){
				case "go" : 
					int R = r + WH[dis][0];
					int C = c + WH[dis][1];
					if(0 <= R && 0 <= C && R <= office.length && C <= office[0].length && office[R][C] != -1){
						answer += office[R][C];
						r = R;
						c = C;
						office[r][c] = 0;
					}
				case "right" : dis = dis == 3 ? 0 : (dis + 1);
				case "left" : dis = dis == 0 ? 3 : (dis - 1);
			}
		}
		return answer;
	}
}
