import sys

#최소 스패닝 트리는,
#주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서
#그 가중치의 합이 최소인 트리를 말한다.

vertex, edge = map(int ,sys.stdin.readline().strip().split())
tree = {}
for _ in range(edge):
    v1, v2, g = map(int, sys.stdin.readline().strip().split())
    if g in tree:
        tree[g].append((v1, v2))
    else:
        tree[g] = [(v1,v2)]

# union-find
# cycle이 존재하는지 확인 방법
# make-set
union_set = [i for i in range(vertex+1)]

def find(vt):
    global union_set
    if union_set[vt] != vt:
        union_set[vt] = find(union_set[vt])
    return union_set[vt]

def union(vt1, vt2):
    global union_set
    root1 = find(vt1)
    root2 = find(vt2)

    # 루트 노드가 같지 않은 경우 합쳐
    if root1 != root2:
        union_set[root1] = root2

def kruskalMST(tree):
    # 가중치 오름차순으로 Loop
    gAry = sorted(tree)
    result = 0
    for i in gAry:
        for edges in tree[i]:
            # 사이클이 없는 경우에만 
            if find(edges[0]) != find(edges[1]):
                union(edges[0], edges[1])
                result += i
    print(result)

kruskalMST(tree)
