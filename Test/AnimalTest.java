import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    void constructorTest() {
        Animal a = new Animal("", 0, new ArrayList<String>());
        assertNotNull(a, "constructor does not return null");
    }

    @Test
    void getNameTest() {
        Animal a = new Animal("", 0, new ArrayList<String>());
        assertEquals("", a.getName(), "getName works");
    }

    @Test
    void getMinVolumeTest() {
        Animal a = new Animal("", 0, new ArrayList<String>());
        assertEquals(0, a.getMinVolume(), "getName works");
    }

    @Test
    void getPreferredSheltersTest() {
        Animal a = new Animal("", 0, new ArrayList<String>());
        assertEquals(new ArrayList<>(), a.getName(), "getName works");
    }

    @Test
    void prefersShelterTest() {
        List<String> p = new ArrayList<>();
        p.add("Tundra");
        Animal a = new Animal("", 0, p);
        assertTrue(a.prefersShelter(new TundraShelter("", 0, true)));
    }

    @Test
    void toStringTest() {
        List<String> p = new ArrayList<>();
        p.add("Tundra");
        Animal a = new Animal("", 0, p);
        System.out.println(a.toString());
        assertEquals("-  minimum shelter volume: 0, preferred shelter types: [Tundra]\n", a.toString());
    }
}