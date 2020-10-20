def _1652():
    N = int(input())
    Map = []
    for i in range(N):
        Map.append(list(str(input())))


    width = 0
    height = 0
    cnt = 0

    for i in range(N):
        cnt = 0
        for j in range(N):
            if Map[i][j] == '.':
                cnt += 1
            else:
                cnt = 0

            if cnt == 2:
                width += 1

    for i in range(N):
        cnt = 0
        for j in range(N):
            if Map[j][i] == '.':
                cnt += 1
            else:
                cnt = 0
            if cnt == 2:
                height +=1
    print(width, height)

_1652()
