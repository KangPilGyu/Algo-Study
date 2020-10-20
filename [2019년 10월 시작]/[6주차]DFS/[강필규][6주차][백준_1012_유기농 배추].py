import sys
sys.setrecursionlimit(100000) # ㅁㅊ https://qkqhxla1.tistory.com/615
T = int(sys.stdin.readline())

def solution():
	M, N, K = map(int, sys.stdin.readline().strip().split())
	nodes = [[0] * (M) for i in range(N)]
	for _ in range(K):
		y, x = map(int, sys.stdin.readline().strip().split())
		nodes[x][y] = 1

	def dfs(x, y):
		if x >= N or x < 0 or y >= M or y < 0:
			return
		nodes[x][y] = 0
		if x+1 < N and nodes[x+1][y] == 1:
			dfs(x+1, y)
		if y+1 < M and nodes[x][y+1] == 1:
			dfs(x, y+1)
		if x-1 >= 0 and nodes[x-1][y] == 1:
			dfs(x-1, y)
		if y-1 >= 0 and nodes[x][y-1] == 1:
			dfs(x, y-1)

	componentCnt = 0
	for i in range(N):
		for j in range(M):
			if nodes[i][j] == 1:
				dfs(i, j)
				componentCnt +=1
	return componentCnt


answers = []
for __ in range(T):
	answers.append(solution())
for answer in answers:
	print(answer)
