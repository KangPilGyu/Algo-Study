import sys

cnt = int(sys.stdin.readline())
K = int(sys.stdin.readline())

edges = [[] for _ in range(cnt+1)]
for _ in range(K):
	n1, n2 = map(int, sys.stdin.readline().strip().split())
	edges[n1].append(n2)
	edges[n2].append(n1)

visited = []
def dfs(start):
	global visited, edges
	if start not in visited:
		visited.append(start)

	for edge in edges[start]:
		if edge not in visited:
			dfs(edge)

dfs(1)

print(len(visited)-1) 
