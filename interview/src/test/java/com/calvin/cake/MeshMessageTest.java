package com.calvin.cake;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class MeshMessageTest {
	@Test
	public void test(){
		  Map<String, String[]> network = new HashMap<String, String[]>() {{
			    put("Min",     new String[] { "William", "Jayden", "Omar" });
			    put("William", new String[] { "Min", "Noam" });
			    put("Jayden",  new String[] { "Min", "Amelia", "Ren", "Noam" });
			    put("Ren",     new String[] { "Jayden", "Omar" });
			    put("Amelia",  new String[] { "Jayden", "Adam", "Miguel" });
			    put("Adam",    new String[] { "Amelia", "Miguel", "Sofia", "Lucas" });
			    put("Miguel",  new String[] { "Amelia", "Adam", "Liam", "Nathan" });
			    put("Noam",    new String[] { "Nathan", "Jayden", "William" });
			    put("Omar",    new String[] { "Ren", "Min", "Scott" });
			    put("Nathan",    new String[] { });
			    put("Sofia",    new String[] { });
			    put("Lucas",    new String[] { });
			    put("Liam",    new String[] { });
			    put("Scott",    new String[] { });
			}};
		MeshMessage.findPathBfs(network, "Jayden", "Adam");
//		List<String> result = MeshMessage.findPath(network, "Jayden", "Adam");
//		System.out.println(result);
	}
}
