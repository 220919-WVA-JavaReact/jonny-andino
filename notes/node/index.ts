type stringOrNumber = string | number;

function saySomething(something: stringOrNumber){
    console.log(something);
}

saySomething('hello');
saySomething(55);
// saySomething(true);