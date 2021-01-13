function findTree(postStart, postEnd, inStart, inEnd) {
    if((postStart > postEnd) || (inStart > inEnd)) return;
    const parent = postorder[postEnd];
    const idx = inorder.indexOf(parent);
    result += parent+" ";
    let left = idx-inStart
    findTree(postStart, postStart+left-1, inStart, idx-1);
    findTree(postStart+left, postEnd-1, idx+1, inEnd);
}

const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const nodeNum = Number(input[0]);
const inorder = input[1].split(" ").map(x => +x);
const postorder = input[2].split(" ").map(x => +x);
let result= "";
findTree(0, nodeNum-1, 0, nodeNum-1);
console.log(result);

// 문제
// n개의 정점을 갖는 이진 트리의 정점에 1부터 n까지의 번호가 중복 없이 매겨져 있다. 이와 같은 이진 트리의 인오더와 포스트오더가 주어졌을 때, 프리오더를 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 n(1≤n≤100,000)이 주어진다. 다음 줄에는 인오더를 나타내는 n개의 자연수가 주어지고, 그 다음 줄에는 같은 식으로 포스트오더가 주어진다.

// 출력
// 첫째 줄에 프리오더를 출력한다.

// 예제 입력 1 
// 3
// 1 2 3
// 1 3 2
// 예제 출력 1 
// 2 1 3
