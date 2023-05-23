package DataFromTask;

public enum Country {
    SPAIN("Spain"),
    CHINA("China"),
    INDIA("India"),
    UNIDENTIFIED("Unidentified country");

    private final String name;

    Country(String string) {
        this.name = string;
    }

    public String getName() {
        return name.toLowerCase();
    }

    @Override
    public String toString() {
        return name;
    }
}
