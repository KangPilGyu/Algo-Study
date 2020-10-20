# solutions input ------
channel = int(input()) # 1. 그지 같은 Case...
loopCnt = int(input())

buttons = {i for i in range(0 ,10)}
buttons -= set(map(int, input().split(' '))) if loopCnt else set()

minCnt = 0x3f3f3f3f
minCnt = min(minCnt, abs(100 - channel));

def recursive(string):
    global minCnt, buttons, channel
    for btn in buttons:
        compNum = string + str(btn)
        minCnt = min(minCnt, abs(channel - int(compNum)) + len(compNum))
        if (len(compNum) < 6):
            recursive(compNum)
ㅌ
recursive('') if loopCnt < 10 else ''
print(minCnt)
