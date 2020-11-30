const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");
const firstLine = input[0].split(" ").map(x => Number(x));
const RAW = firstLine[0], COL = firstLine[1], MAP = [];
const dx = [0, 1, 0, -1], dy = [-1, 0, 1, 0];
let hour = 0, cnt;

for(let i = 1; i <= RAW; i++) {
    MAP.push(input[i].split(""));
}

function bfs(r, c, visited) {
    visited[r][c] = 1;
    cnt = 0;
    let q = []
    q.push([r, c]);
    q.push(1);
    while(q.length) {
        let s = q.shift();
        for(let i = 0; i < 4; i++) {
            let r2 = s[0] + dy[i];
            let c2 = s[1] + dx[i];
            if(r2 >= 0 && c2 >= 0 && r2 < RAW && c2 < COL && MAP[r2][c2] === "L" && !visited[r2][c2]) { 
                q.push([r2, c2]);
                visited[r2][c2] = 1;
            }
        }
        if(q[0] === 1 && q.length !== 1) {
            cnt += q.shift();
            q.push(1);
        }
    }
}

for(let i = 0; i < RAW; i++) {
    for(let j = 0; j < COL; j++) {
        if(MAP[i][j] === "L") {
            let visited = Array.from(Array(RAW), () => Array(COL).fill(0));
            bfs(i, j, visited);
            hour = Math.max(cnt, hour);
        }
    }
}

console.log(hour);

/*
문제
보물섬 지도를 발견한 후크 선장은 보물을 찾아나섰다. 보물섬 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다. 각 칸은 육지(L)나 바다(W)로 표시되어 있다. 이 지도에서 이동은 상하좌우로 이웃한 육지로만 가능하며, 한 칸 이동하는데 한 시간이 걸린다. 보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다. 육지를 나타내는 두 곳 사이를 최단 거리로 이동하려면 같은 곳을 두 번 이상 지나가거나, 멀리 돌아가서는 안 된다.



예를 들어 위와 같이 지도가 주어졌다면 보물은 아래 표시된 두 곳에 묻혀 있게 되고, 이 둘 사이의 최단 거리로 이동하는 시간은 8시간이 된다.



보물 지도가 주어질 때, 보물이 묻혀 있는 두 곳 간의 최단 거리로 이동하는 시간을 구하는 프로그램을 작성하시오.

입력
첫째 줄에는 보물 지도의 세로의 크기와 가로의 크기가 빈칸을 사이에 두고 주어진다. 이어 L과 W로 표시된 보물 지도가 아래의 예와 같이 주어지며, 각 문자 사이에는 빈 칸이 없다. 보물 지도의 가로, 세로의 크기는 각각 50이하이다.

출력
첫째 줄에 보물이 묻혀 있는 두 곳 사이를 최단 거리로 이동하는 시간을 출력한다.

예제 입력 1 
5 7
WLLWWWL
LLLWLLL
LWLWLWW
LWLWLLL
WLLWLWW
예제 출력 1 
8
*/