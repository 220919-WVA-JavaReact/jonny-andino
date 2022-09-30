public class HelloWorld {

	public static void main(String[] args){
		System.out.println("Hello World!");
		// this is a comment
		// there are several primitive datatypes in java

		// and these are the only things that keep the language
		// from being entirely class oriented

		// how do we declare variables in java?
		// datatype variable = value;
		int     number  = 1000;
		byte    smaller = 50;
		boolean value   = true;

		System.out.println(number);
		System.out.println(smaller);
		System.out.println(value);

		byte  tiny   = 8;
		short small  = 10000;
		int   normal = 1000000;
		long  bigger = 1000000000000L;

		System.out.println(tiny);
		System.out.println(small);
		System.out.println(normal);
		System.out.println(bigger);

		// let's try float and double
		// these are goo for decimal numbers

		float decimal = 10.9f;
		System.out.println(decimal);

		char letter = 'A';
		System.out.println(letter);

		// if i want to declare a string, which is not a primative type,
		// I'll use the String keyword

		String greeting = "Hello, World!";
		System.out.println(greeting);

		// control flow
		// let's look at an if statement

		if (5 > 3) {
			System.out.println("This statement was true");
		} else {
			System.out.println("The statemant was false");
		}

		// else if

		// let's check if a number is positive, negative or 0

		int num = 9;

		if (num > 0) {
			System.out.println("pos");
		} else if (num < 0) {
			System.out.println("neg");
		} else {
			System.out.println("0");
		}

		// --operators--
		// <  less than
		// <= less than or equal to
		// >  greater than
		// >= greater than or equal to
		// == equal
		// != inequal

		// while loop

		int counter = 0;
		while (counter < 10) {
			System.out.println(counter);
			// let's reassign this variable
			// counter = counter + 1;
			// counter += 1;
			counter++;
		}

		//for loop
		for (int i = 0; i < 5; i++){
			System.out.println(i);
		}

		int a = 2;
		int b = 3;

		System.out.println(add(a,b));

		String name = "Bryan Serfozo";
		System.out.println(name.length());

	}

	// outside here i am going to define a new method
	// there are a couple pieces to each methos that we'll talk about
	// first are access modifiers which we will leave public for now
	// after this we have non access modifiers (static)
	// after this is the return type, which is the data type that will come out
	// of the method
	// then we have method name
	// after that is the final piece in tha parens, the datatypes 
        // and arguments that go into the method

	// let's take a look at defining a simple method

	public static int add(int a, int b){
		return a + b;
	}

	public static void say(String str){
		System.out.println(str);
	}
}
