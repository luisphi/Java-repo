import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 * Pruebas de búsquedas con binarySearch y dejar los datos no repetdos de un array
 *
 */
public class BinarySearch1 {

	public static void main(String[] args) {
				
		String modulos[] = {"documento","comentario","compromiso","contacto","entidad","credito","proyecto","reunion","visita"};
		for(int i=0; i<modulos.length; i++){
			if(modulos[i].contains("contacto") ){
				System.out.println("encontrado");
				break;
			}
		}
		
		//Buscar la posición de un elemento en un array
		int idx = Arrays.binarySearch(modulos, "proyecto");		
		System.out.println("El valor es: " + idx);
		
		//Sacar solo los valores únicos
		int copro[] = {1,1,1,2,3,5,3};
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=0; i<copro.length; i++){
			hs.add(copro[i]);
		}				
				
		System.out.println(hs);

	}

}
