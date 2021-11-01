import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShelterTest {
    @Test
    void constructorTest() {
        Shelter s = new TundraShelter("A", 10, false);
        assertNotNull(s, "constructor works");
    }

    @Test
    void getIDTest() {
        Shelter s = new TundraShelter("A", 10, false);
        assertEquals("A", s.getID(), "getID works");
    }

    @Test
    void getVolume() {
        Shelter s = new TundraShelter("A", 10, false);
        assertEquals("A", s.getID(), "getID works");
    }

    @Test
    void getAvailabilityTest() {
        Shelter s = new TundraShelter("A", 10, false);
        assertEquals("A", s.getAvailability(), "getID works");
    }

    @Test
    void getWaterTypeTest() {
        Shelter s = new TundraShelter("A", 10, false);
        assertNotNull(s.getWaterType(), "getWaterType returns something");
    }

    @Test
    void getClimateTest() {
        Shelter s = new TundraShelter("A", 10, false);
        assertNotNull(s.getClimate(), "getWaterType returns something");
    }

    @Test
    void toStringTest() {
        Shelter s = new TundraShelter("A", 10, false);
        assertEquals("Tundra Shelter\n" +
                "IDA, volume: 10, availability: false, waterType: Cool Eutrophic, climate: Polar\n", s.toString());
    }
}