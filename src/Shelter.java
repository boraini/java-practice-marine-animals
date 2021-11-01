import java.util.Scanner;

public abstract class Shelter {
    private String type;
    private String ID;
    private int volume;
    private boolean availability;
    private String waterType;
    private String climate;

    public Shelter(String type, String ID, int volume, boolean availability, String waterType, String climate) {
        this.type = type;
        this.ID = ID;
        this.volume = volume;
        this.availability = availability;
        this.waterType = waterType;
        this.climate = climate;
    }

    public String getType() {
        return type;
    }

    public String getID() {
        return ID;
    }

    public int getVolume() {
        return volume;
    }

    public boolean getAvailability() {
        return availability;
    }

    public String getWaterType() {
        return waterType;
    }

    public String getClimate() {
        return climate;
    }

    public static Shelter read(String def) {
        Scanner sc = new Scanner(def + " ");
        sc.useDelimiter(" ");
        String type = sc.next();
        String id = sc.next();
        int volume = Integer.parseInt(sc.next());
        boolean availability = Boolean.parseBoolean(sc.next());
        Shelter result = null;
        switch (type) {
            case "Coastal" -> result = new CoastalShelter(id, volume, availability, Integer.parseInt(sc.next()));
            case "Tundra" -> result = new TundraShelter(id, volume, availability);
            case "Reef" -> result = new ReefShelter(id, volume, availability, Integer.parseInt(sc.next()));
        }
        sc.close();
        if (result == null) throw new IllegalStateException();
        return result;
    }

    @Override
    public String toString() {
        return "ID" + ID +
                ", volume: " + volume +
                ", availability: " + availability +
                ", waterType: " + waterType +
                ", climate: " + climate;
    }
}
