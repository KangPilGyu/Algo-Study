let input = [4, 4];
let result = "";

function back(cnt, str, x) {
    if(input[1] === cnt) {
        result += str + "\n";
        return;
    }
    for(let i = x; i <= input[0]; i++) {
        back(cnt+1, str + i+" ", i+1);
    }
}

back(0, "", 1);
console.log(result);
