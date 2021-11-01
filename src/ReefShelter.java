public class ReefShelter extends Shelter {
    static int area;

    public ReefShelter(String ID, int volume, boolean availability, int area) {
        super("Reef", ID, volume, availability, "Warm Trophic", "");
        this.area = area;
    }

    public static String getProperties() {
        return "Warm Trophic Water, Temperate Climate";
    }

    @Override
    public String toString() {
        return "Coastal Shelter\n" + super.toString() + " - " + area + "land area\n";
    }
}