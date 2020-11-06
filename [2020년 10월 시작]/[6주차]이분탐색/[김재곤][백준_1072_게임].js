let input = require('fs').readFileSync('/dev/stdin').toString().split(' ');
const X = Number(input[0]);
const Y = Number(input[1]);
const Z = Math.floor((Y * 100) / X );
let cnt = -1;

function game() {
    let start = 0;
    let end = 1000000000;
    let mid = 0;
    let per = 0;
    while(start <= end) {
        mid = Math.floor((start + end) / 2);
        per = Math.floor(((Y + mid) * 100) / (X + mid));
        if(per > Z) {
            end = mid - 1;
            cnt = mid;
        } else {
            start = mid + 1;
        }
    }
}

if(Z < 99) {
    game();
}
console.log(cnt);

// 문제
// 김형택은 지금 몰래 Spider Solitaire(스파이더 카드놀이)를 하고 있다. 형택이는 이 게임을 이길 때도 있었지만, 질 때도 있었다. 누군가의 시선이 느껴진 형택이는 게임을 중단하고 코딩을 하기 시작했다. 의심을 피했다고 생각한 형택이는 다시 게임을 켰다. 그 때 형택이는 잠시 코딩을 하는 사이에 자신의 게임 실력이 눈에 띄게 향상된 것을 알았다.

// 이제 형택이는 앞으로의 모든 게임에서 지지 않는다. 하지만, 형택이는 게임 기록을 삭제 할 수 없기 때문에, 자신의 못하던 예전 기록이 현재 자신의 엄청난 실력을 증명하지 못한다고 생각했다.

// 게임 기록은 다음과 같이 생겼다.

// 게임 횟수 : X
// 이긴 게임 : Y (Z %)
// Z는 형택이의 승률이다. 소수점은 버린다. 예를 들어, X=53, Y=47이라면, Z = 88이다.
// X와 Y가 주어졌을 때, 형택이가 게임을 최소 몇 판 더 해야 Z가 변하는지 구하는 프로그램을 작성하시오.

// 입력
// 각 줄에 X와 Y가 주어진다. X는 1,000,000,000보다 작거나 같은 자연수이고, Y는 0보다 크거나 같고, X보다 작거나 같은 자연수이다.

// 출력
// 첫째 줄에 형택이가 게임을 최소 몇 판 더 해야하는지 출력한다. 만약 Z가 절대 변하지 않는다면 -1을 출력한다.

// 예제 입력 1 
// 10 8
// 예제 출력 1 
// 1
// 예제 입력 2 
// 100 80
// 예제 출력 2 
// 6