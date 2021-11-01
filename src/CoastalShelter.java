public class CoastalShelter extends Shelter {
    private static int uniqueTypes;
    public CoastalShelter(String ID, int volume, boolean availability, int uniqueTypes) {
        super("Coastal", ID, volume, availability, "Cool Eutrophic", "Temperate");
        this.uniqueTypes = uniqueTypes;
    }

    public static String getProperties() {
        return "Cool Eutrophic Water, Temperate Climate";
    }

    @Override
    public String toString() {
        return "Coastal Shelter\n" + super.toString() + " - " + uniqueTypes + "unique coral types\n";
    }
}
