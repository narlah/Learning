package hackerRank;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.Permission;


public class SolutionPowerOf2Inner {

    public static void main(String[] args) throws Exception {
        DoNotTerminate.forbidExit();

        try {
            int num = 5;
            Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private

            SolutionPowerOf2Inner solution = new SolutionPowerOf2Inner();
            Class[] c = Inner.class.getDeclaredClasses();
            Class inner = c[0];
            Constructor ctor = inner.getDeclaredConstructors()[0];
            ctor.setAccessible(true);
            o = ctor.newInstance(new Inner());
            Method m = o.getClass().getDeclaredMethods()[0];
            m.setAccessible(true);

            System.out.println(num + " is " + m.invoke(o, num));
            //
            // System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

        }//end of try

        catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }//end of main

    static class Inner {
        private class Private {
            private String powerof2(int num) {
                return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }//end of Inner

}//end of Solution

class DoNotTerminate { //This class prevents exit(0)

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}
