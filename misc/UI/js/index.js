// this is a comment

/*
this is a multiline comment
this is the same as in java
*/

// we can print to the console with console.log

console.log("Hello JS");

// semicolons are optional. just don't forget them in java

/*
js is loosely typed so you can change variable to any data type you want

*/

//numbers
var n1 = 21;
console.log(n1);

// floats
var n2 = 15.5;
console.log(n2);

var n3 = 1.5e-4;
console.log(n3);

var n4 = 1.5e4;
console.log(n4);

// what happens when we do something illegal

n5 = -6 / 0;
console.log(n5)

// there is also a type of numvber called bigint which stores numers 
// larger than 2^53

var bigint = 923790234727498723847n;
console.log(bigint);

// since js is loosely typed we can go about switching variables
// pretty easily

var a = 12;
console.log(a)

a = "twelve";
console.log(a);

// strings

// strings can be declared with single or double quotes

var name = "john";
var last = 'smith';

// objects

var obj = {
    name: "Bryan Serfozo",
    age: 25,
    height: 72,
    isTrainer: true
}

console.log(obj.name);
console.log(obj['height']);

//arrays
