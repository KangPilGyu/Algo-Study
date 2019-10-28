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

tree = {}

n = int(sys.stdin.readline().strip())

for _ in range(n):
    root, left, right = sys.stdin.readline().strip().split()
    tree[root] = (None if left == '.' else left, None if right == '.' else right)

preOrder(tree, 'A')
inOrder(tree, 'A')
postOrder(tree, 'A')
