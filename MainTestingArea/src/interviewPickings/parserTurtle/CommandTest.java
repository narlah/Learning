package interviewPickings.parserTurtle;

public class CommandTest {
    public static void main(String[] args) {
        // String parseText = "P 1\nD\nW 2\nS 2\nE 2\nN 2\nU";
        String parseText = "P -1\nD\nW 2\nS 2\nE 2\nN 2\nU";
        System.out.println(parseText + "\n");

        String[] result = parseText.split("\n");
        for (int i = 0; i < result.length; i++) {
            Command c = ParseCommands.parseCommand(result[i]);
            System.out.println(c.toString());
        }

    }
}
