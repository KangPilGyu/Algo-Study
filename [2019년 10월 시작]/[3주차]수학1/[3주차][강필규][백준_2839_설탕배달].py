kilo = int(input())

minCnt = 5001
# brute force
for five in range(0,int(kilo/5)+1):
    n = kilo - five * 5
    if n % 3 == 0:
        minCnt = min(minCnt, five + int(n/3))
print(minCnt if minCnt != 5001 else -1)
