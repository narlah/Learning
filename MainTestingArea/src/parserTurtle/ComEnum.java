package parserTurtle;

public enum ComEnum {
    DOWN('D', "penDown"), UP('U', "penUp"), WEST('W', "drawWest"),

    SOUTH('S', "drawSouth"), EAST('E', "drawEast"), NORTH('N', "drawNorth"), SELECTPEN('P', "selectPen"),

    //Add new command
    SELECTZPEN('Z', "selectZPen");

    private char command;
    private String procedure;

    ComEnum(char command, String procedure) {
        this.command = command;
        this.procedure = procedure;
    }

    public char getCommand() {
        return command;
    }

    public String getProcedure() {
        return procedure;
    }

}
