window.onload = () => {
    console.log("hello, world");
    console.log(objectLiteral.sayMyName())

    let cus1 = new Customer('Lesly', 'pass');
    let cus2 = new Customer('Torie', 'pass');

    cus1.sayMyName();
    cus2.sayMyName();

    let emp1 = new Employee('Tyler', 'pass', 'BASIC_EMPLOYEE');
    let emp2 = new Employee('Cory', 'pass', 'MANAGER');

    emp1.sayMyName();
    emp2.sayMyName();

    console.log('------------');
    console.log(objectLiteral);
    console.log(cus1);
    console.log(emp1);

    console.log('------------');
    console.log('default values')
    let emp3 = new Employee();
    console.log(emp3);
    let cus3 = new Customer();
    console.log(cus3);
    
    
    console.log('------------');
    console.log(cus3.getType());

    console.log(namedFunction());
    console.log(someObject.someObject_anonFunction());
    console.log(someObject.someObject_arrowFunction());

    console.log('--------------------------');
    let map = new PoorMansMap();
    map.put('kevin', 'fghfg');
    map.put('victoria', 'fghfgh');
    map.put('jonny', 'fgh');
    map.put('lukas', 'gfhfghfgh');

    console.log(map.get('jonny'))
    
}

// oop 

// creating an object inline
let objectLiteral = {
    name: 'Kevin',
    age: 42,
    sayHello: function () {
        return 'hello'
    },
    sayMyName: function () {
        return `hello, my name is ${this.name}`;
    }
}

// creating objects via functions/classes

function Customer(username = 'default username', password = 'default pass') {
    this.username = username;
    this.password = password;
    
    this.sayMyName = function () {
        console.log(`hello, my name is ${this.username}`)
    }

    // js engine finds the method declated in customer therefore
    // does not need to check the prototype
    this.getType = function() {
        return 'overridden behavior'
    }
}

class Employee {
    constructor(username, password, role) {
        this.username = username || 'username missing';
        this.password = password || 'pass missing';
        this.role = role || 'BASIC_USER';
    }

    sayMyName() {
        console.log(`hello, my name is ${this.username}`);
    }
}

/*
    abstraction
        - no interfaces, abstract classes
        - concept of having logic in functions to be reused
            - focusing on input/output rather than implementation
*/

/* 
    inheritance
        - prototypical inheritance
*/

function User(type) {
    this.type = type;
    this.getType = () => this.type;
}

Customer.prototype = new User('Customer');

/*
    polymorphism
*/


// functions

function namedFunction(){
    console.log('named function invoked this:');
    console.log(this);
}


let someObject = {
    someObject_anonFunction: function() {
        console.log('anonymous function invoked this:');
        console.log(this);
    },
    someObject_arrowFunction: () => {
        console.log('arrow function invoked this:');
        console.log(this);
    },
}

/*
    create a custom map
     - maps have key/value pairs
     - put(k,v)
         - add a k/v
         - overwrite v if k exists
     - get(k)
        retrieve a v associsted with k
*/

function PoorMansMap(){
    let arr = [];

    function getKeyIfExists(key){
        for (let i = 0; i < arr.length - 1; i += 2){
            if (key === arr[i]){
                return i;
            }
        }
        return -1; //case key does not exist
    }
    
    function getK(key) {
        // check arr to see if key exists
        let index = getKeyIfExists(key);
        
        if (index === -1) {
            return;
        } else {
            return arr[index + 1];
        }
    }

    function putKV(key, value) {
        //check if key exists
        
        let index = getKeyIfExists(key);
        // iterate over every other value of the array(keys)
        if (index === -1) {
            arr.push(key);
            arr.push(value);
            return;
        } else {
            arr[index + 1] = value;
        }
    }

    return {
        get: getK,
        put: putKV
    }
}