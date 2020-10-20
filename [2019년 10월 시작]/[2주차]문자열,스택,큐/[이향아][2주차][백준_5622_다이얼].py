str = input()

num = 1
sum = 0

arr = []



for i in range(len(str)):
    arr.append(str[i])

    if arr[i] == 'A' or arr[i] == 'B' or arr[i] == 'C':
        num = 2
    elif arr[i] == 'D' or arr[i] == 'E' or arr[i] == 'F':
        num = 3
    elif arr[i] == 'G' or arr[i] == 'H' or arr[i] == 'I':
        num = 4
    elif arr[i] == 'J' or arr[i] == 'K' or arr[i] == 'L':
        num = 5
    elif arr[i] == 'M' or arr[i] == 'N' or arr[i] == 'O':
        num = 6
    elif arr[i] == 'P' or arr[i] == 'Q' or arr[i] == 'R' or arr[i] == 'S':
        num = 7
    elif arr[i] == 'T' or arr[i] == 'U' or arr[i] == 'V':
        num = 8
    elif arr[i] == 'W' or arr[i] == 'X' or arr[i] == 'Y' or arr[i] == 'Z':
        num = 9
    else:
        num = -1


    sum = sum + (num+1)

print(sum)