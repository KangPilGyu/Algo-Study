n , m = map(int, input().split())

# 100 X 99 X 98
cards = list(map(int, input().split()))

minAbsCnt = 30000001
answer = cards[0] + cards[1] + cards[2]

for i in range(len(cards)-2):
	for j in range(i+1, len(cards)-1):
		for k in range(j+1, len(cards)):
			tempSum = cards[i]+cards[j]+cards[k]
			if m >= tempSum and minAbsCnt > m - tempSum:
				minAbsCnt = m - tempSum
				answer = tempSum
				if answer == m: break

print(answer)
