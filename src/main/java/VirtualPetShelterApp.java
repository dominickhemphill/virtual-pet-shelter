import java.util.Map.Entry;
import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPetShelter flowerShop = new VirtualPetShelter();
		VirtualPet susan = new VirtualPet("Susan", "rose");
		flowerShop.addPet(susan);

		System.out.println("Welcome to grandma's flower garden!");
		System.out.println("\nThis is the status of your pets: " + "\nName\t|Hunger\t|Thirst\t|Look"
				+ "\n--------|-------|-------|-------");
		// for (Entry<String, VirtualPet> entry : flowerShop.pets.entrySet()) {
		// System.out.println(entry.getKey() + "\t|" + entry.getValue().getFlowerFood()
		// + "\t|"
		// + entry.getValue().getFlowerWater() + "\t|" +
		// entry.getValue().getFlowerAttention());
		// }

		String petOptions = "\nPress 1 to water all plants." + "\nPress 2 to feed all plants."
				+ "\nPress 3 to cultivate a specific plant." + "\nPress 4 to buy a plant."
				+ "\nPress 5 to donate a plant." + "\nPress 6 to exit.";

		String userChoice;
		while (!flowerShop.pets.isEmpty()) {
			for (Entry<String, VirtualPet> entry : flowerShop.pets.entrySet()) {
				System.out.println(entry.getKey() + "\t|" + entry.getValue().getFlowerFood() + "\t|"
						+ entry.getValue().getFlowerWater() + "\t|" + entry.getValue().getFlowerAttention());
			}

			do {
				System.out.println(petOptions);
				userChoice = input.next();
			} while (!userChoice.equals("1") && !userChoice.equals("2") && !userChoice.equals("3")
					&& !userChoice.equals("4") && !userChoice.equals("5") && !userChoice.equals("6"));
			switch (userChoice) {
			case "1":
				flowerShop.tickAll();
				flowerShop.waterAllPets();
				System.out.println("You chose to water all of the plants.");
				break;
			case "2":
				flowerShop.tickAll();
				flowerShop.feedPets();
				System.out.println("You chose to feed all of the plants");
				break;
			case "3":
				System.out.println("Choose a plant to cultivate.");
				flowerShop.tickAll();
				for (Entry<String, VirtualPet> entry : flowerShop.pets.entrySet()) {
					System.out.println(entry.getKey() + " " + entry.getValue().getDescription());
				}
				String plantPicked = input.next();
				plantPicked = plantPicked.substring(0, 1).toUpperCase() + plantPicked.substring(1).toLowerCase();
				VirtualPet selectedPlant = flowerShop.getAPet(plantPicked);
				selectedPlant.play();
				System.out.println(selectedPlant.getPetName() + " now looks wonderful.");
				break;
			case "4":
				flowerShop.tickAll();
				System.out.println("Which plant would you like to by? ");
				for (Entry<String, VirtualPet> entry : flowerShop.pets.entrySet()) {
					System.out.println(entry.getKey() + " " + entry.getValue().getDescription());
				}
				String plantPurchased = input.next();
				plantPurchased = plantPurchased.substring(0, 1).toUpperCase()
						+ plantPurchased.substring(1).toLowerCase();
				VirtualPet boughtPlant = flowerShop.getAPet(plantPurchased);
				System.out.println("Thanks for giving " + plantPurchased + "a good home.");
				flowerShop.adoptPet(boughtPlant);
				break;
			case "5":
				flowerShop.tickAll();

				System.out.println("What is the name of the plant you want to donate?");
				String plantName = input.next();
				System.out.println("What type of plant is this?");
				String plantType = input.next();
				VirtualPet newPlant = new VirtualPet(plantName, plantType);
				flowerShop.addPet(newPlant);
				System.out.println("Thanks for your donation.");
				break;
			case "6":
				System.out.println("Thanks for visiting Grandma's Flower Shop, take me with you next time.");
				System.exit(0);
				break;
			}
		}

		input.close();
	}
}
