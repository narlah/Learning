package archive;
import javax.script.*;
import java.util.*;

public class Parser {
    public static void main(String[] args) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("x", 2);
        vars.put("y", 1);
        vars.put("z", 3);
        vars.put("c", 8);
        System.out.println("result = "+engine.eval("x + y + z*c", new SimpleBindings(vars)));
    }
}