n, k = map(int, input().split())

cache = [0 for i in range(k+1)]
cache[0] = 1
coins = [0 for i in range(n)]

for i in range(n):
     coins[i] = int(input())

for i in range(0, n):
    for j in range(1, k+1):
        if (j >= coins[i]):
            cache[j] += cache[j-coins[i]]
print(cache[k])
