package interviewPickings;

public class Ext2<T extends Runnable, String>{
    String s = "hello";
    public void r (T t){
        t.run();
    }
}
