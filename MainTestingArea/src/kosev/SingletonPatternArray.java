package kosev;

final class SingletonArray {
    private static SingletonArray s = null;
    private int i;
    //private static final int FIXED_NUMBER= 10;

    private SingletonArray(int x) {
        i = x;
    }

    public static SingletonArray getReference() {
        if (s == null) {
            return new SingletonArray(47);
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
public class SingletonPatternArray {
    public static void main(String[] args) {
        SingletonArray s = SingletonArray.getReference();
        System.out.println(s.getValue());
        SingletonArray s2 = SingletonArray.getReference();
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