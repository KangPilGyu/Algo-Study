import sys

N, M = map(int, sys.stdin.readline().strip().split())

array = []
for _ in range(N):
	array.append(list(sys.stdin.readline().strip()))

def bfs(start, end):
	global array, N
	Xend = len(array[0])
	Yend = N
	count = 0
	visited = [[False] * Xend for i in range(Yend)]
	queue = [(start, end)]
	returnCall = False
	visited[end][start] = True

	while queue:
		count += 1
		for _ in range(len(queue)):
			v = queue.pop(0)
			x = v[0]
			y = v[1]

			if (x == Xend-1 and y == Yend-1):
				returnCall = True
				break

			if (y >= 1 and array[y-1][x] == '1' and not visited[y-1][x]):
				visited[y-1][x] = True
				queue.append((x, y-1))
			if (x+1 < Xend and array[y][x+1] == '1' and not visited[y][x+1]):
				visited[y][x+1] = True
				queue.append((x+1, y))
			if (y+1 < Yend and array[y+1][x] == '1' and not visited[y+1][x]):
				visited[y+1][x] = True
				queue.append((x, y+1))
			if (x >= 1 and array[y][x-1] == '1' and not visited[y][x-1]):
				visited[y][x-1] = True
				queue.append((x-1, y))

		if (returnCall):
			return count


print(bfs(0,0))
