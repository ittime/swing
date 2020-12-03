package exampleInternet.javaBasic.petShop2;

public class Duck2 extends Animal2 {

	public Duck2() { }

	public String makeSound() {
		return "Ga Ga Ga";
	}

	public String whoami() {
		return "Duck";
	}

	public static void main(String[] args) {
		
		System.out.println("class::: Duck2");

		Duck2 duck = new Duck2();
		duck.makeSound();
		duck.setName("albert");
		System.out.println("duck name is: " + duck.getName());
		
		duck.setName("yoyo");
		System.out.println("duck name is: " + duck.getName());

		AnimalType(duck);
		
		
		
	}

}
