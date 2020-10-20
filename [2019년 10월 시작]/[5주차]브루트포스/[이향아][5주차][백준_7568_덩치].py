num = int(input())
stu_list = []

def _7568():

    for _ in range(num):
        weight, height= map(int, input().split())
        stu_list.append((weight, height))

    for i in stu_list:
        rank = 1
        for j in stu_list:
            if(i[0] < j[0] and i[1] < j[1]):
                rank += 1
        print(rank)



_7568()