let input = [3, 3];
let result = "";

function back(cnt, str) {
    if(input[1] === cnt) {
        result += str + "\n";
        return;
    }
    for(let i = 1; i <= input[0]; i++) {
        back(cnt+1, str + i+" ");
    }
}

back(0, "");
console.log(result);
