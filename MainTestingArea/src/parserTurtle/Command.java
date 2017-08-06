package parserTurtle;

class Command {
    private char commandChar;
    private int number;

    Command(char command, int number) {
        super();
        this.commandChar = command;
        this.number = number;
    }

    @Override
    public String toString() {
        String commandFromHash = CommandHash.getCommand(commandChar);

        String numberOut = number != 0 ? Integer.toString(number) : "";
        String commandOut = commandFromHash == null ? "No such command name" : commandFromHash;
        return commandOut + " " + numberOut;
    }
}
