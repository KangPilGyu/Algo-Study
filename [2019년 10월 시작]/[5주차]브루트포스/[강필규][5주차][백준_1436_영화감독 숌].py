n = int(input())

def makeCurseNumber(num):
	if (num == 1): return 666;
	currentNum = 2
	addUseNum = 1;
	while (True):
		tempSet = set()
		maxLoop = ''
		for loop in range(addUseNum):
			maxLoop += '9'

		for k in range(0, int(maxLoop)+1):
			for i in range(len(str(k))+1):
				tmpStr = str(k)
				if len(maxLoop) != len(str(k)):
					for ll in range(len(maxLoop)-len(str(k))):
						tmpStr = '0' + tmpStr
				temp = tmpStr[:i] + '666' +  tmpStr[i:]
				if temp[0] == '0' or len(temp) != addUseNum+3:
					continue
				tempSet.add(int(temp))
		#print(sorted(list(tempSet)))
		if num <= currentNum + len(tempSet) - 1:
			return sorted(list(tempSet))[num-currentNum]
		currentNum += len(tempSet)
		addUseNum +=1

print(makeCurseNumber(n))
