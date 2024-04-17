//Star Triangle

function starTriangle(n: number) {
  for (let i = 1; i <= n; i++) {
    //space
    let line = "";
    for (let j = 0; j < n - i - 1; j++) {
      line += " ";
    }
    for (let j = 0; j < 2 * i + 1; j++) {
      line += "*";
    }
    for (let j = 0; j < n - i - 1; j++) {
      line += " ";
    }
    console.log(line);
  }
}

function reverseTriangle(n: number) {
  for (let i = n; i > 0; i--) {
    let line = "";
    for (let j = 0; j < n - i; j++) {
      line += " ";
    }
    for (let j = 0; j < 2 * i - 1; j++) {
      line += "*";
    }
    for (let j = 0; j < n - i; j++) {
      line += " ";
    }
    console.log(line);
  }
}

reverseTriangle(5);
