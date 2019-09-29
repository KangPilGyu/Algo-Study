n = int(input())

array = [0 for i in range(n)]
rank = [1 for i in range(n)]

for i in range(n):
	array[i] = list(map(int, input().split()))

for i in range(n):
	for j in range(n):
		if i == j:
			continue
		if (array[i][0] < array[j][0] and array[i][1] < array[j][1]):
			rank[i] += 1;

print(' '.join(str(e) for e in rank))
