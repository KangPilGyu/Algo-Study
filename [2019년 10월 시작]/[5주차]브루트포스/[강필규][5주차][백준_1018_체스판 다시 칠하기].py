n, m = map(int, input().split())
minCnt = 64

array = []
for i in range(n):
	array.append(input())

for i in range((n-8)+1):
	for j in range((m-8)+1):
		tempCase1 = 0 # WBWBWBWBWB
		tempCase2 = 0 # BWBWBWBWBW
		for dd in range(8):
			compareStr = array[i+dd][j:j+8]
			for k in range(0, len(compareStr), +2):
				if compareStr[k:k+2] == 'BB' or  compareStr[k:k+2] == 'WW':
					tempCase2 += 1
					tempCase1 += 1
				elif compareStr[k:k+2] == 'BW':
					if (dd % 2 == 0): tempCase1 += 2
					else: tempCase2 += 2
				elif compareStr[k:k+2] == 'WB':
					if (dd % 2 == 0): tempCase2 += 2
					else: tempCase1 += 2
		else:
			minCnt = min(minCnt, tempCase1, tempCase2)

print(minCnt)
