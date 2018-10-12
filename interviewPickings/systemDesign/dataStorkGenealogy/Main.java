package interviewPickings.systemDesign.dataStorkGenealogy;

public class Main {

    public static void main(String[] args) {
        Person mother = new Person();
        mother.setColor(1);
        mother.setAge(20);
        mother.setFemale(true);
        mother.setName("Maria");

        Person father = new Person();
        father.setColor(2);
        father.setAge(22);
        father.setFemale(false);
        father.setName("Ivan");

        BreedingController breedingController = new BreedingController();
        breedingController.init(new Analyzer());
        System.out.println(breedingController.extrapolateColour(mother, father));
    }
}

