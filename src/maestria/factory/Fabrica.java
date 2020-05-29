package maestria.factory;

import java.util.ResourceBundle;

public class Fabrica {
	
	public static Object getInstancia(String objName){
		try{
			
			ResourceBundle rb = ResourceBundle.getBundle("maestria.factory.factory");
			String nombreClase=rb.getString(objName);
			Object retorna=Class.forName(nombreClase).newInstance();
			return retorna;
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException();
			
		}
		
	}
}

