package archive;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;


public class ScriptEngineManagerTest {

	public static void main(String[] args) {
		//***************************f6**********************************
	       ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
	        Map<String, Object> vars = new HashMap<String, Object>();
	        vars.put("x", 2);
	        vars.put("y", 1);
	        vars.put("z", 3);
	        try {
				System.out.println("result = "+engine.eval("x * y * z", new SimpleBindings(vars)));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//***************************************************************
	}
}
// ***************************************************************
//System.out.println(Runtime.getRuntime().availableProcessors());
// ***************************************************************
