package DataFromTask;

public enum Color {
    GREEN("Green"),
    BLUE("Blue"),
    ORANGE("Orange"),
    WHITE("White"),
    BROWN("Brown"),
    UNIDENTIFIED("Unidentified color");


    private final String name;

    Color(String string) {
        this.name = string;
    }

    public String getName() {
        return name.toLowerCase();
    }

    @Override
    public String toString() {
        return name.toLowerCase();
    }
}
