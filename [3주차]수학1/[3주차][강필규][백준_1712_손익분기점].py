a, b, c = map(int, input().split(' '))

if (a <= 0 or c < 0 or b < 0 or c - b <= 0 ):
    print(-1)
else:
    i = int(a / (c-b))
    print(i+1)
