import collections
n, m, v = map(int, input().split())

adjacencyMatrix = [[0] * (n+1) for i in range(n+1)]

for i in range(m):
	x, y = map(int, input().split())
	adjacencyMatrix[x][y] = 1
	adjacencyMatrix[y][x] = 1

dfsPrint = []
dfsVisited = [0 for i in range(n+1)]
def dfs(start):
	global adjacencyMatrix, dfsPrint, dfsVisited, n
	dfsPrint.append(start)
	dfsVisited[start] = 1
	for index in range(1, n+1):
		if dfsVisited[index] != 1 and adjacencyMatrix[start][index] == 1:
			dfs(index)
dfs(v)

bfsPrint = []
def bfs(graph, root):
	visited = []
	queue = collections.deque([root])
	while len(queue) != 0:
		vertex = queue.popleft()
		if vertex not in visited:
			visited.append(vertex)
			for index in range(1, n+1):
				if graph[vertex][index] == 1 and index not in visited:
					queue.append(index)
	return visited

print(' '.join(str(e) for e in dfsPrint))
print(' '.join(str(e) for e in bfs(adjacencyMatrix, v)))




# import sys
# N, M, V = map(int, sys.stdin.readline().strip().split())
# edge = [[] for _ in range(N+1)]
#
# for __ in range(M):
#     n1, n2 = map(int, sys.stdin.readline().strip().split())
#     edge[n1].append(n2)
#     edge[n2].append(n1)
#
# for e in edge:
#     e.sort(reverse=True)
#
# def dfs():
#     d_visit = []
#     stack = [V]
#     d_check = [0 for _ in range(N+1)]
#     while stack:
#         v1 = stack.pop()
#         if not d_check[v1]:
#             d_check[v1] = 1
#             d_visit.append(v1)
#             stack += edge[v1]
#     return d_visit
#
#
# def bfs():
#     b_visit = []
#     queue = [V]
#     b_check = [0 for _ in range(N+1)]
#     b_check[V] = 1
#     while queue:
#         v2 = queue.pop()
#         b_visit.append(v2)
#         for i in reversed(edge[v2]):
#             if not b_check[i]:
#                 b_check[i] = 1
#                 queue = [i] + queue
#     return b_visit
#
# print(' '.join(map(str,dfs())))
# print(' '.join(map(str,bfs())))
