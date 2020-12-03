package exampleInternet.javaBasic.petShop2;

public class Animal2 {


	/***
	 * variable.
	 */
	protected static int numberOfAnimals = 0;

	/****
	 * name
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	// total Animal (total objects)
	public Animal2() {
		//super();
		numberOfAnimals++;
	}

	// animal sound (make sound/speak)
	public String makeSound() {
		return "sound";
	}

	// animal type
	public String whoami() {
		return "Animal";
	}

	// ----
	public void dashedLine() {
		System.out.println("----------------------------------------");
	}
	
	
	// speakAnimal() method with pointer/reference
	public static void speakAnimal(Animal2 randAnimal2) {
		System.out.println("speakAnimal()....Animal says " + randAnimal2.makeSound());
	}

	
	// AnimalType() method with pointer/reference	
	public static void AnimalType(Animal2 randAnimal2) {
		System.out.println("AnimalType is:: " + randAnimal2.whoami());
	}
	
	/***
	 * main()
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("class::: Animal2");
		Animal2 animal = new Animal2();
		Animal2 animal2 = new Animal2();
		Animal2 animal3 = new Animal2();
		System.out.println("number Of Animals:  " + numberOfAnimals);
	}

}
