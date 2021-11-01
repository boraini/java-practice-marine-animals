import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<Shelter> readShelters(String pathName) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new FileInputStream(pathName));
        List<Shelter> shelters = new ArrayList<>();
        while (sc.hasNextLine()) shelters.add(Shelter.read(sc.nextLine()));
        return shelters;
    }

    public static List<Animal> readAnimals(String pathName) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new FileInputStream(pathName));
        List<Animal> animals = new ArrayList<>();
        while (sc.hasNextLine()) animals.add(Animal.read(sc.nextLine()));
        return animals;
    }
}
