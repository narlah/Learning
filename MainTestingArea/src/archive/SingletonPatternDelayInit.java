package archive;

final class Singleton {
    private static Singleton s = null;
    private int i;

    private Singleton(int x) {
        i = x;
    }

    static Singleton getReference() {
        if (s == null) {
            return new Singleton(47);
        } else
            return s;
    }

    public int getValue() {
        return i;
    }

    public void setValue(int x) {
        i = x;
    }
}

// : c01:SingletonPattern.java
// The Singleton design pattern: you can
// never instantiate more than one.
// Since this isn't inherited from a Cloneable
// base class and cloneability isn't added,
// making it final prevents cloneability from
// being added through inheritance:
public class SingletonPatternDelayInit {
    public static void main(String[] args) {
        Singleton s = Singleton.getReference();
        System.out.println(s.getValue());
        Singleton s2 = Singleton.getReference();
        s2.setValue(9);
        System.out.println(s.getValue());
        try {
            // Can't do this: compile-time error.
            // Singleton s3 = (Singleton)s2.clone();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
