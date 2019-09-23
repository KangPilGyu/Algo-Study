n = int(input())

# callZero = 0;
# callOne = 0;
# def fibo(n):
#     global callZero, callOne
#     if n == 0:
#         callZero += 1
#         return 0
#     elif n == 1:
#         callOne += 1
#         return 1
#     else:
#         return fibo(n-1) + fibo(n-2)

results = []


# cache = [-1 for i in range(41)]
# cache[1] = 1
# cache[2] = 1
# nn = 2
# n1 = 1
# n2 = 1
# for i in range(3, 41):
#     nn = n1 + n2
#     cache[i] = nn
#     n1 = n2
#     n2 = nn
#
# print(cache)
cache = [-1, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155]


for i in range(n):
    piboNum = int(input())
    if piboNum == 0:
        results.append('1 0')
    elif piboNum == 1:
        results.append('0 1')
    elif piboNum == 2:
        results.append('1 1')
    else:
        results.append('{} {}'.format(cache[piboNum-1], cache[piboNum]))

for res in results:
    print(res)
#
#     print(fibo(piboNum))
#     print(callZero)
#     print(callOne)
#     callZero = 0
#     callOne = 0
#
# if n == 1 || n ==2:
#     print(1)
# else:
#     nn = 2
#     n1 = 1
#     n2 = 1
#     for i in range(3, n+1):
#         nn = n1 + n2
#         n1 = n2
#         n2 = nn
#     print(nn)
