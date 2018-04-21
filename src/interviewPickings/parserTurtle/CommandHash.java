package interviewPickings.parserTurtle;

import java.util.HashMap;

public class CommandHash {

    private static HashMap<Character, String> commandsHash = new HashMap<Character, String>();

    static {
        for (ComEnum e : ComEnum.values()) {
            commandsHash.put(e.getCommand(), e.getProcedure());
        }
    }

    public static String getCommand(Character command) {
        return commandsHash.get(command);
    }
}
