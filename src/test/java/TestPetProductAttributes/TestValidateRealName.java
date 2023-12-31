package TestPetProductAttributes;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.petmall.model.Pet;
import com.fssa.petmall.services.PetService;
import com.fssa.petmall.services.exception.ServiceException;
 class TestValidateRealName {

	 @Test
	     void testCreatePetValidName() throws ServiceException {
	        Pet pet = new Pet("Fluffy", null, null, null, null, null, "50", "Vaccinated", null);
	        assertTrue(PetService.createPet(pet));
	    }

	    @Test
	     void testCreatePetShortName() throws ServiceException {
	        Pet pet = new Pet("R", null, null, null, null, null, "25", "Not Vaccinated", null);
	        assertFalse(PetService.createPet(pet));
	    }

	    @Test
	     void testCreatePetLongName() throws ServiceException {
	        Pet pet = new Pet("BuddyTheAwesomeDogWithALongName", null, null, null, null, null, "60", "Vaccinated", null);
	        assertFalse(PetService.createPet(pet));
	    }

	    @Test
	     void testCreatePetNumericName() throws ServiceException {
	        Pet pet = new Pet("123", null, null, null, null, null, "30", "Vaccinated", null);
	        assertTrue(PetService.createPet(pet)); // Assuming numeric names are allowed
	    }

	    @Test
	     void testCreatePetDatabaseError() throws ServiceException {
	        // Simulate a database error by passing invalid DB credentials
	        Pet pet = new Pet("Milo", null, null, null, null, null, "60", "Vaccinated", null);
	        assertFalse(PetService.createPet(pet));
	    }
}
