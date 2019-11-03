


import sys
import json

# root left right
def preOrder(tree, root):
    stack = []
    stack.append(root)
    printStr = ''
    while 0 < len(stack):
        node = stack.pop()
        printStr += node

        if (tree[node][1] != None):
            stack.append(tree[node][1])
        if (tree[node][0] != None):
            stack.append(tree[node][0])
    print(printStr)

# left  root right
def inOrder(tree, root):
    stack = []
    stack.append(root)
    printStr = ''
    node = root
    while True:
        # left circle
        while (tree[node][0] != None):
            if node not in printStr:
                stack.append(tree[node][0])
                node = tree[node][0]
            else:
                break
        if 0 < len(stack):
            node = stack.pop()
            printStr += node
            if (tree[node][1] != None):
                stack.append(tree[node][1])
                node = tree[node][1]
        else:
            break
    print(printStr)

# left right root
def postOrder(tree, root):
    stack = []
    stack.append(root)
    printStr = ''
    node = root
    while True:
        # left circle
        while tree[node][0] != None:
            if tree[node][0] not in printStr:
                stack.append(tree[node][0])
                node = tree[node][0]
            else:
                break
        # right isExist??
        lastRightData = stack[-1]

        if tree[lastRightData][1] == None:
            printStr += stack.pop()
            if stack:
                node = stack[-1]
            else:
                break
        else:
            if tree[node][1] not in printStr:
                stack.append(tree[node][1])
                node = tree[node][1]
            else:
                printStr += stack.pop()
                if 0 < len(stack):
                    node = stack[-1]
                else:
                    break
    print(printStr)

maxR = -1
visited = []
last_vertex = 0
tree = {}

# 1. 임의의 정점으로 부터 가장 먼 정점을 구한다.
# 2. 1에서 나온 정점으로 부터 가장 먼 정점을 구한다.
# 3. 1과 2에서 나온 정점간의 거리가 트리의 지름!
def dfs(vertex, vlen):
    global tree, maxR, last_vertex
    if vertex in visited:
        return
    visited.append(vertex)
    if maxR < vlen:
        maxR = vlen
        last_vertex = vertex
    for i in range(len(tree[vertex])):
        dfs(tree[vertex][i][0], vlen+tree[vertex][i][1])

n = int(sys.stdin.readline().strip())

for _ in range(n):
    strlist = sys.stdin.readline().strip().split()
    ary = []
    for i in range(1, len(strlist)-1, +2):
        ary.append((int(strlist[i]), int(strlist[i+1])))
    tree[int(strlist[0])] = ary

dfs(1, 0)
recentLast_vertex = last_vertex;
maxR = 0
last_vertex = 0
visited = []
dfs(recentLast_vertex, 0)
print(maxR)
# preOrder(tree, 'A')
# inOrder(tree, 'A')
# postOrder(tree, 'A')



# class Tree():
#     def __init__(self):
#         self.data = None
#         self.left = None
#         self.right = None
# n = int(sys.stdin.readline().strip())
#
# tree = Tree()
#
# def findTree(bTree, data):
#     if bTree.data == data:
#         return bTree
#     if bTree.left:
#         findTree(bTree.left, data)
#     if bTree.right:
#         findTree(bTree.right, data)
#
# tree = {}
# for _ in range(n):
#     root, left, right = sys.stdin.readline().strip().split()
#     temp = findTree(tree, root)
#     print(temp)
#     if left != '.':
#         temp.left = Tree()
#         temp.left.data = left
#     if right != '.':
#         temp.right = Tree()
#         temp.right.data = right
