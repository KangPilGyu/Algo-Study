n = input()
minCnt = 1000001

for i in range(int(n), 1, -1):
	print(i)
	tempSum = 0;
	tempStr = str(i);
	for k in range(len(tempStr)):
		tempSum += int(tempStr[k])
	tempSum = i + tempSum
	if (tempSum == int(n)):
		minCnt = min(minCnt, i)

print(minCnt if minCnt != 1000001 else 0)
