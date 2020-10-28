let str = require('fs').readFileSync('/dev/stdin').toString().trim();
let idx = 0;
let jCnt = 0;
let iCnt = 0;

while(str.length - idx >= 3) {
    if(str.slice(idx, idx + 3) === "JOI") {
        jCnt++;
        idx += 2;
    } else if(str.slice(idx, idx + 3) === "IOI") {
        iCnt++;
        idx += 2;
    } else {
        if(str.slice(idx + 1, idx + 2) === "O") idx += 2;
        else idx += 1;
    }
}

console.log(jCnt+'\n'+iCnt);

// 문제
// 입력으로 주어지는 문자열에서 연속으로 3개의 문자가 JOI 또는 IOI인 곳이 각각 몇 개 있는지 구하는 프로그램을 작성하시오. 문자열은 알파벳 대문자로만 이루어져 있다. 예를 들어, 아래와 같이 "JOIOIOI"에는 JOI가 1개, IOI가 2개 있다.

// 입력
// 첫째 줄에 알파벳 10000자 이내의 문자열이 주어진다. 

// 출력
// 첫째 줄에 문자열에 포함되어 있는 JOI의 개수, 둘째 줄에 IOI의 개수를 출력한다.

// 예제 입력 1 
// JOIOIOIOI
// 예제 출력 1 
// 1
// 3
