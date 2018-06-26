package interviewPickings.codeFights;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class FindFirstNonDuplicate {
    public static void main(String[] args) {
        FindFirstNonDuplicate something = new FindFirstNonDuplicate();
        System.out.println(something.firstNotRepeatingCharacter("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof"));
    }

    private char firstNotRepeatingCharacter(String str) {
        HashSet<Character> seen = new HashSet<>();
        LinkedHashSet<Character> unSeen = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            if (seen.contains(c))
                continue;
            if (unSeen.contains(c)) {
                unSeen.remove(c);
                seen.add(c);
                continue;
            }
            unSeen.add(c);
        }
        if (unSeen.size() >= 1) return unSeen.iterator().next();
        return '_';
    }
}
