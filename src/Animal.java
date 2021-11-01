import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Animal {
    private String name;
    private int minVolume;
    private List<String> preferredShelters;

    public Animal(String name, int minVolume, List<String> preferredShelters) {
        this.name = name;
        this.minVolume = minVolume;
        this.preferredShelters = preferredShelters;
    }

    public String getName() {
        return name;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public List<String> getPreferredShelters() {
        return preferredShelters;
    }

    public static Animal read(String def) {
        Scanner sc = new Scanner(def + ", ");
        sc.useDelimiter("; ");
        String name = sc.next();
        int minVolume = Integer.parseInt(sc.next());
        sc.skip("; ");
        sc.useDelimiter(", ");
        List<String> preferredShelters = new ArrayList<>();
        while(sc.hasNext()) preferredShelters.add(sc.next());
        sc.close();
        return new Animal(name, minVolume, preferredShelters);
    }

    public boolean prefersShelter(Shelter s) {
        return minVolume <= s.getVolume() && preferredShelters.contains(s.getType());
    }

    public int chooseShelter(Shelter a, Shelter b) {
        int ag = 1;
        int bg = -1;
        boolean pa = prefersShelter(a) && a.getAvailability();
        boolean pb = prefersShelter(b) && b.getAvailability();
        int va = a.getVolume();
        int vb = b.getVolume();
        if (pa && !pb) return ag;
        else if (pb && !pa) return bg;
        else if (!pa && !pb) return 0;
        else {
            if (preferredShelters.indexOf(a.getType()) < preferredShelters.indexOf(b.getType())) return ag;
            return va < vb ? ag : bg;
        }
    }

    @Override
    public String toString() {
        return name +
                "-  minimum shelter volume: " + minVolume +
                ", preferred shelter types: " + preferredShelters +
                "\n";
    }
}
