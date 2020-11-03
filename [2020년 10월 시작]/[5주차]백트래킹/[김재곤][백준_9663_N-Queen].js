const N = Number(require('fs').readFileSync('/dev/stdin').toString());
let cnt = 0;
const sum = [];
const sub = [];
const col = [];

function nQueen(i) {
    if(i === N) {
        cnt++;
        return;
    }
    
    for(let j = 0; j < N; j++) {
        if(col[j] === 1 || sum[i+j] === 1 || sub[i < j ? j - i : i -j + N] === 1) continue;
        col[j] = 1;
        sum[i+j] = 1;
        sub[i < j ? j - i : i -j + N] = 1;
        nQueen(i+1);
        col[j] = 0;
        sum[i+j] = 0;
        sub[i < j ? j - i : i -j + N] = 0;
    }
}

nQueen(0);
console.log(cnt);

/*
문제
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N < 15)

출력
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

예제 입력 1 
8
예제 출력 1 
92
*/