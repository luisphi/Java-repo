/**
 * 
 * @author luispazymino Pruebas para la implementación de hilos en java
 *
 */

public class Test {

	public static void main(String[] args) {

		ThreadCount hilo1 = new ThreadCount(10);
		ThreadCountRemake hilo2 = new ThreadCountRemake(10);

		hilo1.start();
		hilo2.start();
	}

}
