package interviewPickings.systemDesign.dataStorkGenealogy;

public class Person {
    private String name;
    private int age;
    private int color; //16 bit or some custom object
    private boolean female = true;
    Relationships relationshipList;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setFemale(boolean female) {
        this.female = female;
    }

    public boolean isFemale() {
        return female;
    }

    public Relationships getRelationshipList() {
        return relationshipList;
    }
}
