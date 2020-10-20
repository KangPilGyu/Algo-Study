n = int(input())

array = []
cache = [[-1]*3 for i in range(n)]
for i in range(n):
    mapp = list(map(int, input().split()))
    array.append(mapp)

cache[0][0] = array[0][0]
cache[0][1] = array[0][1]
cache[0][2] = array[0][2]
for i in range(1, n):
    cache[i][0] = min(cache[i-1][1], cache[i-1][2]) + array[i][0]
    cache[i][1] = min(cache[i-1][0], cache[i-1][2]) + array[i][1]
    cache[i][2] = min(cache[i-1][0], cache[i-1][1]) + array[i][2]

print(min(cache[n-1][0], cache[n-1][1], cache[n-1][2]))
