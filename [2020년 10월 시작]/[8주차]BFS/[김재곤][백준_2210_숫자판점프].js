const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");
const board = [];

for(let e of input) {
    board.push(e.split(" "));
}

const dr = [-1, 0, 1, 0];
const dc = [0, 1, 0, -1];
const set = new Set();

function bfs(r, c) {
    const queue = [];
    queue.push([r, c, board[r][c]]);
    while(queue.length) {
        const e = queue.shift();
        for(let i = 0; i < 4; i++) {
            let r2 = e[0] + dr[i];
            let c2 = e[1] + dc[i];
            if(r2 < 0 || c2 < 0 || r2 >= 5 || c2 >= 5) continue;
            let num = e[2]+board[r2][c2];
            if(num.length <= 5) {
                queue.push([r2, c2, num]);
            } else if(num.length === 6) {
                set.add(num);
            }
        }
    }
}

for(let i = 0; i < 5; i++) {
    for(let j = 0; j < 5; j++) {
        bfs(i, j);
    }
}

console.log(set.size);

/*
문제
5×5 크기의 숫자판이 있다. 각각의 칸에는 숫자(digit, 0부터 9까지)가 적혀 있다. 이 숫자판의 임의의 위치에서 시작해서, 인접해 있는 네 방향으로 다섯 번 이동하면서, 각 칸에 적혀있는 숫자를 차례로 붙이면 6자리의 수가 된다. 이동을 할 때에는 한 번 거쳤던 칸을 다시 거쳐도 되며, 0으로 시작하는 000123과 같은 수로 만들 수 있다.

숫자판이 주어졌을 때, 만들 수 있는 서로 다른 여섯 자리의 수들의 개수를 구하는 프로그램을 작성하시오.

입력
다섯 개의 줄에 다섯 개의 정수로 숫자판이 주어진다.

출력
첫째 줄에 만들 수 있는 수들의 개수를 출력한다.

예제 입력 1 
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 2 1
1 1 1 1 1
예제 출력 1 
15
*/