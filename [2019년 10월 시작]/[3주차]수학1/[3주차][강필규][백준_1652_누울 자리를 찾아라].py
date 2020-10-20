def countRows(rowArry):
	cnt = 0
	for row in rowArry:
		if (len(row) >= 2):
			cnt+=1
	return cnt

loop = int(input())

arry = ['' for col in range(loop)]

rowCnt = 0
for i in range(loop):
	str = input()
	splitedStr = str.split('X');
	rowCnt += countRows(splitedStr);
	for j in range(loop):
		arry[j] = "".join((arry[j], str[j]))

colCnt = 0
for str in arry:
	splitedStr = str.split('X');
	colCnt += countRows(splitedStr)

print("{0} {1}".format(rowCnt,colCnt))
