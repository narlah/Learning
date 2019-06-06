package interviewPickings;

public class OrderOfExecution extends SuperChild {
    static {
        System.out.println("Static OrderOfExecution block" + staticString);
    }

    static String staticString2 = staticString + "OrderOfExecution";

    static {
        System.out.println("Static OrderOfExecution block" + staticString2);
    }

    String instanceString = "instans string content OrderOfExecution";

    public OrderOfExecution() {
        System.out.println("In OrderOfExecution Constructor");
    }

    public static void main(String[] args) {
        System.out.println("in Main entrace");
        OrderOfExecution o = new OrderOfExecution();
        System.out.println("out of Main entrace");
    }
}

class SuperChild {
    static String staticString = "static string content SuperChild";
    static {
        System.out.println("Static SuperChild block" + staticString);
    }


    String instanceString = "instans string content SuperChild";

    public SuperChild() {
        System.out.println("    C: In SuperChild Constructor");
        System.out.println("    C: instance string toString :" + instanceString);
    }


}
