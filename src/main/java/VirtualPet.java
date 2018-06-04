
public class VirtualPet {

	private String petName;
	private String description;
	private int flowerFood;
	private int flowerWater;
	private int flowerAttention;
	private int amount = 10;

	public VirtualPet(String name, String type, int feed, int water, int play) {
		petName = name;
		description = type;
		flowerFood = feed;
		flowerWater = water;
		flowerAttention = play;
	}

	public VirtualPet(String name, String description) {
		this.petName = name;
		this.description = description;
		this.flowerFood = 50;
		this.flowerWater = 50;
		this.flowerAttention = 50;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFlowerFood() {
		return flowerFood;
	}

	public void setFlowerFood(int flowerFood) {
		this.flowerFood = flowerFood;
	}

	public int getFlowerWater() {
		return flowerWater;
	}

	public void setFlowerWater(int flowerWater) {
		this.flowerWater = flowerWater;
	}

	public int getFlowerAttention() {
		return flowerAttention;
	}

	public void setFlowerAttention(int flowerAttention) {
		this.flowerAttention = flowerAttention;
	}

	public void tick() {
		flowerFood -= 1;
		flowerWater -= 1;
		flowerAttention -= 1;
	}

	public void feed() {
		flowerFood += amount;
		flowerAttention -= amount / 3;
	}

	public void water() {
		flowerWater += amount;
		flowerAttention -= amount / 3;

	}

	public void play() {
		flowerAttention += 10;
		flowerFood -= amount / 3;
	}

	public boolean myPlantLives() {
		if (flowerFood > 0 && flowerWater > 0 && flowerAttention > 0) {
			return true;
		}
		return false;

	}
}