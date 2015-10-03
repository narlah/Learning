package parserTurtle;

public class Command {
	private char commandChar;
	private int number;

	public Command(char command, int number) {
		super();
		this.commandChar = command;
		this.number = number;
	}

	@Override
	public String toString() {
		String commandFromHash = CommandHash.getCommand(commandChar);

		String numberOut = number != 0 ? new Integer(number).toString() : "";
		String commandOut = commandFromHash == null ? "No such command name" : commandFromHash;
		return commandOut + " " + numberOut;
	}

}
