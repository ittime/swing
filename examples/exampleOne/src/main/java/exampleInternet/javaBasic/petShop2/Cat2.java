package exampleInternet.javaBasic.petShop2;

//Since Cat extends Animal it gets all of Animals fields and methods
//This is called inheritance
public class Cat2 extends Animal2 {

	public Cat2() {	}

	// Overriding the Animal method
	public String makeSound() {
		return "Meow";
	}

	public String whoami() {
		return "Cat";
	}
	

	public static void main(String[] args) {
		System.out.println("class::: Cat2");

		Animal2 fido = new Dog2();

		Animal2 fluffy = new Cat2();

		Animal2 duck = new Duck2();

		// We can have an array of Animals that contain more specific subclasses
		// Any overridden methods are used instead because of polymorphism
		Animal2[] theAnimals = new Animal2[10];

		theAnimals[0] = fido;
		theAnimals[1] = fluffy;
		theAnimals[2] = duck;

		System.out.println("Fido says: " + theAnimals[0].makeSound());
		System.out.println("Fluffy says: " + theAnimals[1].makeSound());
		System.out.println("duck says: " + theAnimals[2].makeSound());

		fluffy.dashedLine();
		
		// We can also pass subclasses of Animal and they just work
		speakAnimal(fido);
		speakAnimal(fluffy);
		speakAnimal(duck);
		
		fluffy.dashedLine();
		
		AnimalType(fido);
		AnimalType(fluffy);
		AnimalType(duck);
//		System.out.println()

	}

}