package interviewPickings.systemDesign.dataStorkGenealogy;

import java.util.ArrayList;
import java.util.HashMap;

public class Relationships {
    HashMap<String, ArrayList<Person>> map;

    public Relationships(ArrayList<Person> parents) {
        map = new HashMap<>();
        //check if pos 1 is female == true -> female
        //add all relationships here - cousins, w/e
        map.put("parents", parents);
    }
}
