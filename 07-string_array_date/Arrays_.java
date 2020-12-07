import java.util.ArrayList;
import java.util.Arrays;

public class Arrays_ {

	public static void main(String[] args) {
		
		//Pasar de un array a un ArrayList
		String myArray[] = {"uno","dos","tres","cuatro","cinco"};
		ArrayList<String> transaccion = new ArrayList<String>(Arrays.asList(myArray));		
		ArrayList<String> contableid = new ArrayList<String>();
		
		System.out.println(transaccion);
		
		//Remover elementos de un arraylist		
		contableid.add("dos");
		contableid.add("cuatro");
		
		transaccion.removeAll(contableid);
		
		System.out.println(transaccion);
		
	}

}
