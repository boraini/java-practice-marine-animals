public class TundraShelter extends Shelter {
    public TundraShelter(String ID, int volume, boolean availability) {
        super("Tundra", ID, volume, availability, "Cool Eutrophic", "Polar");
    }

    public static String getProperties() {
        return "Cool Eutrophic Water, Polar Climate";
    }

    @Override
    public String toString() {
        return "Tundra Shelter\n" + super.toString() + "\n";
    }
}
