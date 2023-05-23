package DataFromTask;

public enum MovieGenre {
    WESTERN("Western"),
    DRAMA("Drama"),
    TRAGEDY("Tragedy"),
    FANTASY("Fantasy"),
    UNIDENTIFIED("Unidentified genre");


    private final String name;

    MovieGenre(String string) {
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
