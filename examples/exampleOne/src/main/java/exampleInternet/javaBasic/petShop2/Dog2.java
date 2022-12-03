package exampleInternet.javaBasic.petShop2;

//Since Dog extends Animal it gets all of Animals fields and methods
//This is called inheritance
public class Dog2 extends Animal2 {

	public Dog2() {  }

	// You can override Animal methods
	public String makeSound() {
		return "Woof";
	}

	public String whoami() {
		return "Dog";
	}

	public static void main(String[] args) {
		System.out.println("class::: Dog2");

		Dog2 fido = new Dog2();
		fido.setName("Fido");
		System.out.println(fido.getName());

//		fido
		
		speakAnimal(fido);
		AnimalType(fido);
	}

}
