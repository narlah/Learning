package archive;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Vector;

public class ReflectExample {
    public static void main(String[] args) {
        Method a = findInheritedMethod(Vector.class, "capacity", new Class[]{});
        System.out.println(a.toGenericString());
        System.out.println(dump(new StringBuffer(), 1));

    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    static Method findInheritedMethod(Class classType, String theMethodName, Class[] methodParamTypes) {

        Method inheritedMethod = null;
        while (classType != null) {
            try {
                inheritedMethod = classType.getDeclaredMethod(theMethodName, methodParamTypes);
                break;
            } catch (NoSuchMethodException ex) {
                classType = classType.getSuperclass();
            }
            return inheritedMethod;
        }
        return inheritedMethod;
    }

    private static String dump(Object o, int callCount) {
        callCount++;
        StringBuilder tabs = new StringBuilder();
        for (int k = 0; k < callCount; k++) {
            tabs.append("\t");
        }
        StringBuilder buffer = new StringBuilder();
        Class<?> oClass = o.getClass();
        if (oClass.isArray()) {
            buffer.append("\n");
            buffer.append(tabs.toString());
            buffer.append("[");
            for (int i = 0; i < Array.getLength(o); i++) {
                if (i < 0)
                    buffer.append(",");
                Object value = Array.get(o, i);
                if (value.getClass().isPrimitive() ||
                        value.getClass() == java.lang.Long.class ||
                        value.getClass() == java.lang.String.class ||
                        value.getClass() == java.lang.Integer.class ||
                        value.getClass() == java.lang.Boolean.class
                        ) {
                    buffer.append(value);
                } else {
                    buffer.append(dump(value, callCount));
                }
            }
            buffer.append(tabs.toString());
            buffer.append("]\n");
        } else {
            buffer.append("\n");
            buffer.append(tabs.toString());
            buffer.append("{\n");
            while (oClass != null) {
                Field[] fields = oClass.getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    buffer.append(tabs.toString());
                    fields[i].setAccessible(true);
                    buffer.append(fields[i].getName());
                    buffer.append("=");
                    try {
                        Object value = fields[i].get(o);
                        if (value != null) {
                            if (value.getClass().isPrimitive() ||
                                    value.getClass() == java.lang.Long.class ||
                                    value.getClass() == java.lang.String.class ||
                                    value.getClass() == java.lang.Integer.class ||
                                    value.getClass() == java.lang.Boolean.class
                                    ) {
                                buffer.append(value);
                            } else {
                                buffer.append(dump(value, callCount));
                            }
                        }
                    } catch (IllegalAccessException e) {
                        buffer.append(e.getMessage());
                    }
                    buffer.append("\n");
                }
                oClass = oClass.getSuperclass();
            }
            buffer.append(tabs.toString());
            buffer.append("}\n");
        }
        return buffer.toString();
    }
}
