import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static List<Animal> animals = null;
    private static List<Shelter> shelters = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (shelters == null) {
            try {
                System.out.print("Shelter File: ");
                shelters = FileReader.readShelters(sc.nextLine());
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (animals == null) {
            try {
                System.out.print("Animals File: ");
                animals = FileReader.readAnimals(sc.nextLine());
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Please make your choice:\n" +
        "1 – Show all shelters\n" +
        "2 – Show all animals\n" +
        "3 – Show all shelters suitable for a specific animal\n" +
        "4 – Show the optimal shelters for a specific animal\n" +
        "5 – Show the constant properties per shelter type\n" +
        "6 – Stop the program");
        boolean looping = true;
        while (looping) {
            System.out.print("Choice: ");
            switch (sc.nextLine().trim()) {
                case "1" -> System.out.println(shelters);
                case "2" -> System.out.println(animals);
                case "3" -> filterSheltersForAnimal(sc);
                case "4" -> filterSheltersForAnimalAndSort(sc);
                case "5" -> getPropertiesOfShelter(sc);
                case "6" -> looping = false;
            }
        }
    }

    public static Animal findAnimal(String name) {
        for (Animal a : animals)
            if (a.getName().contains(name)) {
                return a;
            }
        return null;
    }

    public static void filterSheltersForAnimal(Scanner sc) {
        System.out.print("Animal: ");
        String name = sc.nextLine();
        final Animal animal = findAnimal(name);
        if (animal == null) {
            System.out.println("No animal was found with that name!");
            return;
        }
        System.out.println(shelters.stream().filter(animal::prefersShelter).collect(Collectors.toList()));
    }

    public static void filterSheltersForAnimalAndSort(Scanner sc) {
        System.out.print("Animal: ");
        String name = sc.nextLine();
        final Animal animal = findAnimal(name);
        if (animal == null) {
            System.out.println("No animal was found with that name!");
            return;
        }
        System.out.println(shelters.stream().filter(x -> x.getAvailability()).filter(animal::prefersShelter).sorted(animal::chooseShelter).collect(Collectors.toList()));
    }

    public static void getPropertiesOfShelter(Scanner sc) {
        System.out.println("Shelter: ");
        String type = sc.nextLine().trim();
        switch (type) {
            case "Coastal" -> System.out.println(CoastalShelter.getProperties());
            case "Tundra" -> System.out.println(TundraShelter.getProperties());
            case "Reef" -> System.out.println(ReefShelter.getProperties());
            default -> System.out.println("Shelter type not recognized!");
        }
    }
}
