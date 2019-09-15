min, max = map(int, input().split())

array = [-1 for i in range(1000001)]

# 소수 set Aera
def setArray():
    global array
    for i in range(2, 1000001):
        if (array[i] == 0): continue
        for j in range(i+i, len(array), +i):
            array[j] = 0
setArray()

arry = [-1 for i in range(1000001)]
for i in range(2, len(array)):
    if (array[i] == -1): # isPrime
        pow = i * i # 4 9 25 ...
        start = min if (min % pow == 0) else (int(min/pow)+1)*pow
        for j in range(int(start), max+1, pow):
            try:
                arry[j-min] = 0
            except:
                pass

count = 0
for i in range(max-min+1):
    if (arry[i] == -1): count +=1
print(count)


# def setAeraChe():
#     global array
#     for i in range(4, 1000001):
#         if (array[i] == 0): continue
#         if (i % 10 in [0,1,4,5,6,9]): # 제곱수의 조건인 경우 실행
#             for j in range(i, len(array), +i):
#                 array[j] = 0
#
# setAeraChe()
# print(array)
