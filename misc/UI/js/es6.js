console.log('hello es6');

var sc1 = "i am global scoped";

// anything inside a block is local scope

function scopes(){
    var sc2 = 'i am in functional scope';
    if (sc2){
        let sc3 = 'i am block scope';
    }

    //console.log(sc3);
}

scopes();

hoistEx();

// hoisting example

function hoistEx(){
    console.log('i am hoisted')
}

function printMe(x){
    console.log(x)
}

// printMe(sampleText);

// let sampleText = "text sample";

// arrow functions

var simpleArrow = () => console.log('hello, i am an arrow function')

simpleArrow();

var paramArrow = (num) => {
    console.log(`we were given the number ${num}`);
    console.log(`the square of ${num} is ${num*num}`);
    return num*num;
}

paramArrow(3);

// another tyhing arrow functions are great for are callback functions

let arr = [1,2,3,4,5];
let squares = arr.map(n => n*n);

console.log(squares);