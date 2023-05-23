package DataFromTask;

public enum MpaaRating {
    PG("PG"),
    PG13("PG13"),
    R("R"),
    INVALUABLE("Invaluable");

    private final String name;

    MpaaRating(String name) {
        this.name = name;
    }

    public String getName() {
        return name.toLowerCase();
    }

    @Override
    public String toString(){
        return name.toLowerCase();
    }
}
