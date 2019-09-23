x = int(input())

if x == 1:
    print(0)
elif x == 2 or x == 3:
    print(1)
else:
    cache = [[-1] for i in range(x+1)]

    cache[1] = 0
    cache[2] = 1
    cache[3] = 1
    for i in range(4, x+1):
        list = []
        if i % 3 == 0:
            list.append(cache[int(i/3)])
        if i % 2 == 0:
            list.append(cache[int(i/2)])
        list.append(cache[i-1])
        cache[i] = min(list)+1
    print(cache[x])
