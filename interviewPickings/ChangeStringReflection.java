package interviewPickings;

import java.lang.reflect.Field;

public class ChangeStringReflection {

    public static void main(final String[] args) throws Exception {
        final String s = "Immutable String";
        System.out.println(s);

        final Class<String> type = String.class;
        final Field valueField = type.getDeclaredField("value");
        valueField.setAccessible(true);

        final char[] value = (char[]) valueField.get(s);
        value[0] = 'i';
        value[10] = 's';
        System.out.println(s);

        System.arraycopy("Mutable String".toCharArray(), 0, value, 0, 14);
        System.out.println(s);

        valueField.set(s, "Mutable String".toCharArray());
        System.out.println(s);
    }
}