package DataFromTask;

public class Person {

    private String name;
    private int weight;
    private Color hairColor;
    private Country nationality;

    public Person(String name, int weight, Color hairColor, Country nationality) {
        this.name = name;
        this.weight = weight;
        this.hairColor = hairColor;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        String tab = "    ".repeat(2);
        return "\n"
                + tab + "name: " + name + "\n"
                + tab + "weight: " + weight + "\n"
                + tab + "hair color: " + hairColor.toString().toLowerCase() + "\n"
                + tab + "nationality: " + nationality.toString().toLowerCase() + "\n";
    }
}
