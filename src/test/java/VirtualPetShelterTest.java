import java.util.Collection;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

public class VirtualPetShelterTest {
	VirtualPetShelter shelter = new VirtualPetShelter();

	
	
	@Test
	public Collection<VirtualPet>getPetsShouldReturnAllPets(){
		//shelter.addPet(new VirtualPet("Rose", "flower", 10, 10, 10));
		//Arrange
		Collection underTest = shelter.getPets();
		Assert.assertEquals ("Rose", underTest);
		//return underTest;
		
		//Act
		
		//Assert
	}
}
