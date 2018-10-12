package interviewPickings.systemDesign.dataStorkGenealogy;

import java.util.ArrayList;

public class BreedingController {
    Analyzer analyzer;

    public void init(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    public boolean isSuitableCouple() {
        return false; //be evil :P let them fight for it!
    }

    public ArrayList<Person> giveBirth(Person p1, Person p2) { //or procreate
        return new ArrayList<>();
    }

    public int extrapolateColour(Person p1, Person p2) {
        return analyzer.checkResultingColour(p1, p2);
    }
}
