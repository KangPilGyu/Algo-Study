import sys
import collections

N, M = map(int, sys.stdin.readline().strip().split())

# collecions.deque 대신 [] 사용할 경우 pop(0) 호출시에 모든 자리 땡겨서 O(n) 소비됨
initQueue = collections.deque([])
array = []
total = 0
for i in range(M):
	strList = list(map(int, sys.stdin.readline().strip().split()))
	array.append(strList)
	for idx in range(len(strList)):
		if (strList[idx] == 1):
			initQueue.append((idx, i))
			total += 1
		if (strList[idx] == -1):
			total += 1

def bfs():
	global initQueue, array, N, M, total
	queue = initQueue
	day = 0
	while queue:
		changedTomatos = False
		for _ in range(len(queue)):
			v = queue.popleft()
			x = v[0]
			y = v[1]

			if (y >= 1 and array[y-1][x] == 0):
				array[y-1][x] = 1
				total += 1
				changedTomatos = True
				queue.append((x, y-1))
			if (x+1 < N and array[y][x+1] == 0):
				array[y][x+1] = 1
				total += 1
				changedTomatos = True
				queue.append((x+1, y))
			if (y+1 < M and array[y+1][x] == 0):
				array[y+1][x] = 1
				total += 1
				changedTomatos = True
				queue.append((x, y+1))
			if (x >= 1 and array[y][x-1] == 0):
				array[y][x-1] = 1
				total += 1
				changedTomatos = True
				queue.append((x-1, y))
		if (not changedTomatos):
			break
		day += 1

	return day if (total == N*M) else -1

print(bfs())
