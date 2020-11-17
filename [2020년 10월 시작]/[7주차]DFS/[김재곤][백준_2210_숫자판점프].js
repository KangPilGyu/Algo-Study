const board = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n").map(x => x.split(" ").map(y => Number(y)));
const number = {"length":0};
const dy = [-1, 0, 1, 0];
const dx = [0, 1, 0, -1];

function dfs(y, x, cnt, numStr) {
    if(cnt === 6) {
        if(!number[numStr]) {
            number[numStr] = 1;
            number.length++;
        }
        return;
    }
    for(let i = 0; i < 4; i++) {
        let y2 = y + dy[i];
        let x2 = x + dx[i];
        if(y2 < 0 || x2 < 0 || y2 >= 5 || x2 >= 5) continue;
        dfs(y2, x2, cnt+1, numStr+board[y][x]);
    }
}

for(let i = 0; i < 5; i++) {
    for(let j = 0; j < 5; j++) {
        dfs(i, j, 0, "");
    }
}

console.log(number.length);

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