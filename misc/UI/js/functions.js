console.log('hello functions');

// let's take a look at truthy and falsy
var x = null;

if('0') {
    console.log('truthy');
} else {
    console.log('Bryan retires');
}

function simpleIf(){
    if (5 > 6) {
        console.log('yay');
    } else {
        console.log('boo');
    }
}

simpleIf();

// create a function to test whether a value is positive or negative

function simpleElseIf(num){
    if (num < 0){
        console.log('negative');
    } else if (num > 0 ) {
        console.log('positive');
    } else {
        console.log('0')
    }
}

simpleElseIf(0);
simpleElseIf(1);
simpleElseIf(-1);

var arr = [1,2,3,4,5,6,7];

// sum of an array

function sumOfArray(a) {
    var sum = 0;
    for(let i = 0; i < a.length; i++){
        sum += a[i];
    }
    return sum;
}

console.log(sumOfArray(arr));

// while loop

var num = 0;
while(num < 10){
    console.log(num)
    num++;
}

// one loop we should've seen befpre is a do while (the lord's loop)
console.log("the value of num is " + num);
do {
    console.log(num)
    num++;
} while (num <= 9);

// for of loop (arrays and array-likes)
for (n of arr){
    console.log(n * n);
}

// for in loop (objects)

var obj = {
    name: 'bob the builder',
    age: 32,
    canHeBuildIt: true
}

for (property in obj){
    console.log(`${property}: ${obj[property]}`)
}

// anonymous functions

var coolFunction = function(){
    console.log('i am a cool anonymous function')
}

// callbacks

var greaterThan = arr.find(function(n){
    return (n > 2);
})

console.log(greaterThan);

// array filter works similarly

var greaterThanFilter = arr.filter(function(n){
    return (n > 3);
})

console.log(greaterThanFilter);

// array map allows us to apply a callback function to every value in an arrray
// and create a new array based on the results

var squares = arr.map(function(n){
    return n*n;
});

console.log(squares);

// default params

function defaultParams(a, b = 1){
    return a*b;
}

console.log(defaultParams(5,2));
console.log(defaultParams(5));