package Business;

import Domain.Character;
import Domain.Player;

public class ListBusiness {

	public ListBusiness() {
		
	}
	
	public static boolean equals(Object a, Object b){
		switch(instanceOf(a, b)){
        case "integer":
            Integer x=(Integer) a; Integer y=(Integer) b;
            return x==y;
        case "string":
            String v=(String) a; String w=(String) b;
            return v.compareToIgnoreCase(w)==0;
        case "character":
            Character c=(Character) a; Character d=(Character) b;
            return c.getName().equals(d.getName());
        case "player":
            Player m=(Player) a; Player n=(Player) b;
            return m.getUserName().equals(n.getUserName());
        
    }
		return false; 
	}
	
	public static String instanceOf(Object a, Object b){
        if(a instanceof Integer && b instanceof Integer) return "integer";
        if(a instanceof String && b instanceof String) return "string";
        if(a instanceof Character && b instanceof Character) return "character";
        if(a instanceof Player && b instanceof Player) return "player";
        return "unknown"; 
    }
	
}
