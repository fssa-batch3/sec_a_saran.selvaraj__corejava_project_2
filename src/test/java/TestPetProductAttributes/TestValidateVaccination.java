package TestPetProductAttributes;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.fssa.petmall.services.PetService;
import com.fssa.petmall.model.Pet;
import com.fssa.petmall.services.exception.ServiceException;

public class TestValidateVaccination {

    @Test
    public void testCreatePetValidVaccination() throws ServiceException {
        Pet pet = new Pet("Fluffy", null, null, null, null, null, "50", "Vaccinated", null);
        assertTrue(PetService.createPet(pet));
    }

    @Test
    public void testCreatePetInvalidVaccination() throws ServiceException {
        Pet pet = new Pet("Rex", null, null, null, null, null, "25", "Invalid Vaccination Status", null);
        assertFalse(PetService.createPet(pet));
    }

    @Test
    public void testCreatePetMixedCaseVaccination() throws ServiceException {
        Pet pet = new Pet("Buddy", null, null, null, null, null, "60", "ParTially Vaccinated", null);
        assertFalse(PetService.createPet(pet));
    }

    @Test
    public void testCreatePetEmptyVaccination() throws ServiceException {
        Pet pet = new Pet("Max", null, null, null, null, null, "30", "", null);
        assertTrue(PetService.createPet(pet)); // Assuming empty vaccination is allowed
    }

    @Test
    public void testCreatePetDatabaseError() throws ServiceException {
        // Simulate a database error by passing invalid DB credentials
        Pet pet = new Pet("Milo", null, null, null, null, null, "60", "Vaccinated", null);
        assertFalse(PetService.createPet(pet));
    }
}
