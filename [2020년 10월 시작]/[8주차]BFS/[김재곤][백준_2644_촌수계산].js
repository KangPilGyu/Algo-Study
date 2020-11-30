const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");
const N = Number(input[0]);
const H = input[1].split(" ").map(x => Number(x));
const R = input.slice(3).map(x => x.split(" ").map(y => Number(y)));
const board = Array.from(Array(N+1), () => Array(N+1).fill(0));
const visited = Array(N+1).fill(0);

for(let to of R) {
    board[to[0]][to[1]] = 1;
    board[to[1]][to[0]] = 1;
}

let result = -1;
let cnt = 0;
function bfs(s, a) {
    const queue = [s, "e"];
    visited[s] = 1;
    while(queue.length) {
        let r = queue.shift();
        for(let i = 1; i <= N; i++) {
            if(board[r][i] && !visited[i]) {
                if(i === a) {
                    result = ++cnt;
                    return;
                }
                visited[i] = 1;
                queue.push(i);
            }
        }
        if(queue[0] === "e") {
           if(queue.length === 1) return;
           queue.shift();
           cnt++;
           queue.push("e");
        }
    }
}

bfs(H[0], H[1]);
console.log(result);

/*
문제
우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다. 이러한 촌수는 다음과 같은 방식으로 계산된다. 기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를 계산한다. 예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고, 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.

여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.

입력
사람들은 1, 2, 3, …, n (1≤n≤100)의 연속된 번호로 각각 표시된다. 입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고, 둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다. 그리고 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다. 넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다. 이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.

각 사람의 부모는 최대 한 명만 주어진다.

출력
입력에서 요구한 두 사람의 촌수를 나타내는 정수를 출력한다. 어떤 경우에는 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때가 있다. 이때에는 -1을 출력해야 한다.

예제 입력 1 
9
7 3
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6
예제 출력 1 
3
*/