let input = [4, 4];
let visit = new Array(input[0]).fill(false);
let result = "";

function back(cnt, str) {
    if(input[1] === cnt) {
        result += str + "\n";
        return;
    }
    for(let i = 1; i < input[0]+1; i++) {
        if(visit[i-1]) continue;
        visit[i-1] = true;
        back(cnt+1, str + i+" ");
        visit[i-1] = false;
    }
}

back(0, "");
console.log(result);
