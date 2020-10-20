n = int(input())

if n == 1 || n ==2:
    print(1)
else:
    nn = 2
    n1 = 1
    n2 = 1
    for i in range(3, n+1):
        nn = n1 + n2
        n1 = n2
        n2 = nn
    print(nn)
